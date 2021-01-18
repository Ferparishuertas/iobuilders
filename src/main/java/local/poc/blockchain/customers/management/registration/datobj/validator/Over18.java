package local.poc.blockchain.customers.management.registration.datobj.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({FIELD, TYPE, ANNOTATION_TYPE})
@Constraint(validatedBy = Over18Validator.class)
public @interface Over18 {

	String message() default "Under age";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	@Target({ FIELD, TYPE })
    @Retention(RUNTIME)
    @interface List {
		Over18[] value();
    }
	
}
