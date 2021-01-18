package local.poc.blockchain.customers.management.registration.datobj.validator;

import static local.poc.blockchain.customers.management.registration.persistence.model.ContactMessengerProvider.Ref.UNKNOW;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import local.poc.blockchain.customers.management.registration.service.ReferencesService;

public class MessengerProviderIsSuitableValidator implements ConstraintValidator<MessengerProviderIsSuitable, Long> {

	@Autowired
	private ReferencesService referencesService;
	
	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		return value == null
				|| (referencesService.isValidMessengerProvider(value)
				    && !UNKNOW.getValue().equals(value));
	}


}
