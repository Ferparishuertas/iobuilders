package local.poc.blockchain.customers.management.registration.datobj.dto;

import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_TELEPHONE;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import local.poc.blockchain.customers.management.registration.datobj.validator.TelephoneTypeIsSuitable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonTypeName("telephone")
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
@Data
public class ContactChannelTelephoneDTO extends ContactChannelDTO {
	
	public ContactChannelTelephoneDTO() {
		super();
		this.setChannel(CHANNEL_TELEPHONE);
	}
	
	@NotNull(message = "The telephone type is madatory.")
	@TelephoneTypeIsSuitable(message = "The telephone type is not correct.")
	@JsonProperty("type")
	private Long type = null;
	
	@NotBlank(message = "The value for establishing a connection using the channel is mandatory")
	@Size(min = 6, max = 250, message = "The value for the telephone must be longer than 6 characters and shorter or equals to 250.")
	@JsonProperty("value")
	private String value = null;

}
