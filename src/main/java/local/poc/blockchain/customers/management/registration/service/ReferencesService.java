package local.poc.blockchain.customers.management.registration.service;

import java.util.List;

import local.poc.blockchain.customers.management.registration.datobj.svo.ReferenceSVO;

/**
 * The service related to reference values or reference-like values
 * (i.e. Values without too much complex operations associated to
 *  them, for which, create a separated service for them does not
 *  worth. For example, the unit variable in the rest services. If
 *  they evolve to a much more specific and complex domain, so they
 *  would need to increase the number of operations and/or complexity
 *  over them, then a new service exclusive for them should be
 *  created.)
 * @author Guillermo Fernández
 *
 */
public interface ReferencesService {
	
	public boolean isUnitPresent(String unit);
	
	public boolean isValidMessengerProvider(String messenger);
	
	public boolean isValidMessengerProvider(Long value);
	
	public boolean isValidTelephoneType(String telephoneType);
	
	public boolean isValidTelephoneType(Long value);
	
	public boolean isValidCountry(String alpha3);
	
	public boolean isValidCountry(Long country);
	
	public boolean isValidPersonOfficialDocumentType(String personOfficialDocument);
	
	public boolean isValidPersonOfficialDocumentType(Long value);
	
	public boolean isValidPersonSex(String sex);
	
	public boolean isValidPersonSex(Long value);
	
	public List<ReferenceSVO> getRefMessengerProviders();
	
	public List<ReferenceSVO> getRefTelephoneTypes();
	
	public List<ReferenceSVO> getRefCountries();
	
	public List<ReferenceSVO> getRefPersonOffcialDocumentTypes();
	
	public List<ReferenceSVO> getRefPersonSex();
	
}
