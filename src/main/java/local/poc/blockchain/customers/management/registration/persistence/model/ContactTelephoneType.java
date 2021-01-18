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
@Table(name = "ref_contract_telephone_type")
public class ContactTelephoneType extends Reference {
	
	public static enum Ref implements RefVal {
		UNKNOWN(0L, "UNKNOW"),
		LAND(1L, "LAND"),
		MOBILE(2L, "MOBILE"),
		IPPHONE(3L, "IPPHONE"),
		OTHER(10000L, "OTHER");
		
		@Getter
		private final Long value;
		
		@Getter
		private final String label;
		
		private Ref(Long value, String label) {
			this.value = value;
			this.label = label;
		}
		
		public static ContactTelephoneType.Ref fromValue(Long value) {
			ContactTelephoneType.Ref result = UNKNOWN;
			for(ContactTelephoneType.Ref reference : ContactTelephoneType.Ref.values()) {
				if(reference.value.equals(value)) {
					result = reference;
					break;
				}
			}
			return result;
		}
		
		public static ContactTelephoneType.Ref fromLabel(String label) {
			ContactTelephoneType.Ref result = UNKNOWN;
			for(ContactTelephoneType.Ref reference : ContactTelephoneType.Ref.values()) {
				if(reference.getLabel().equals(label)) {
					result = reference;
					break;
				}
			}
			return result;
		}
		
	}

}