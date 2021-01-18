package local.poc.blockchain.customers.management.registration.persistence.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import local.poc.blockchain.customers.management.registration.persistence.model.Country;

@Converter
public class CountryConverter
implements AttributeConverter<Country.Ref, Long>  {

	@Override
	public Long convertToDatabaseColumn(Country.Ref attribute) {
		return attribute.getValue();
	}

	@Override
	public Country.Ref convertToEntityAttribute(Long dbData) {
		return Country.Ref.fromValue(dbData);
	}

}
