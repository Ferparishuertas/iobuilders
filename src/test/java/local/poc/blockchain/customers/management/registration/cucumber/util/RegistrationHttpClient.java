package local.poc.blockchain.customers.management.registration.cucumber.util;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class RegistrationHttpClient {

    private final String SERVER_URL = "http://localhost";
    private final String REGISTRATION_ENDPOINT = "/ureg/v1";
    private final String REGISTRATION_SERVICE_NEW_PERSON_USER = "/GLOBAL/person/new";
    private final String REGISTRATION_SERVICE_SEND_CONFIRMATION_TOKEN = "/GLOBAL/person/new/verification/registrationConfirm";

    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    
    // @LocalServerPort
    private int port = 8080;

    private String thingsEndpoint(String service) {
        return SERVER_URL + ":" + port + REGISTRATION_ENDPOINT + service;
    }

    public HttpResponse<?> postNewPersonUser(final String something)
    throws IOException, InterruptedException {
    	HttpRequest request = HttpRequest.newBuilder()
							                .POST(HttpRequest.BodyPublishers.ofString(something))
							                .uri(URI.create(thingsEndpoint(REGISTRATION_SERVICE_NEW_PERSON_USER)))
							                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
							                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
							                .build();
    	return HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
    }
    
    public HttpResponse<?> sendConfirmationToken(final String token)
    throws IOException, InterruptedException {
    	HttpRequest request = HttpRequest.newBuilder()
							                .GET()
							                .uri(URI.create(thingsEndpoint(REGISTRATION_SERVICE_SEND_CONFIRMATION_TOKEN
							                	+ "?token=" + token)))
							                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
							                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
							                .build();
    	return HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
    }

}
