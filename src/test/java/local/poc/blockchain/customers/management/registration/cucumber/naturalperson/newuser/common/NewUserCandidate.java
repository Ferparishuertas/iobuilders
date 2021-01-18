package local.poc.blockchain.customers.management.registration.cucumber.naturalperson.newuser.common;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import java.net.http.HttpResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Data;

@Data
@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class NewUserCandidate {

	private JsonNode jsonCandidateData;
	
	private HttpResponse<?> responseFromServer;
	
	private String token;
	
}
