package local.poc.blockchain.customers.management.registration.datobj.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReferenceDTO {

	@JsonProperty("value")
	private Long value;

	@JsonProperty("label")
	private String label;

}
