package local.poc.blockchain.customers.management.registration.datobj.svo;

import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_TELEPHONE;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
@Data
public class ContactChannelTelephoneSVO extends ContactChannelSVO {
	
	public ContactChannelTelephoneSVO() {
		super();
		this.setChannel(CHANNEL_TELEPHONE);
	}
	
	private Long type = null;

}
