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
@Table(name = "ref_person_sex")
public class PersonSex extends Reference {
	
	public static enum Ref implements RefVal {
		
		UNKNOWN(0L, "UNKNOW"),
		MALE(1L, "MALE"),
		FEMALE(2L, "FEMALE");
		
		@Getter
		private final Long value;
		
		@Getter
		private final String label;
		
		private Ref(Long value, String label) {
			this.value = value;
			this.label = label;
		}
		
		public static PersonSex.Ref fromValue(Long value) {
			PersonSex.Ref result = UNKNOWN;
			for(PersonSex.Ref reference : PersonSex.Ref.values()) {
				if(reference.value.equals(value)) {
					result = reference;
					break;
				}
			}
			return result;
		}
		
		public static PersonSex.Ref fromLabel(String label) {
			PersonSex.Ref result = UNKNOWN;
			for(PersonSex.Ref reference : PersonSex.Ref.values()) {
				if(reference.label.equals(label)) {
					result = reference;
					break;
				}
			}
			return result;
		}
		
	}
	
}
