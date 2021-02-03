package local.poc.blockchain.customers.management.registration.datobj.svo;

import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_MESSENGER;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
@Data
public class ContactChannelMessengerSVO extends ContactChannelSVO {
	
	public ContactChannelMessengerSVO() {
		super();
		this.setChannel(CHANNEL_MESSENGER);
	}
	
	private Long type = null;
	
}
