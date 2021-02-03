package local.poc.blockchain.customers.management.registration.service.impl;

import static local.poc.blockchain.customers.management.registration.service.error.NaturalPersonServiceError.UNEXPECTED_ERROR;
import static local.poc.blockchain.customers.management.registration.service.error.NaturalPersonServiceError.USER_LOGIN_ALIAS_OR_EMAIL_FOUND;
import static local.poc.blockchain.customers.management.registration.service.error.NaturalPersonServiceError.USER_NOT_FOUND;
import static local.poc.blockchain.customers.management.registration.util.Global.longDistantFutureDate;
import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_ADDRESS;
import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_EMAIL;
import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_MESSENGER;
import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_TELEPHONE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import local.poc.blockchain.customers.management.registration.datobj.svo.ContactChannelAddressSVO;
import local.poc.blockchain.customers.management.registration.datobj.svo.ContactChannelEmailSVO;
import local.poc.blockchain.customers.management.registration.datobj.svo.ContactChannelMessengerSVO;
import local.poc.blockchain.customers.management.registration.datobj.svo.ContactChannelSVO;
import local.poc.blockchain.customers.management.registration.datobj.svo.ContactChannelTelephoneSVO;
import local.poc.blockchain.customers.management.registration.datobj.svo.LoginInfoSVO;
import local.poc.blockchain.customers.management.registration.datobj.svo.OptionListUserPersonSVO;
import local.poc.blockchain.customers.management.registration.datobj.svo.PersonOfficialDocumentSVO;
import local.poc.blockchain.customers.management.registration.datobj.svo.PersonalInfoSVO;
import local.poc.blockchain.customers.management.registration.datobj.svo.UserPersonInfoSVO;
import local.poc.blockchain.customers.management.registration.persistence.model.ContactAddress;
import local.poc.blockchain.customers.management.registration.persistence.model.ContactChannel;
import local.poc.blockchain.customers.management.registration.persistence.model.ContactEmail;
import local.poc.blockchain.customers.management.registration.persistence.model.ContactMessenger;
import local.poc.blockchain.customers.management.registration.persistence.model.ContactMessengerProvider;
import local.poc.blockchain.customers.management.registration.persistence.model.ContactTelephone;
import local.poc.blockchain.customers.management.registration.persistence.model.ContactTelephoneType;
import local.poc.blockchain.customers.management.registration.persistence.model.Country;
import local.poc.blockchain.customers.management.registration.persistence.model.DBReg;
import local.poc.blockchain.customers.management.registration.persistence.model.Person;
import local.poc.blockchain.customers.management.registration.persistence.model.PersonNationality;
import local.poc.blockchain.customers.management.registration.persistence.model.PersonOfficialDocument;
import local.poc.blockchain.customers.management.registration.persistence.model.PersonOfficialDocumentType;
import local.poc.blockchain.customers.management.registration.persistence.model.PersonSex;
import local.poc.blockchain.customers.management.registration.persistence.model.User;
import local.poc.blockchain.customers.management.registration.persistence.model.UserHolderPerson;
import local.poc.blockchain.customers.management.registration.persistence.repository.PersonRepository;
import local.poc.blockchain.customers.management.registration.persistence.repository.UserHolderPersonRepository;
import local.poc.blockchain.customers.management.registration.persistence.repository.UserRepository;
import local.poc.blockchain.customers.management.registration.service.NaturalPersonService;
import local.poc.blockchain.customers.management.registration.service.exception.NaturalPersonServiceException;

@Service
public class NaturalPersonServiceImpl implements NaturalPersonService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserHolderPersonRepository userHolderPersonRepository;

	@Override
	public Boolean registerNewUser(UserPersonInfoSVO userPersonInfo)
	throws NaturalPersonServiceException {	
		try {
			LoginInfoSVO loginInfo = userPersonInfo.getLoginInfo();
			boolean alreadyRegistered = userRepository.existsByLoginAlias(loginInfo.getAlias())
										|| userRepository.existsByLoginEmail(loginInfo.getEmail());
			if(alreadyRegistered) {
				throw new NaturalPersonServiceException(
					"Login alias or email currently used in the system.",
					USER_LOGIN_ALIAS_OR_EMAIL_FOUND);
			}
			
			PersonalInfoSVO personalInfo = userPersonInfo.getPersonalInfo();
			
			Person person = new Person();
			person.setBirthdate(personalInfo.getBirthdate());
			person.setSex(PersonSex.Ref.fromValue(personalInfo.getSex()));
			person.setName(personalInfo.getName());
			person.setMiddleName(personalInfo.getMiddleName());
			person.setSurname1(personalInfo.getSurname1());
			person.setSurname2(personalInfo.getSurname2());
			List<PersonNationality> nationalities = extractNationalities(personalInfo, person);
			person.setNationalities(nationalities);
			List<ContactChannel> contactChannels = extractContactChannels(personalInfo, person);
			person.setContactChannels(contactChannels);
			List<PersonOfficialDocument> officialDocuments =  extractOfficialDocuments(personalInfo, person);
			person.setOfficialDocuments(officialDocuments);
			person.setDbReg(
				new DBReg(getCurrentManager(), new Date(), null, null));
			person = personRepository.save(person);
			
			User user = new User();
			user.setLoginAlias(loginInfo.getAlias());
			user.setPassword(passwordEncoder.encode(loginInfo.getPassword()));
			user.setLoginEmail(loginInfo.getEmail());
			user.setMobile(loginInfo.getMobile());
			user.setExpirationDate(longDistantFutureDate());
			user.setCredentialExpirationDate(longDistantFutureDate());
			user.setAuthorities(Arrays.asList("ROLE_USER", "ROLE_USER_NATURAL_PERSON"));
			user.setEnabled(false);
			user.setLocked(false);
			user.setDescription(loginInfo.getDescription());
			user.setDbReg(
				new DBReg(getCurrentManager(), new Date(), null, null));
			user = userRepository.save(user);
			
			UserHolderPerson userHolder = new UserHolderPerson();
			userHolder.setPerson(person);
			userHolder.setUser(user);
			userHolder.setDbReg(
				new DBReg(getCurrentManager(), new Date(), null, null));
			userHolder = userHolderPersonRepository.save(userHolder);
		
		} catch(NaturalPersonServiceException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new NaturalPersonServiceException(
					"Unexpected error while registering a new natural person user.",
					ex,
					UNEXPECTED_ERROR);
		}
		return true;
	}
	
	@Override
	public List<OptionListUserPersonSVO> getUserList(String urlRoot)
	throws NaturalPersonServiceException {
		List<OptionListUserPersonSVO> result = null;
		try {
			if(urlRoot != null && !urlRoot.endsWith("/")) {
				urlRoot = urlRoot + "/";
			}
			result = new ArrayList<>();
			for(UserHolderPerson user : userHolderPersonRepository.findAll()) {
				OptionListUserPersonSVO svo = new OptionListUserPersonSVO();
				svo.setOption(user.getUser().getLoginAlias());
				svo.setAlias(user.getUser().getLoginAlias());
				svo.setEmail(user.getUser().getLoginEmail());
				svo.setUrl(urlRoot != null ? urlRoot + user.getUser().getLoginAlias(): null);
				result.add(svo);
			};
		} catch(Exception ex) {
			throw new NaturalPersonServiceException(
					"Unexpected error while getting the list of natural person users.",
					ex,
					UNEXPECTED_ERROR);
		}
		return result;
	}
	
	@Override
	public UserPersonInfoSVO getUser(String userLoginAlias) throws NaturalPersonServiceException {
		User user = userRepository.findOneByLoginAlias(userLoginAlias).orElseThrow(
				() -> new NaturalPersonServiceException("General user not found",
														USER_NOT_FOUND));
		UserHolderPerson userHolder = userHolderPersonRepository.findOneByUser(user);
		if(userHolder == null) {
			throw new NaturalPersonServiceException("Natural person user not found",
													USER_NOT_FOUND);
		}
		UserPersonInfoSVO result = null;
		try {
			Person person = userHolder.getPerson();
			result = new UserPersonInfoSVO();
			result.setPersonalInfo(extractPersonalInfo(person));
			result.setLoginInfo(extractLoginInfo(user));
		} catch(Exception ex) {
			throw new NaturalPersonServiceException(
					"Unexpected error while getting the list of natural person users.",
					ex,
					UNEXPECTED_ERROR);
		}
		return result;
	}
	
	private String getCurrentManager() {
		return Thread.currentThread().getName()
			   + "@" + this.getClass().getName();
	}
	
	private PersonalInfoSVO extractPersonalInfo(Person person) {
		PersonalInfoSVO result = new PersonalInfoSVO();
		result.setName(person.getName());
		result.setMiddleName(person.getMiddleName());
		result.setSurname1(person.getSurname1());
		result.setSurname2(person.getSurname2());
		result.setSex(person.getSex().getValue());
		result.setContactChannels(extractContactChannels(person));
		result.setPersonOfficialDocuments(extractOfficialDocuments(person));
		List<Long> nationalities = extractNationalities(person);
		result.setMainNationality(nationalities.stream().findFirst().get());
		result.setOtherNationalities(nationalities.stream().skip(1).collect(Collectors.toList()));
		return result;
	}
	
	private LoginInfoSVO extractLoginInfo(User user) {
		LoginInfoSVO result = new LoginInfoSVO();
		result.setAlias(user.getLoginAlias());
		result.setEmail(user.getLoginEmail());
		result.setPassword("*****"); // Password should not be revealed.
		result.setMobile(user.getMobile());
		result.setDescription(user.getDescription());
		return result;
	}
	
	private List<PersonNationality> extractNationalities(PersonalInfoSVO personalInfo, Person person) {
		List<Long> nationalitiesValues = new ArrayList<>();
		nationalitiesValues.add(personalInfo.getMainNationality());
		if(personalInfo.getOtherNationalities() != null) {
			personalInfo.getOtherNationalities().forEach(
				x -> {if(!nationalitiesValues.contains(x)){nationalitiesValues.add(x);}}
			);
		}
		List<PersonNationality> nationalities = new ArrayList<>();
		int level = 0;
		for(Long nationality : nationalitiesValues) {
			PersonNationality personNationality = new PersonNationality();
			personNationality.setDescription(level == 0 ? "main nationality" : "secondary nationality");
			personNationality.setCountry(Country.Ref.fromValue(nationality));
			personNationality.setPerson(person);
			personNationality.setLevelPosition(level);
			personNationality.setDbReg(
				new DBReg(getCurrentManager(), new Date(), null, null));
			++ level;
			nationalities.add(personNationality);
		}
		return nationalities;
	}
	
	private List<Long> extractNationalities(Person person) {
		return person.getNationalities()
				     .stream()
				     .map(PersonNationality::getCountry)
				     .map(Country.Ref::getValue)
				     .collect(Collectors.toList());
	}
	
	private List<ContactChannel> extractContactChannels(PersonalInfoSVO personalInfo, Person person) {
		List<ContactChannel> result = new ArrayList<>();
		for(ContactChannelSVO contactChannel : personalInfo.getContactChannels()) {
			Class<?> clazz = contactChannel.getClass();
			if(ContactChannelAddressSVO.class.equals(clazz)) {
				ContactChannelAddressSVO svo = (ContactChannelAddressSVO) contactChannel;
				ContactAddress contactAddress = new ContactAddress();
				// svo.getType(); => This channel does not have type.
				contactAddress.setValue(svo.getValue());
				contactAddress.setPostalCode(svo.getPostalCode());
				contactAddress.setCountry(Country.Ref.fromValue(svo.getCountry()));
				contactAddress.setLevelPosition(svo.getLevel());
				contactAddress.setDescription(svo.getDescription());
				contactAddress.setDbReg(
					new DBReg(getCurrentManager(), new Date(), null, null));
				result.add(contactAddress);
			} else if (ContactChannelEmailSVO.class.equals(clazz)) {
				ContactChannelEmailSVO svo = (ContactChannelEmailSVO) contactChannel;
				ContactEmail contactEmail = new ContactEmail();
				// svo.getType(); => This channel does not have type.
				contactEmail.setValue(svo.getValue());
				contactEmail.setLevelPosition(svo.getLevel());
				contactEmail.setDescription(svo.getDescription());
				contactEmail.setDbReg(
					new DBReg(getCurrentManager(), new Date(), null, null));
				result.add(contactEmail);
			} else if (ContactChannelMessengerSVO.class.equals(clazz)) {
				ContactChannelMessengerSVO svo = (ContactChannelMessengerSVO) contactChannel;
				ContactMessenger contactMessenger = new ContactMessenger();
				contactMessenger.setProvider(ContactMessengerProvider.Ref.fromValue(svo.getType()));
				contactMessenger.setValue(svo.getValue());
				contactMessenger.setLevelPosition(svo.getLevel());
				contactMessenger.setDescription(svo.getDescription());
				contactMessenger.setDbReg(
					new DBReg(getCurrentManager(), new Date(), null, null));
				result.add(contactMessenger);
			} else if (ContactChannelTelephoneSVO.class.equals(clazz)) {
				ContactChannelTelephoneSVO svo = (ContactChannelTelephoneSVO) contactChannel;
				ContactTelephone contactTelephone = new ContactTelephone();
				contactTelephone.setType(ContactTelephoneType.Ref.fromValue(svo.getType()));
				contactTelephone.setValue(svo.getValue());
				contactTelephone.setLevelPosition(svo.getLevel());
				contactTelephone.setDescription(svo.getDescription());
				contactTelephone.setDbReg(
					new DBReg(getCurrentManager(), new Date(), null, null));
				result.add(contactTelephone);
			} else {
				throw new IllegalArgumentException("Unknown contact channel from SVO.");
			}
		}
		return result;
	}
	
	private List<ContactChannelSVO> extractContactChannels(Person person) {
		List<ContactChannelSVO> result = new ArrayList<>();
		for(ContactChannel contactChannel : person.getContactChannels()) {
			ContactChannelSVO svo = null;
			Class<? extends ContactChannel> clazz = contactChannel.getClass();
			if (ContactAddress.class.equals(clazz)) {
				ContactAddress address = (ContactAddress)contactChannel;
				ContactChannelAddressSVO addressSVO = new ContactChannelAddressSVO();
				addressSVO.setChannel(CHANNEL_ADDRESS);
				addressSVO.setCountry(address.getCountry().getValue());
				addressSVO.setDescription(address.getDescription());
				addressSVO.setLevel(address.getLevelPosition());
				addressSVO.setPostalCode(address.getPostalCode());
				// addressSVO.setType(null); // This channel does not have type.
				addressSVO.setValue(address.getValue());
				svo = addressSVO;
			} else if (ContactEmail.class.equals(clazz)) {
				ContactEmail email = (ContactEmail)contactChannel;
				ContactChannelEmailSVO emailSVO = new ContactChannelEmailSVO();
				emailSVO.setChannel(CHANNEL_EMAIL);
				emailSVO.setDescription(email.getDescription());
				emailSVO.setLevel(email.getLevelPosition());
				// emailSVO.setType(null); // This channel does not have type.
				emailSVO.setValue(email.getValue());
				svo = emailSVO;
			} else if (ContactMessenger.class.equals(clazz)) {
				ContactMessenger messenger = (ContactMessenger)contactChannel;
				ContactChannelMessengerSVO messengerSVO = new ContactChannelMessengerSVO();
				messengerSVO.setChannel(CHANNEL_MESSENGER);
				messengerSVO.setDescription(messenger.getDescription());
				messengerSVO.setLevel(messenger.getLevelPosition());
				messengerSVO.setType(messenger.getProvider().getValue());
				messengerSVO.setValue(messenger.getValue());
				svo = messengerSVO;
			} else if (ContactTelephone.class.equals(clazz)) {
				ContactTelephone telephone = (ContactTelephone)contactChannel;
				ContactChannelTelephoneSVO telephoneSVO = new ContactChannelTelephoneSVO();
				telephoneSVO.setChannel(CHANNEL_TELEPHONE);
				telephoneSVO.setDescription(telephone.getDescription());
				telephoneSVO.setLevel(telephone.getLevelPosition());
				telephoneSVO.setType(telephone.getType().getValue());
				telephoneSVO.setValue(telephone.getValue());
				svo = telephoneSVO;
			} else {
				throw new IllegalArgumentException("Unknown contact channel from DB.");
			}
			result.add(svo);
		}
		return result;
	}
	
	private List<PersonOfficialDocument> extractOfficialDocuments(PersonalInfoSVO personalInfo, Person person) {
		List<PersonOfficialDocument> officialDocuments = new ArrayList<>();
		for(PersonOfficialDocumentSVO svo : personalInfo.getPersonOfficialDocuments()) {
			PersonOfficialDocument officialDocument = new PersonOfficialDocument();
			officialDocument.setCountry(Country.Ref.fromValue(svo.getCountry()));
			officialDocument.setDescription(svo.getDescription());
			officialDocument.setLevelPosition(svo.getLevel());
			officialDocument.setType(PersonOfficialDocumentType.Ref.fromValue(svo.getType()));
			officialDocument.setValidUntil(svo.getValidUntil());
			officialDocument.setValue(svo.getValue());
			officialDocument.setPerson(person);
			officialDocument.setDbReg(
				new DBReg(getCurrentManager(), new Date(), null, null));
			officialDocuments.add(officialDocument);
		}
		return officialDocuments;
	}
	
	private List<PersonOfficialDocumentSVO> extractOfficialDocuments(Person person) {
		List<PersonOfficialDocumentSVO> result = new ArrayList<>();
		for (PersonOfficialDocument officialDocument : person.getOfficialDocuments()) {
			PersonOfficialDocumentSVO svo = new PersonOfficialDocumentSVO();
			svo.setCountry(officialDocument.getCountry().getValue());
			svo.setDescription(officialDocument.getDescription());
			svo.setLevel(officialDocument.getLevelPosition());
			svo.setType(officialDocument.getType().getValue());
			svo.setValidUntil(officialDocument.getValidUntil());
			svo.setValue(officialDocument.getValue());
			result.add(svo);
		}
		return result;
	}

}
