package local.poc.blockchain.customers.management.registration.datobj.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import local.poc.blockchain.customers.management.registration.datobj.validator.LoginAliasIsNotPresent;
import local.poc.blockchain.customers.management.registration.datobj.validator.LoginEmailIsNotPresent;
import local.poc.blockchain.customers.management.registration.datobj.validator.PasswordConstraint;
import lombok.Data;

@Data
public class LoginInfoDTO {
	
	@NotNull(message = "The login alias is mandatory.")
	@Size(min=3, max=50, message = "The login alias must be between 3 and 50 characters long.")
	@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9_]+", message = "The login alias must start with a letter followed by a combination of _, a-z, A-Z, 0-9")
	@LoginAliasIsNotPresent(message = "The login alias was used before.")
	@JsonProperty("alias")
	private String alias;

	@NotBlank(message = "The login password is mandatory")
	@PasswordConstraint(message = "It is not a valid password.")
	@JsonProperty("password")
	private String password;

	@NotBlank(message = "The login email is mandatory.")
	@Email(message = "A valid email address must be specified for the login email.")
	@LoginEmailIsNotPresent(message = "The login email address was used before.")
	@JsonProperty("email")
	private String email;

	@Pattern(regexp = "^((\\+)|(00))\\d{6,15}$",
			message = "Mobile telephone number must be +YYXXXXXXX or 00YYXXXXXXX. YY = Country's prefix and XXXXXXX = number (6 to 15 digits).")
	@JsonProperty("mobile")
	private String mobile = null;
	
	@Size(min = 0, max = 500)
	@JsonProperty("description")
	private String description = null;
	
}
