package local.poc.blockchain.customers.management.registration.datobj.svo;

import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_EMAIL;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
@Data
public class ContactChannelEmailSVO extends ContactChannelSVO {
	
	public ContactChannelEmailSVO() {
		super();
		this.setChannel(CHANNEL_EMAIL);
	}
	
}
