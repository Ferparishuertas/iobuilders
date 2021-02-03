package local.poc.blockchain.customers.management.registration.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.poc.blockchain.customers.management.registration.controller.APIControllerHelper.APIResponse;
import local.poc.blockchain.customers.management.registration.datobj.dto.OptionDTO;
import local.poc.blockchain.customers.management.registration.datobj.dto.ResponseEnvelope;

@RestController
@RequestMapping("/ureg/v1")
@Validated
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseEnvelope<?>> login() {
		LOGGER.info(" * login invoked *");
		List<OptionDTO> options =
			Arrays.asList(new OptionDTO("[POST]{alias:..., password:...}", "#/pass"));
		return APIResponse.payload(options).code(0).ok().build();
	}
	
}
