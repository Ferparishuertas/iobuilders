package local.poc.blockchain.customers.management.registration.datobj.validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Over18Validator implements ConstraintValidator<Over18, Date> {

	@Override
	public boolean isValid(Date value, ConstraintValidatorContext context) {
		boolean result = false;
		if(value == null) {
			result = true;
		} else {
			LocalDate now = LocalDate.now();
			LocalDate birthdate = value.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Period period = Period.between(birthdate, now);
			result =  period.getYears() >= 18;
		}
		return result;
	}

}
