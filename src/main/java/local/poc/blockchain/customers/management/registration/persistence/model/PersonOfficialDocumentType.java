package local.poc.blockchain.customers.management.registration.persistence.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Data
@Entity
@Table(name = "ref_person_official_document_type")
public class PersonOfficialDocumentType extends Reference {
	
	public static enum Ref implements RefVal {
		// NATIONAL_DOCUMENT => national identity number, social security number,
		//                      employer identification number, etc...
		UKNOWN(0L, "UKNOWN"),
		NATIONAL_IDENTITY_DOCUMENT(1L, "NID"),
		PASSPORT(2L, "PASSPORT"),
		DRIVING_LICENSE(3L, "DRIVING_LIC"),
		NATIONAL_SOCIAL_SECURITY_NUMBER(4L, "SOCIAL_SECURITY_NUMBER"),
		OTHER(10000L, "OTHER");
		
		@Getter
		private final Long value;
		
		@Getter
		private final String label;
		
		private Ref(Long value, String label) {
			this.value = value;
			this.label = label;
		}
		
		public static PersonOfficialDocumentType.Ref fromValue(Long value) {
			PersonOfficialDocumentType.Ref result = UKNOWN;
			for(PersonOfficialDocumentType.Ref reference : PersonOfficialDocumentType.Ref.values()) {
				if(reference.value.equals(value)) {
					result = reference;
					break;
				}
			}
			return result;
		}
		
		public static PersonOfficialDocumentType.Ref fromLabel(String label) {
			PersonOfficialDocumentType.Ref result = UKNOWN;
			for(PersonOfficialDocumentType.Ref reference : PersonOfficialDocumentType.Ref.values()) {
				if(reference.getLabel().equals(label)) {
					result = reference;
					break;
				}
			}
			return result;
		}
		
	}
	
}