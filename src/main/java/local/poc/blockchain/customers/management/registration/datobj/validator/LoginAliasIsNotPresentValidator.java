package local.poc.blockchain.customers.management.registration.datobj.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import local.poc.blockchain.customers.management.registration.service.UserService;

public class LoginAliasIsNotPresentValidator
implements ConstraintValidator<LoginAliasIsNotPresent, String> {

	@Autowired
	private UserService userService;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value == null
			   || (!"admin".equals(value)
				   && !userService.checkUserLoginAliasAndEmail(value, null));
	}

}
