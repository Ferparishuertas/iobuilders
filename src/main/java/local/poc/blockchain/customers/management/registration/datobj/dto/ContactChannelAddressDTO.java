package local.poc.blockchain.customers.management.registration.datobj.dto;

import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_ADDRESS;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import local.poc.blockchain.customers.management.registration.datobj.validator.CountryIsSuitable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonTypeName("address")
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
@Data
public class ContactChannelAddressDTO extends ContactChannelDTO {
	
	public ContactChannelAddressDTO() {
		super();
		this.setChannel(CHANNEL_ADDRESS);
	}
	
	@NotBlank(message = "Address is mandatory.")
	@Size(min = 5, max = 250, message = "Address should be between 5 and 250 characters long.")
	@JsonProperty("value")
	private String value = null;

	@NotBlank(message = "Postal code is mandatory.")
	@Size(min = 5, max = 250, message = "Postal code should be between 5 and 250 characters long.")
	@JsonProperty("postalCode")
	private String postalCode;

	@CountryIsSuitable(message = "Reference to the country associated to the address is not valid or null.")
	@JsonProperty("country")
	private Long country;

}
