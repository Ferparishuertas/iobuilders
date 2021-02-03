package local.poc.blockchain.customers.management.registration.datobj.validator;

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
@Target({ TYPE, FIELD })
@Constraint(validatedBy = LoginEmailIsNotPresentValidator.class)
public @interface LoginEmailIsNotPresent {
	
	String message() default "The login email was registered previously.";

	Class<?>[] groups() default {};
	
    Class<? extends Payload>[] payload() default {};

    @Target({ FIELD, TYPE })
    @Retention(RUNTIME)
    @interface List {
    	LoginEmailIsNotPresent[] value();
    }
    
}
