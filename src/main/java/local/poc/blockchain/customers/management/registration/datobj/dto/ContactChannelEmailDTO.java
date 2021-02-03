package local.poc.blockchain.customers.management.registration.datobj.dto;

import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_EMAIL;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@JsonTypeName("email")
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
@Data
public class ContactChannelEmailDTO extends ContactChannelDTO {
	
	public ContactChannelEmailDTO() {
		super();
		this.setChannel(CHANNEL_EMAIL);
	}
	
	@NotBlank(message = "The email is mandatory.")
	@Email(message = "The email is not valid.")
	@JsonProperty("value")
	private String value = null;
	
}
