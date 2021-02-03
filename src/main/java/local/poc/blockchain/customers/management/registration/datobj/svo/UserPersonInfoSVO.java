package local.poc.blockchain.customers.management.registration.datobj.svo;

import lombok.Data;

@Data
public class UserPersonInfoSVO {
	
	private PersonalInfoSVO personalInfo;
	
	private LoginInfoSVO loginInfo;
	
}
