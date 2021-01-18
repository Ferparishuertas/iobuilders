package local.poc.blockchain.customers.management.registration.datobj.dto;


import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_ADDRESS;
import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_EMAIL;
import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_MESSENGER;
import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_TELEPHONE;
import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_UNKNOWN;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import local.poc.blockchain.customers.management.registration.datobj.common.ContactChannelWithUser;
import lombok.Data;

@JsonTypeInfo (use = JsonTypeInfo.Id.NAME, include = As.EXISTING_PROPERTY, property = "channel")
@JsonSubTypes ({@Type (value = ContactChannelAddressDTO.class, name = CHANNEL_ADDRESS),
				@Type (value = ContactChannelEmailDTO.class, name = CHANNEL_EMAIL),
				@Type (value = ContactChannelMessengerDTO.class, name = CHANNEL_MESSENGER),
				@Type (value = ContactChannelTelephoneDTO.class, name = CHANNEL_TELEPHONE)})
@Data
public abstract class ContactChannelDTO implements ContactChannelWithUser {
	
	@NotNull(message = "The category of the channel is mandatory")
	@JsonProperty("channel")
	private String channel = CHANNEL_UNKNOWN;
	
	@Nullable
	@Size(min = 0, max = 250, message = "The description must be no longer than 250 characters")
	@JsonProperty("description")
	private String description = null;

	@JsonProperty("level")
	private Integer level = null;

}
