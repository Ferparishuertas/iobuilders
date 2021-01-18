package local.poc.blockchain.customers.management.registration.datobj.svo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonOfficialDocumentSVO {
	
	private Long type;
	
	private Long country;
	
	private String value;
	
	private Date validUntil;
	
	private Integer level;
	
	private String description;
	
}
