package local.poc.blockchain.customers.management.registration.appevent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OnRegistrationNaturalPersonCompleteEvent {
	
	private String userLoginAlias;
	
	private String userLoginEmail;
	
	private String url;
	
	private Boolean update;

}
