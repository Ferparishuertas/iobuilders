package local.poc.blockchain.customers.management.registration.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import local.poc.blockchain.customers.management.registration.datobj.svo.ReferenceSVO;
import local.poc.blockchain.customers.management.registration.persistence.model.ContactMessengerProvider;
import local.poc.blockchain.customers.management.registration.persistence.model.ContactTelephoneType;
import local.poc.blockchain.customers.management.registration.persistence.model.Country;
import local.poc.blockchain.customers.management.registration.persistence.model.PersonOfficialDocumentType;
import local.poc.blockchain.customers.management.registration.persistence.model.PersonSex;
import local.poc.blockchain.customers.management.registration.persistence.repository.ContactMessengerProviderRepository;
import local.poc.blockchain.customers.management.registration.persistence.repository.ContactTelephoneTypeRepository;
import local.poc.blockchain.customers.management.registration.persistence.repository.CountryRepository;
import local.poc.blockchain.customers.management.registration.persistence.repository.PersonOfficialDocumentTypeRepository;
import local.poc.blockchain.customers.management.registration.persistence.repository.PersonSexRepository;
import local.poc.blockchain.customers.management.registration.service.ReferencesService;

@Service
public class ReferencesServiceImpl implements ReferencesService {
	
	@Autowired
	private ContactMessengerProviderRepository messengerProviderRepository;
	
	@Autowired
	private ContactTelephoneTypeRepository telephoneTypeRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private PersonOfficialDocumentTypeRepository personOfficialDocumentTypeRepository;
	
	@Autowired
	private PersonSexRepository personSexRepository;

	@Override
	public boolean isUnitPresent(String unit) {
		return "global".equalsIgnoreCase(unit);
	}
	
	@Override
	public boolean isValidMessengerProvider(String messenger) {
		return messengerProviderRepository.findOneByName(messenger).isPresent();
	}

	@Override
	public boolean isValidMessengerProvider(Long value) {
		return messengerProviderRepository.findById(value).isPresent();
	}

	@Override
	public boolean isValidTelephoneType(String telephoneType) {
		return telephoneTypeRepository.findOneByName(telephoneType).isPresent();
	}

	@Override
	public boolean isValidTelephoneType(Long value) {
		return telephoneTypeRepository.findById(value).isPresent();
	}
	
	@Override
	public boolean isValidCountry(String alpha3) {
		return countryRepository.findOneByAlpha3(alpha3).isPresent();
	}

	@Override
	public boolean isValidCountry(Long value) {
		return countryRepository.findById(value).isPresent();
	}

	@Override
	public boolean isValidPersonOfficialDocumentType(String personOfficialDocument) {
		return personOfficialDocumentTypeRepository.findOneByName(personOfficialDocument).isPresent();
	}

	@Override
	public boolean isValidPersonOfficialDocumentType(Long value) {
		return personOfficialDocumentTypeRepository.findById(value).isPresent();
	}
	
	@Override
	public boolean isValidPersonSex(String sex) {
		return personSexRepository.findOneByName(sex).isPresent();
	}

	@Override
	public boolean isValidPersonSex(Long value) {
		return personSexRepository.findById(value).isPresent();
	}

	@Override
	public List<ReferenceSVO> getRefMessengerProviders() {
		List<ReferenceSVO> result = new ArrayList<>();
		for(ContactMessengerProvider x : messengerProviderRepository.findAll()) {
			result.add(new ReferenceSVO(x.getId(), x.getName()));
		}
		return result;
	}

	@Override
	public List<ReferenceSVO> getRefTelephoneTypes() {
		List<ReferenceSVO> result = new ArrayList<>();
		for( ContactTelephoneType x : telephoneTypeRepository.findAll()) {
			result.add(new ReferenceSVO(x.getId(), x.getName()));
		}
		return result;
	}

	@Override
	public List<ReferenceSVO> getRefCountries() {
		List<ReferenceSVO> result = new ArrayList<>();
		for(Country x : countryRepository.findAll()) {
			result.add(new ReferenceSVO(x.getId(), x.getAlpha3()));
		}
		return result;
	}

	@Override
	public List<ReferenceSVO> getRefPersonOffcialDocumentTypes() {
		List<ReferenceSVO> result = new ArrayList<>();
		for(PersonOfficialDocumentType x : personOfficialDocumentTypeRepository.findAll()) {
			result.add(new ReferenceSVO(x.getId(), x.getName()));
		}
		return result;
	}

	@Override
	public List<ReferenceSVO> getRefPersonSex() {
		List<ReferenceSVO> result = new ArrayList<>();
		for(PersonSex x : personSexRepository.findAll()) {
			result.add(new ReferenceSVO(x.getId(), x.getName()));
		}
		return result;
	}
	
}
