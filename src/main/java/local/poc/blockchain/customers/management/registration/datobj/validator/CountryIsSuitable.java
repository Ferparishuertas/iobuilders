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
@Target({FIELD, TYPE})
@Constraint(validatedBy = CountryIsSuitableValidator.class) 
public @interface CountryIsSuitable {
	
	String message() default "The country is not valid.";

	Class<?>[] groups() default {};
	
    Class<? extends Payload>[] payload() default {};

    @Target({ FIELD, TYPE })
    @Retention(RUNTIME)
    @interface List {
    	CountryIsSuitable[] value();
    }
	
}
