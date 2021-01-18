package local.poc.blockchain.customers.management.registration.datobj.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OptionsDTO {
	
	@JsonProperty("option")
	private String option;

	@JsonProperty("url")
	private String url;
	
}
