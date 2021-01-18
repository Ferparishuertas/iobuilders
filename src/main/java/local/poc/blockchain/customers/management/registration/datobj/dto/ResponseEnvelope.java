package local.poc.blockchain.customers.management.registration.datobj.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseEnvelope<T> {
	
	@JsonProperty("app")
	private String app = "poc-registration";
	
	@JsonProperty("version")
	private String version = "1.0";

	@JsonProperty("status")
	private Integer status;

	@JsonProperty("code")
	private Integer code;
	
	@JsonProperty("payload")
	private T payload;

	@JsonProperty("devMsg")
	private String devMsg;

	@JsonProperty("timestamp")
	private String timestamp;
	
}
