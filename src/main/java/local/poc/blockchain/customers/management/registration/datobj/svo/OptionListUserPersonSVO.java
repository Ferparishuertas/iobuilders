package local.poc.blockchain.customers.management.registration.datobj.svo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OptionListUserPersonSVO {

	private String option;
	
	private String alias;
	
	private String email;

	private String url;

}
