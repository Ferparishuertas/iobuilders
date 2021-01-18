package local.poc.blockchain.customers.management.registration.datobj.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({FIELD, TYPE})
@Constraint(validatedBy = PersonOfficialDocumentTypeIsSuitableValidator.class) 
public @interface PersonOfficialDocumentTypeIsSuitable {
	
	String message() default "Person official document type is not valid.";

	Class<?>[] groups() default {};
	
    Class<? extends Payload>[] payload() default {};

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
    	PersonOfficialDocumentTypeIsSuitable[] value();
    }
    
}
