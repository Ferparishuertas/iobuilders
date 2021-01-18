package local.poc.blockchain.customers.management.registration.datobj.validator;

import static local.poc.blockchain.customers.management.registration.persistence.model.PersonOfficialDocumentType.Ref.UKNOWN;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import local.poc.blockchain.customers.management.registration.service.ReferencesService;

public class PersonOfficialDocumentTypeIsSuitableValidator
implements ConstraintValidator<PersonOfficialDocumentTypeIsSuitable, Long> {
	
	@Autowired
	private ReferencesService referencesService;

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		return value == null
				|| (referencesService.isValidPersonOfficialDocumentType(value)
				    && !UKNOWN.getValue().equals(value));
	}

}
