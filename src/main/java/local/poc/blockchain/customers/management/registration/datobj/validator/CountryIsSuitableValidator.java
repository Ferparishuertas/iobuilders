package local.poc.blockchain.customers.management.registration.datobj.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import local.poc.blockchain.customers.management.registration.service.ReferencesService;

public class CountryIsSuitableValidator implements ConstraintValidator<CountryIsSuitable, Long> {

	@Autowired
	private ReferencesService referencesService;
	
	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		return value == null || referencesService.isValidCountry(value);
	}

}
