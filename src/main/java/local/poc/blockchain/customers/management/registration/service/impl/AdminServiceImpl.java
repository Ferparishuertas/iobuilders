package local.poc.blockchain.customers.management.registration.service.impl;

import static local.poc.blockchain.customers.management.registration.service.error.AdminServiceError.UNEXPECTED_ERROR;
import static local.poc.blockchain.customers.management.registration.util.Global.longDistantFutureDate;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import local.poc.blockchain.customers.management.registration.persistence.model.DBReg;
import local.poc.blockchain.customers.management.registration.persistence.model.User;
import local.poc.blockchain.customers.management.registration.persistence.repository.UserRepository;
import local.poc.blockchain.customers.management.registration.service.AdminService;
import local.poc.blockchain.customers.management.registration.service.exception.AdminServiceException;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Value("${security.admin.login.defaultalias}")
	private String defaultAdminLoginAlias;
	
	@Value("${security.admin.login.defaultpass}")
	private String defaultAdminLoginPassword;
	
	@Value("${security.admin.login.defaultemail}")
	private String defaultAdminLoginEmail;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	private String getCurrentManager() {
		return Thread.currentThread().getName()
			   + "@" + this.getClass().getName();
	}
	
	@Override
	public boolean checkAnyAdminUser() {
		return userRepository.isThereAnyAdmin();
	}

	@Override
	public void createDefaultAdminUser() throws AdminServiceException {
		try {
			User adminUser = new User();
			adminUser.setLoginAlias(defaultAdminLoginAlias);
			adminUser.setLoginEmail(defaultAdminLoginEmail);
			adminUser.setPassword(passwordEncoder.encode(defaultAdminLoginPassword));
			adminUser.setExpirationDate(longDistantFutureDate());
			adminUser.setCredentialExpirationDate(longDistantFutureDate());
			adminUser.setDescription("This is the default admin.");
			adminUser.setEnabled(true);
			adminUser.setLocked(false);
			adminUser.setMobile(null);
			adminUser.setAuthorities(Arrays.asList("ROLE_ADMIN"));
			adminUser.setDbReg(
				new DBReg(getCurrentManager(), new Date(), null, null));
			userRepository.save(adminUser);
		} catch(Exception ex) {
			throw new AdminServiceException(
					"Unexpected error while registering a new natural person user.",
					ex,
					UNEXPECTED_ERROR);
		}
	}

}
