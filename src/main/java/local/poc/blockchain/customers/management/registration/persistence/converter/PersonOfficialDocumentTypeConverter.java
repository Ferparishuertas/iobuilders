package local.poc.blockchain.customers.management.registration.persistence.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import local.poc.blockchain.customers.management.registration.persistence.model.PersonOfficialDocumentType;
import local.poc.blockchain.customers.management.registration.persistence.model.PersonOfficialDocumentType.Ref;

@Converter
public class PersonOfficialDocumentTypeConverter
implements AttributeConverter<PersonOfficialDocumentType.Ref, Long> {

	@Override
	public Long convertToDatabaseColumn(Ref attribute) {
		return attribute.getValue();
	}

	@Override
	public Ref convertToEntityAttribute(Long dbData) {
		return PersonOfficialDocumentType.Ref.fromValue(dbData);
	}

}
