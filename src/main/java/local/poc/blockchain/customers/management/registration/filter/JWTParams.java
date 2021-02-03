package local.poc.blockchain.customers.management.registration.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class JWTParams {
	
	@Value("${security.jwt.secret}")
	private String secret;
	
	@Value("${security.jwt.expiration}")
	private Long expirationDate;
	
}
