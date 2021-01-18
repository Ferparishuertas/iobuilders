package local.poc.blockchain.customers.management.registration.datobj.dto;

import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_MESSENGER;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import local.poc.blockchain.customers.management.registration.datobj.validator.MessengerProviderIsSuitable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonTypeName("messenger")
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
@Data
public class ContactChannelMessengerDTO extends ContactChannelDTO {
	
	public ContactChannelMessengerDTO() {
		super();
		this.setChannel(CHANNEL_MESSENGER);
	}
	
	@NotNull(message = "The messenger provider (messenger type) is mandatory.")
	@MessengerProviderIsSuitable(message = "The messenger provider is not valid.")
	@JsonProperty("type")
	private Long type = null;
	
	@NotBlank(message = "The value for establishing a connection using the channel is mandatory")
	@Size(min = 6, max = 250, message = "The value for the messenger provider must be longer than 6 characters and shorter or equals to 250.")
	@JsonProperty("value")
	private String value = null;
	
}
