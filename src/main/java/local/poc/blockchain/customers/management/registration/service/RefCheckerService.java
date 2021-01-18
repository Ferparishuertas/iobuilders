package local.poc.blockchain.customers.management.registration.service;

import local.poc.blockchain.customers.management.registration.service.exception.RefCheckerServiceException;

/**
 * 
 * Service for checking if the values used by this application
 * from the reference tables are included in the database. If
 * they are not included, it includes them.
 * 
 * @author Guillermo Fernández
 *
 */
public interface RefCheckerService {

	void checkForContactMessengerProviderRepository(boolean insertIfNotFound)
	throws RefCheckerServiceException;

	void checkForContactTelephoneTypeRepository(boolean insertIfNotFound)
	throws RefCheckerServiceException;

	void checkForCorporationOfficialDocumentTypeRepository(boolean insertIfNotFound)
	throws RefCheckerServiceException;

	void checkForCorporationTypeRepository(boolean insertIfNotFound)
	throws RefCheckerServiceException;

	void checkForCountryRepository(boolean insertIfNotFound)
	throws RefCheckerServiceException;

	void checkForPersonOfficialDocumentTypeRepository(boolean insertIfNotFound)
	throws RefCheckerServiceException;
	
	void checkForPersonSexRepository(boolean insertIfNotFound)
	throws RefCheckerServiceException;

	void checkAll() throws RefCheckerServiceException;

}