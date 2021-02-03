package local.poc.blockchain.customers.management.registration.cucumber.naturalperson.newuser.common;

import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Data;

@Data
// @Scope(SCOPE_CUCUMBER_GLUE)
public class UserCandidate {

	private JsonNode jsonCandidateData;
	
	private HttpResponse<?> responseFromServer;
	
	private String token;
	
	private String jwt;
	
}
