package local.poc.blockchain.customers.management.registration.datobj.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import local.poc.blockchain.customers.management.registration.service.UserService;

public class LoginEmailIsNotPresentValidator implements ConstraintValidator<LoginEmailIsNotPresent, String> {

	@Autowired
	private UserService userService;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value == null || !userService.checkUserLoginAliasAndEmail(null, value);
	}

}
