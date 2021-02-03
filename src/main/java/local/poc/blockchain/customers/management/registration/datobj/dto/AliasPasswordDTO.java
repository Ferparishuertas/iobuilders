package local.poc.blockchain.customers.management.registration.datobj.dto;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AliasPasswordDTO {
	
	@NotEmpty(message = "The login alias is mandatory.")
	@JsonProperty("alias")
	private String alias;
	
	@NotEmpty(message = "The password is mandatory.")
	@JsonProperty("password")
	private String password;
	
}
