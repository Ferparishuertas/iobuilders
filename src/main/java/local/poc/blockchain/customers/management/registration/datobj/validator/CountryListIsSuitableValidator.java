package local.poc.blockchain.customers.management.registration.datobj.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CountryListIsSuitableValidator
implements ConstraintValidator<CountryListIsSuitable, List<Long>> {
	
	@Autowired
	private Validator validator;

	@Override
	public boolean isValid(List<Long> value, ConstraintValidatorContext context) {
		boolean result = false;
		if(value == null || value.isEmpty()) {
			result = true;
		} else {
			List<String> messages = new ArrayList<>();
			for(Long country : value) {
				Set<ConstraintViolation<CountryWrapper>> violations =
						validator.validate(new CountryWrapper(country), new Class<?>[]{});
				if(!violations.isEmpty()) {
					String vMsgs = violations.stream().map(v -> "[{" + country + "}]" + v.getMessage())
							 .collect(Collectors.joining(";"));
					messages.add(vMsgs);
				}
			}
			if(!messages.isEmpty()) {
				String text = messages.stream().collect(Collectors.joining("|"));
				context.buildConstraintViolationWithTemplate(text).addConstraintViolation()
				.disableDefaultConstraintViolation();
			} else {
				result = true;
			}
		}
		return result;
	}
	
	@AllArgsConstructor
	@Data
	private class CountryWrapper {
		@NotNull(message = "Cannot include null values in the list")
		@CountryIsSuitable(message = "The country is not valid")
		Long country;
	}

}
