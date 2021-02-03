package local.poc.blockchain.customers.management.registration.datobj.dto;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserPersonInfoDTO {
	
	@Valid
	@JsonProperty("personalInfo")
	private PersonalInfoDTO personalInfo;
	
	@Valid
	@JsonProperty("loginInfo")
	private LoginInfoDTO loginInfo;
	
}
