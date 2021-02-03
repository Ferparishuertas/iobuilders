package local.poc.blockchain.customers.management.registration.cucumber.naturalperson.newuser.validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import local.poc.blockchain.customers.management.registration.cucumber.naturalperson.newuser.common.UserCandidate;
import local.poc.blockchain.customers.management.registration.cucumber.util.RegistrationHttpClient;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class NewUserValidationCucumberStepDefinitions {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NewUserValidationCucumberStepDefinitions.class);
	
	@Autowired
	private RegistrationHttpClient httpClient;	
	
	// @Autowired
	private UserCandidate newUserCandidate = new UserCandidate();
	
	private String loadNewCandidate() throws IOException {
		File file = ResourceUtils.getFile("classpath:test_data/natural_person/validation/user/new_user.json");
		return new String(Files.readAllBytes(file.toPath()));
	}
	
	private String loadContactChannels(String ref) throws IOException {
		File file = ResourceUtils.getFile("classpath:test_data/natural_person/validation/contact_channels/" + ref + ".json");
		return new String(Files.readAllBytes(file.toPath()));
	}
	
	private String loadOfficialDocuments(String ref) throws IOException {
		File file = ResourceUtils.getFile("classpath:test_data/natural_person/validation/official_documents/" + ref + ".json");
		return new String(Files.readAllBytes(file.toPath()));
	}
	
	@Given("A new canditate fills the registration data")
	public void a_new_candidate_fills_the_registration_data() {
		JsonNode result = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			String newCandidate = loadNewCandidate();
			result = mapper.readTree(newCandidate);
		} catch (IOException e) {
			LOGGER.error("The candidate info could not be loaded.", e);
		}
		assertThat(result).isNotNull();
		LOGGER.info("A new canditate fills the registration data");
		newUserCandidate.setJsonCandidateData(result);
	}
	
	@But("The user name is {string}")
	public void the_user_name_is_username(String userName) {
		if("null".equals(userName)) {
			userName = null;
		}
		LOGGER.info("The user name is " + userName);
		JsonNode personalInfo = newUserCandidate.getJsonCandidateData().at("/personalInfo");
		((ObjectNode)personalInfo).put("name", userName);
	}
	
	@But("The user surname1 is {string}")
	public void the_user_surname1_is_username(String userSurname1) {
		if("null".equals(userSurname1)) {
			userSurname1 = null;
		}
		LOGGER.info("The user surname1 is " + userSurname1);
		JsonNode personalInfo = newUserCandidate.getJsonCandidateData().at("/personalInfo");
		((ObjectNode)personalInfo).put("surname1", userSurname1);
	}
	
	@But("The user sex is {int}")
	public void the_user_sex_is(Integer sex) {
		LOGGER.info("The user sex is " + sex);
		JsonNode personalInfo = newUserCandidate.getJsonCandidateData().at("/personalInfo");
		((ObjectNode)personalInfo).put("sex", sex);
	}
	
	@But("The user sex is {string}")
	public void the_user_sex_is(String sex) {
		if("null".equals(sex)) {
			sex = null;
		}
		LOGGER.info("The user sex is " + sex);
		JsonNode personalInfo = newUserCandidate.getJsonCandidateData().at("/personalInfo");
		((ObjectNode)personalInfo).put("sex", sex);
	}
	
	@But("The user birthdate is {string}")
	public void the_user_birthdate_is(String birthdate) {
		LOGGER.info("The user birthdate is " + birthdate);
		JsonNode personalInfo = newUserCandidate.getJsonCandidateData().at("/personalInfo");
		((ObjectNode)personalInfo).put("birthdate", birthdate);
	}
	
	@But("The user nationality is {int}")
	public void the_user_nationality_is(Integer nationality) {
		LOGGER.info("The user nationality is " + nationality);
		JsonNode personalInfo = newUserCandidate.getJsonCandidateData().at("/personalInfo");
		((ObjectNode)personalInfo).put("mainNationality", nationality);
	}
	
	@But("The user nationality is {string}")
	public void the_user_nationality_is(String nationality) {
		if("null".equals(nationality)) {
			nationality = null;
		}
		LOGGER.info("The user nationality is " + nationality);
		JsonNode personalInfo = newUserCandidate.getJsonCandidateData().at("/personalInfo");
		((ObjectNode)personalInfo).put("mainNationality", nationality);
	}
	
	@But("The user secondary nationalities are {string}")
	public void the_user_secondary_nationalities_are(String nationalities) {
		if("null".equals(nationalities)) {
			nationalities = null;
		}
		LOGGER.info("The user secondary nationalities are: " + nationalities);
		JsonNode personalInfo = newUserCandidate.getJsonCandidateData().at("/personalInfo");
		List<?> list = evalListStrExp(nationalities);
		if(list == null) {
			((ObjectNode)personalInfo).putNull("otherNationalities");
		} else {
			final ArrayNode arrayNode = ((ObjectNode)personalInfo).putArray("otherNationalities");
			list.forEach((nationality) -> {
				if(nationality == null) arrayNode.addNull();
				else if(Integer.class.equals(nationality.getClass())) arrayNode.add((Integer)nationality);
				else arrayNode.add((String)nationality);
			});
		}
	}
	
	@But("The user contact channels are {string}")
	public void the_user_contact_channels_are(String conntactChannelRef) throws IOException {
		JsonNode jsonNodeChannels = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			String strChannels = loadContactChannels(conntactChannelRef);
			jsonNodeChannels = mapper.readTree(strChannels);
		} catch (IOException e) {
			LOGGER.error("The channels info could not be loaded.", e);
			throw e;
		}
		LOGGER.info("The user contact channels are " + jsonNodeChannels.toString());
		JsonNode personalInfo = newUserCandidate.getJsonCandidateData().at("/personalInfo");
		((ObjectNode)personalInfo).replace("contactChannels", jsonNodeChannels);
	}
	
	@But("The user official documents are {string}")
	public void the_user_official_documents_are(String officialDocumentRef) throws IOException {
		JsonNode jsonNodeOfficialDocuments = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			String strOfficialDocuments = loadOfficialDocuments(officialDocumentRef);
			jsonNodeOfficialDocuments = mapper.readTree(strOfficialDocuments);
		} catch (IOException e) {
			LOGGER.error("The official documents info could not be loaded.", e);
			throw e;
		}
		LOGGER.info("The user official documents are " + jsonNodeOfficialDocuments.toString());
		JsonNode personalInfo = newUserCandidate.getJsonCandidateData().at("/personalInfo");
		((ObjectNode)personalInfo).replace("officialDocuments", jsonNodeOfficialDocuments);
	}
	
	@But("The user login alias is {string}")
	public void the_user_login_alias_is(String alias) {
		if("null".equals(alias)) {
			alias = null;
		}
		LOGGER.info("The user login alias is " + alias);
		JsonNode loginInfo = newUserCandidate.getJsonCandidateData().at("/loginInfo");
		((ObjectNode)loginInfo).put("alias", alias);
	}
	
	@But("The user login password is {string}")
	public void the_user_login_password_is_password(String password) {
		if("null".equals(password)) {
			password = null;
		}
		LOGGER.info("The user login password is " + password);
		JsonNode loginInfo = newUserCandidate.getJsonCandidateData().at("/loginInfo");
		((ObjectNode)loginInfo).put("password", password);
	}
	
	@But("The user login email is {string}")
	public void the_user_login_email_is_email(String email) {
		if("null".equals(email)) {
			email = null;
		}
		LOGGER.info("The user login email is " + email);
		JsonNode loginInfo = newUserCandidate.getJsonCandidateData().at("/loginInfo");
		((ObjectNode)loginInfo).put("email", email);
	}
	
	@But("The user login mobile is {string}")
	public void the_user_login_mobile_is_mobile(String mobile) {
		if("null".equals(mobile)) {
			mobile = null;
		}
		LOGGER.info("The user login mobile is " + mobile);
		JsonNode loginInfo = newUserCandidate.getJsonCandidateData().at("/loginInfo");
		((ObjectNode)loginInfo).put("mobile", mobile);
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
	
	private List<?> evalListStrExp(String exp) {
		List<?> result = null;
		if(exp != null) {
			Pattern pattern = Pattern.compile("^\\[(.*)\\]$");
			Matcher matcher = pattern.matcher(exp);
			if(matcher.find()) {
				String[] items = matcher.group(1).split(",");
				result = Arrays.stream(items)
							   .map(String::trim)
							   .map(x -> {
								   if(x.matches("\\d+")) return Integer.parseInt(x);
								   else if("null".equals(x)) return null;
								   else return x;
							   	})
							   	.collect(Collectors.toList());
			} else {
				result = new ArrayList<>();
			}
		}
		return result;
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
