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
@Table(name = "ref_corporation_official_document_type")
public class CorporationOfficialDocumentType extends Reference {
	
	public static enum Ref implements RefVal {
		UKNOWN(0L, "UKNOWN"),
		IDENTIFICATION_NUMBER_FOR_COMPANY(1L, "COMPANY"),
		IDENTIFICATION_NUMBER_FOR_NGO(2L, "NGO"),
		INSTITUTIONAL_IDENTIFICATION_NUMBER_INTERNATIONAL_LEVEL(3L, "INTERNATIONAL"),
		INSTITUTIONAL_IDENTIFICATION_NUMBER_SUPRANATIONAL_LEVEL(4L, "SUPRANATIONAL"),
		INSTITUTIONAL_IDENTIFICATION_NUMBER_NATIONAL_LEVEL(5L, "NATIONAL"),
		INSTITUTIONAL_IDENTIFICATION_NUMBER_STATE_LEVEL(6L, "STATE"),
		INSTITUTIONAL_IDENTIFICATION_NUMBER_PROVINCE_LEVEL(7L, "PROVINCE"),
		INSTITUTIONAL_IDENTIFICATION_NUMBER_CITY_LEVEL(8L, "CITY"),
		INSTITUTIONAL_IDENTIFICATION_NUMBER_FOR_GOVERNMENT(9L, "GOVERMENT"),
		OTHER(10000L, "OTHER");
		
		@Getter
		private final Long value;
		
		@Getter
		private final String label;
		
		private Ref(Long value, String label) {
			this.value = value;
			this.label = label;
		}
		
		public static CorporationOfficialDocumentType.Ref fromValue(Long value) {
			CorporationOfficialDocumentType.Ref result = UKNOWN;
			for(CorporationOfficialDocumentType.Ref reference : CorporationOfficialDocumentType.Ref.values()) {
				if(reference.value.equals(value)) {
					result = reference;
					break;
				}
			}
			return result;
		}
		
		public static CorporationOfficialDocumentType.Ref fromLabel(String label) {
			CorporationOfficialDocumentType.Ref result = UKNOWN;
			for(CorporationOfficialDocumentType.Ref reference : CorporationOfficialDocumentType.Ref.values()) {
				if(reference.getLabel().equals(label)) {
					result = reference;
					break;
				}
			}
			return result;
		}
		
	}
	
}