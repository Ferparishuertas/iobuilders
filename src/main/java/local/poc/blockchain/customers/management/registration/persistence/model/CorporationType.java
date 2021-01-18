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
@Table(name = "ref_corporation_type")
public class CorporationType extends Reference {
	
	public static enum Ref implements RefVal {
		UNKNOWN(0L, "UNKNOWN"),
		COMPANY(1L, "COMPANY"),
		GOVERNMENT(2L, "GOVERNMENT"),
		GOVERNMENT_COMPANY(3L, "GOVERNMENT_COMPANY"),
		OFFICIAL_INSTITUTION_SUPRANATIONAL_LEVEL(4L, "OFFICIAL_INSTITUTION_SUPRANATIONAL"),
		OFFICIAL_INSTITUTION_NATIONAL_LEVEL(5L, "OFFICIAL_INSTITUTION_NATIONAL"),
		OFFICIAL_INSTITUTION_STATE_LEVEL(6L, "OFFICIAL_INSTITUTION_STATE"),
		OFFICIAL_INSTITUTION_PROVICE_LEVEL(7L, "OFFICIAL_INSTITUTION_PROVICE"),
		OFFICIAL_INSTITUTION_CITY_LEVEL(8L, "OFFICIAL_INSTITUTION_CITY"),
		OFFICIAL_INSTITUTION_OTHER(9L, "OFFICIAL_INSTITUTION_OTHER"),
		NGO(10L, "NGO"),
		TRADE_UNION(11L, "TRADE_UNION"),
		OTHER(12L, "OTHER");
		
		@Getter
		private final Long value;
		
		@Getter
		private final String label;
		
		private Ref(Long value, String label) {
			this.value = value;
			this.label = label;
		}
		
		public static CorporationType.Ref fromValue(Long value) {
			CorporationType.Ref result = UNKNOWN;
			for(CorporationType.Ref reference : CorporationType.Ref.values()) {
				if(reference.value.equals(value)) {
					result = reference;
					break;
				}
			}
			return result;
		}
		
		public static CorporationType.Ref fromLabel(String label) {
			CorporationType.Ref result = UNKNOWN;
			for(CorporationType.Ref reference : CorporationType.Ref.values()) {
				if(reference.getLabel().equals(label)) {
					result = reference;
					break;
				}
			}
			return result;
		}
		
	}
	
}