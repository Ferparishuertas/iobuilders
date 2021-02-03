package local.poc.blockchain.customers.management.registration.controller;

import static local.poc.blockchain.customers.management.registration.controller.APIControllerHelper.optionListUserPersonSVOtoDTO;
import static local.poc.blockchain.customers.management.registration.controller.APIControllerHelper.userPersonInfoDTOtoSVO;
import static local.poc.blockchain.customers.management.registration.controller.APIControllerHelper.userPersonInfoSVOtoDTO;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import local.poc.blockchain.customers.management.registration.appevent.OnRegistrationNaturalPersonCompleteEvent;
import local.poc.blockchain.customers.management.registration.controller.APIControllerHelper.APIResponse;
import local.poc.blockchain.customers.management.registration.datobj.dto.OptionListUserPersonDTO;
import local.poc.blockchain.customers.management.registration.datobj.dto.OptionDTO;
import local.poc.blockchain.customers.management.registration.datobj.dto.ResponseEnvelope;
import local.poc.blockchain.customers.management.registration.datobj.dto.UserPersonInfoDTO;
import local.poc.blockchain.customers.management.registration.datobj.svo.OptionListUserPersonSVO;
import local.poc.blockchain.customers.management.registration.datobj.svo.UserPersonInfoSVO;
import local.poc.blockchain.customers.management.registration.datobj.validator.UnitIsPresent;
import local.poc.blockchain.customers.management.registration.service.NaturalPersonService;
import local.poc.blockchain.customers.management.registration.service.UserService;
import local.poc.blockchain.customers.management.registration.service.exception.NaturalPersonServiceException;
import local.poc.blockchain.customers.management.registration.service.exception.UserServiceException;

@RestController
@RequestMapping("/ureg/v1")
@Validated
public class APIController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(APIController.class);
	
	@Autowired
	private NaturalPersonService naturalPersonService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	// Entry point for registration
	@GetMapping(value = "/{unit}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseEnvelope<?>>
	getRegistrationMain(
			@PathVariable("unit") @Valid @UnitIsPresent String unit) {
		LOGGER.info(" * getRegistrationMain invoked *");
		List<OptionDTO> options = Arrays.asList(
			new OptionDTO("person", "#/ureg/v1/" + unit + "/person"),
			new OptionDTO("corporation", "#/ureg/v1/" + unit + "/corporation")
		);
		return APIResponse.payload(options).code(0).ok().build();
	}
	
	// Options for registration of people
	@GetMapping(value = "/{unit}/person", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseEnvelope<?>> getRegistrationPerson(
			@PathVariable("unit") @UnitIsPresent String unit) {
		LOGGER.info(" * getRegistrationPerson invoked *");
		List<OptionDTO> options = Arrays.asList(
			new OptionDTO("new", "#/ureg/v1/" + unit + "/person/new"),
			new OptionDTO("list", "#/ureg/v1/" + unit + "/person/list")
		);
		return APIResponse.payload(options).code(0).ok().build();
	}
	
	// Register new user
	@PostMapping(value = "/{unit}/person/new",
				 consumes =   {MediaType.APPLICATION_JSON_VALUE,
						 	   MediaType.MULTIPART_FORM_DATA_VALUE },
				 produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseEnvelope<?>>
	exeRegistrationPersonNew(
			@PathVariable("unit") @UnitIsPresent String unit,
			@RequestBody @Valid UserPersonInfoDTO user,
			HttpServletRequest request) 
					throws NaturalPersonServiceException {
		LOGGER.info(" * exeRegistrationPersonNew invoked *");
		UserPersonInfoSVO svo = userPersonInfoDTOtoSVO(user);
    	naturalPersonService.registerNewUser(svo);
    	String url = request.getContextPath();
    	String userLoginAlias = svo.getLoginInfo().getAlias();
    	String userLoginEmail = svo.getLoginInfo().getEmail();
    	OnRegistrationNaturalPersonCompleteEvent regEvent
    		= new OnRegistrationNaturalPersonCompleteEvent(userLoginAlias, userLoginEmail, url, false);
    	applicationEventPublisher.publishEvent(regEvent);
    	return APIResponse.payload("User recorded in the system.").code(0).ok().build();
	}
	
	// Regenerate token
	@GetMapping(value = "/{unit}/person/new/verification/tokenRegeneration",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseEnvelope<?>>
	regenarateTokenRegistrationPersonNew(
			@PathVariable("unit") @UnitIsPresent String unit,
			@RequestParam("userAlias") String userAlias,
			HttpServletRequest request) throws NaturalPersonServiceException {
		LOGGER.info(" * regenarateTokenRegistrationPersonNew invoked *");
		String url = request.getContextPath();
		String userLoginEmail = naturalPersonService.getUser(userAlias).getLoginInfo().getEmail();
    	OnRegistrationNaturalPersonCompleteEvent regEvent
    		= new OnRegistrationNaturalPersonCompleteEvent(userAlias, userLoginEmail, url, true);
    	applicationEventPublisher.publishEvent(regEvent);
    	return APIResponse.payload("Token regenerated correctly.").code(0).ok().build();
	}
	
	// Registration confirmation
	@GetMapping(value = "/{unit}/person/new/verification/registrationConfirm",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseEnvelope<?>>
	confirmRegistrationPersonNew(
			@PathVariable("unit") @UnitIsPresent String unit,
			@RequestParam("token") String token)
					throws UserServiceException {
		LOGGER.info(" * confirmRegistrationPersonNew invoked *");
		userService.enableUserForVerificationToken(token);
    	// TODO Review
    	return APIResponse.payload("User registration verified.").code(0).ok().build();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/{unit}/person/list",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseEnvelope<?>> 
	getRegistrationPersonList(
			@PathVariable("unit") @UnitIsPresent String unit)
					throws NaturalPersonServiceException {
		LOGGER.info(" * getRegistrationPersonList invoked *");
    	List<OptionListUserPersonSVO> usersSVO =
    		naturalPersonService.getUserList("#/ureg/v1/" + unit + "/person/list/");
    	List<OptionListUserPersonDTO> usersDTO =
    		usersSVO.stream().map(x -> optionListUserPersonSVOtoDTO(x)).collect(Collectors.toList());
    	// TODO Review
    	return APIResponse.payload(usersDTO).code(0).ok().build();
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER_NATURAL_PERSON')")
	@GetMapping(value = "/{unit}/person/list/{userAlias}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseEnvelope<?>>
	getRegistrationPersonRegInfo(
			@PathVariable("unit") @UnitIsPresent String unit,
			@PathVariable("userAlias") String userAlias,
			HttpServletRequest request)
					throws UserServiceException, NaturalPersonServiceException {
		LOGGER.info(" * getRegistrationPersonRegInfo invoked *");
		Principal principal = request.getUserPrincipal();
		String userName = principal.getName();
		if(!userService.isAdminUser(userName) && !userName.equals(userAlias)) {
			throw new SecurityException(
				"The user " + userName + " is trying to access the info of user: "
				+ userAlias + ".");
		}
		UserPersonInfoSVO userSVO = naturalPersonService.getUser(userAlias);
	    UserPersonInfoDTO userDTO = userPersonInfoSVOtoDTO(userSVO);
	    // TODO Review
	    return APIResponse.payload(userDTO).code(0).ok().build();
	}
	
	@GetMapping(value = "/{unit}/corporation",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseEnvelope<?>> getRegistrationCorporation() {
		LOGGER.info("getRegistrationCorporation invoked");
		throw new UnsupportedOperationException("This service is not available yet.");
	}
	
	@GetMapping(value = "/{unit}/check_login/alias/{alias}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseEnvelope<?>>
	checkLoginAlias(
			@PathVariable("unit") @Valid @UnitIsPresent String unit,
			@PathVariable("alias") String alias) {
		LOGGER.info(" * checkLoginAlias invoked *");
		Boolean result = userService.checkUserLoginAliasAndEmail(alias, null);
		return APIResponse.payload(result).code(0).ok().build();
	}
	
	@GetMapping(value = "/{unit}/check_login/email/{email}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseEnvelope<?>>
	checkLoginEmail(
			@PathVariable("unit") @Valid @UnitIsPresent String unit,
			@PathVariable("email") String email) {
		LOGGER.info(" * checkLoginEmail invoked *");
		Boolean result = userService.checkUserLoginAliasAndEmail(null, email);
		return APIResponse.payload(result).code(0).ok().build();
	}
	
}
