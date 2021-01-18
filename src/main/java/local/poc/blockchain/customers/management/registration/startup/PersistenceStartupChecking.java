package local.poc.blockchain.customers.management.registration.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import local.poc.blockchain.customers.management.registration.service.RefCheckerService;

@Component
@Order(1)
public class PersistenceStartupChecking implements ApplicationRunner {
	
	@Autowired
	private RefCheckerService refCheckerService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// Check that the ref tables contains the references registered in the
		// enums of this application.
		refCheckerService.checkAll();
	}
	
}
