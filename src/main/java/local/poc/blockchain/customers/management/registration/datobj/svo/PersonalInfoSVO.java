package local.poc.blockchain.customers.management.registration.datobj.svo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PersonalInfoSVO {

	private String name;

	private String middleName;

	private String surname1;

	private String surname2;

	private Long sex;
	
	private Date birthdate;

	private Long mainNationality;

	private List<Long> otherNationalities;
	
	private List<ContactChannelSVO> contactChannels;
	
	private List<PersonOfficialDocumentSVO> personOfficialDocuments;

}
