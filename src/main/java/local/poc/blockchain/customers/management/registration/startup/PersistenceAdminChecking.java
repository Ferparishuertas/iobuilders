package local.poc.blockchain.customers.management.registration.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import local.poc.blockchain.customers.management.registration.service.AdminService;

@Component
@Order(2)
public class PersistenceAdminChecking implements ApplicationRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceAdminChecking.class);
	
	@Autowired
	private AdminService adminService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if(!adminService.checkAnyAdminUser()) {
			LOGGER.info("No admin user was detected.");
			adminService.createDefaultAdminUser();
			LOGGER.info("Default admin user created.");
		}
	}

}
