package local.poc.blockchain.customers.management.registration.persistence.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import local.poc.blockchain.customers.management.registration.persistence.model.PersonSex;
import local.poc.blockchain.customers.management.registration.persistence.model.PersonSex.Ref;

@Converter
public class PersonSexConverter
implements AttributeConverter<PersonSex.Ref, Long> {

	@Override
	public Long convertToDatabaseColumn(Ref attribute) {
		return attribute.getValue();
	}

	@Override
	public Ref convertToEntityAttribute(Long dbData) {
		return PersonSex.Ref.fromValue(dbData);
	}

}
