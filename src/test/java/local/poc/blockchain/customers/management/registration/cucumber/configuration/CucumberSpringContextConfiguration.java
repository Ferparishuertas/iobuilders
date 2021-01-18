package local.poc.blockchain.customers.management.registration.cucumber.configuration;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import local.poc.blockchain.customers.management.RegistrationApplication;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("local")
@ContextConfiguration(classes = RegistrationApplication.class)
public abstract class CucumberSpringContextConfiguration {

}