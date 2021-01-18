package local.poc.blockchain.customers.management.registration.datobj.svo;

import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_ADDRESS;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
@Data
public class ContactChannelAddressSVO extends ContactChannelSVO {
	
	public ContactChannelAddressSVO() {
		super();
		this.setChannel(CHANNEL_ADDRESS);
	}

	private String postalCode;

	private Long country;

}
