package local.poc.blockchain.customers.management.registration.datobj.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import static local.poc.blockchain.customers.management.registration.persistence.model.ContactTelephoneType.Ref.UNKNOWN;
import local.poc.blockchain.customers.management.registration.service.ReferencesService;

public class TelephoneTypeIsSuitableValidator
implements ConstraintValidator<TelephoneTypeIsSuitable, Long> {
	
	@Autowired
	private ReferencesService referencesService;

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		return value == null
				|| (referencesService.isValidTelephoneType(value)
				    && !UNKNOWN.getValue().equals(value));
	}

}
