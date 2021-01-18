package local.poc.blockchain.customers.management.registration.persistence.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import local.poc.blockchain.customers.management.registration.persistence.model.ContactMessengerProvider;

@Converter
public class MessengerProviderConverter
implements AttributeConverter<ContactMessengerProvider.Ref, Long>  {

	@Override
	public Long convertToDatabaseColumn(ContactMessengerProvider.Ref attribute) {
		return attribute.getValue();
	}

	@Override
	public ContactMessengerProvider.Ref convertToEntityAttribute(Long dbData) {
		return ContactMessengerProvider.Ref.fromValue(dbData);
	}
	
}
