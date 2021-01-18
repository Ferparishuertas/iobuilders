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
@Table(name = "ref_contact_messenger_provider")
public class ContactMessengerProvider extends Reference {
	
	public static enum Ref implements RefVal {
		UNKNOW(0L, "UNKNOW"),
		SMS(1L, "SMS"),
		WHATSAPP(2L, "WHATSAPP"),
		TELEGRAM(3L, "TELEGRAM"),
		OTHER(10000L, "OTHER");
		
		@Getter
		private final Long value;
		
		@Getter
		private final String label;
		
		private Ref(Long value, String label) {
			this.value = value;
			this.label = label;
		}
		
		public static ContactMessengerProvider.Ref fromValue(Long value) {
			ContactMessengerProvider.Ref result = UNKNOW;
			for(ContactMessengerProvider.Ref reference : ContactMessengerProvider.Ref.values()) {
				if(reference.value.equals(value)) {
					result = reference;
					break;
				}
			}
			return result;
		}
		
		public static ContactMessengerProvider.Ref fromLabel(String label) {
			ContactMessengerProvider.Ref result = UNKNOW;
			for(ContactMessengerProvider.Ref reference : ContactMessengerProvider.Ref.values()) {
				if(reference.getLabel().equals(label)) {
					result = reference;
					break;
				}
			}
			return result;
		}
	}
	
}