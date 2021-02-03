package local.poc.blockchain.customers.management.registration.datobj.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = UserPersonContactChannelsConstraintValidator.class)
@Documented
public @interface UserPersonContactChannelsConstraint {
	
	String message() default "Contact channels for natural person user are not correct.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
}
