package local.poc.blockchain.customers.management.registration.service;

import local.poc.blockchain.customers.management.registration.service.exception.AdminServiceException;

public interface AdminService {
	
	public boolean checkAnyAdminUser();
	
	public void createDefaultAdminUser() throws AdminServiceException;
	
}
