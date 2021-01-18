package local.poc.blockchain.customers.management.registration.cucumber.naturalperson.newuser.validation;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/natural_person/validation",
        plugin = {"pretty", "json:target/cucumber-report-validation.json"})
public class NewUserValidationCucumberIntegrationTest {

}
