package local.poc.blockchain.customers.management.registration.datobj.svo;

import lombok.Data;

@Data
public class LoginInfoSVO {
	
	private String alias;
	
	private String password;

	private String email;

	private String mobile;
	
}
