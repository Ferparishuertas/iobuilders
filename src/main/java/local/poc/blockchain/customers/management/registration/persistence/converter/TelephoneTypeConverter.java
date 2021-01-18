package local.poc.blockchain.customers.management.registration.persistence.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import local.poc.blockchain.customers.management.registration.persistence.model.ContactTelephoneType;

@Converter
public class TelephoneTypeConverter
implements AttributeConverter<ContactTelephoneType.Ref, Long>  {

	@Override
	public Long convertToDatabaseColumn(ContactTelephoneType.Ref attribute) {
		return attribute.getValue();
	}

	@Override
	public ContactTelephoneType.Ref convertToEntityAttribute(Long dbData) {
		return ContactTelephoneType.Ref.fromValue(dbData);
	}

}
