package local.poc.blockchain.customers.management.registration.datobj.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import local.poc.blockchain.customers.management.registration.service.ReferencesService;

public class UnitIsPresentValidator
implements ConstraintValidator<UnitIsPresent, String> {
	
	@Autowired
	private ReferencesService referencesService;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value == null || referencesService.isUnitPresent(value);
	}

}
