package local.poc.blockchain.customers.management.registration.datobj.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OptionListUserPersonDTO {
	
	@JsonProperty("option")
	private String option;
	
	@JsonProperty("loginAlias")
	private String alias;
	
	@JsonProperty("loginEmail")
	private String email;

	@JsonProperty("url")
	private String url;
	
}
