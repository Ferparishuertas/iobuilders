package local.poc.blockchain.customers.management.registration.cucumber.naturalperson.newuser.registration;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import local.poc.blockchain.customers.management.registration.cucumber.naturalperson.newuser.common.NewUserCandidate;
import local.poc.blockchain.customers.management.registration.cucumber.util.RegistrationHttpClient;
import local.poc.blockchain.customers.management.registration.service.UserService;
import local.poc.blockchain.customers.management.registration.service.exception.NaturalPersonServiceException;
import local.poc.blockchain.customers.management.registration.service.exception.UserServiceException;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class NewUserRegistrationCucumberStepDefinitions {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NewUserRegistrationCucumberStepDefinitions.class);
	
	@Autowired
	private RegistrationHttpClient httpClient;
	
	@Autowired
	private UserService userService;
	
	// @Autowired
	private NewUserCandidate newUserCandidate = new NewUserCandidate();
	
	private String loadNewCandidate(String candidate) throws IOException {
		File file = ResourceUtils.getFile("classpath:test_data/natural_person/registration/user/" + candidate + ".json");
		return new String(Files.readAllBytes(file.toPath()));
	}
	
	private JsonNode loadNewCandidateJson(String candidate) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String newCandidate = loadNewCandidate(candidate);
		return mapper.readTree(newCandidate);
	}
	
	@Given("The canditate {string} fills the registration data")
	public void the_canditate_fills_the_registration_data(String candidate) {
		JsonNode result = null;
		try {
			result = loadNewCandidateJson(candidate);
		} catch (IOException e) {
			LOGGER.error("The candidate info could not be loaded.", e);
		}
		assertThat(result).isNotNull();
		LOGGER.info("The new canditate " + candidate + " fills the registration data");
		newUserCandidate.setJsonCandidateData(result);
	}
	
	@Given("The still pending of confirmation user {string}, he\\/she checks his\\/her token from his\\/her email.")
	public void the_still_pending_of_confirmation_user_he_she_checks_his_her_token_from_his_her_email(String candidate)
	throws UserServiceException {
		JsonNode jsonUserInfo = null;
		try {
			jsonUserInfo = loadNewCandidateJson(candidate);
		} catch (IOException e) {
			LOGGER.error("The candidate info could not be loaded.", e);
		}
		assertThat(jsonUserInfo).isNotNull();
		newUserCandidate.setJsonCandidateData(jsonUserInfo);
		String alias = jsonUserInfo.at("/loginInfo/alias").asText();
		String token = userService.getVerificationToken(alias);
		LOGGER.info("The user read the token from his/her email.");
    	newUserCandidate.setToken(token);
    	
	}
	
	@When("The candidate sends the registration data")
	public void the_candidate_sends_the_registration_data()
	throws IOException, InterruptedException {
		String str = newUserCandidate.getJsonCandidateData().toString();
		LOGGER.info("The candidate sends the registration data");
		HttpResponse<?> response = httpClient.postNewPersonUser(str);
		newUserCandidate.setResponseFromServer(response);
		assertThat(response).isNotNull();
	}
	
	@When("The still pending of confirmation user sends a {string} token.")
	public void the_still_pending_of_confirmation_user_sends_a_token(String correctness)
	throws NaturalPersonServiceException, UserServiceException, IOException, InterruptedException {
		String token = null;
	    if("right".equals(correctness)) {
	    	token = newUserCandidate.getToken();
	    } else {
	    	token = "00000000-0000-0000-0000-000000000000";
	    }
	    HttpResponse<?> response = httpClient.sendConfirmationToken(token);
	    newUserCandidate.setResponseFromServer(response);
	    assertThat(response).isNotNull();
	}
	
	@Then("The system returns an app envelop with: {string}, {string}, {int}, {int}, {string}")
	public void the_system_returns_an_app_envelop_with
	(String app, String version, Integer status, Integer code, String refPayload)
			throws JsonMappingException, JsonProcessingException {
		HttpResponse<?> response = newUserCandidate.getResponseFromServer();
		Object body = response.body();
		assertThat(body).isNotNull();
		JsonNode envelop = bodyToEnvelop(body);
		String resApp = envelop.get("app").asText();
		assertThat(resApp).isEqualTo(app);
		String resVersion = envelop.get("version").asText();
		assertThat(resVersion).isEqualTo(version);
		Integer resStatus = envelop.get("status").asInt();
		assertThat(resStatus).isEqualTo(status);
		Integer resCode = envelop.get("code").asInt();
		assertThat(resCode).isEqualTo(code);
		JsonNode jsonResPayload = envelop.get("payload");
		assertThat(jsonResPayload.isNull()).isFalse();
		JsonNode pendingPayload = pendingPayload(refPayload, jsonResPayload);
		assertThat(pendingPayload).isNull();
	}
	
	private JsonNode bodyToEnvelop(Object body)
	throws JsonMappingException, JsonProcessingException {
		assertThat(body).isNotNull();
		assertThat(body.getClass()).isEqualTo(String.class);
		LOGGER.info("--##-- ----- ----- ----- BODY ----- ----- ----- --=> " + body);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readTree((String)body);
	}
	
	private JsonNode pendingPayload(String refPayloads, JsonNode currPayload)
	throws JsonMappingException, JsonProcessingException {
		JsonNode result = currPayload;
		final ObjectMapper mapper = new ObjectMapper();
		for(String refPayload : refPayloads.split("~")) {
			JsonNode jsonRefPaylod = mapper.readTree(refPayload);
			if(currPayload.equals(jsonRefPaylod)) {
				result = null;
				break;
			}
		}
		return result;
	}

}
