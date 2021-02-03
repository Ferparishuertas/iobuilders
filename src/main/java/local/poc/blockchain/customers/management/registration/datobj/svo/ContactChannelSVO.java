package local.poc.blockchain.customers.management.registration.datobj.svo;

import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_UNKNOWN;

import javax.validation.constraints.NotNull;

import local.poc.blockchain.customers.management.registration.datobj.common.ContactChannelWithUser;
import lombok.Data;

@Data
public abstract class ContactChannelSVO implements ContactChannelWithUser {
	
	@NotNull
	private String channel = CHANNEL_UNKNOWN;

	private String value = null;
	
	private String description = null;

	private Integer level = null;

}
