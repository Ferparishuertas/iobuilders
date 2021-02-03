package local.poc.blockchain.customers.management.registration.appevent;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import local.poc.blockchain.customers.management.registration.service.UserService;

@Component
public class OnRegistrationNauralPersonCompleteEventListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OnRegistrationNauralPersonCompleteEventListener.class);

	@Autowired
    private JavaMailSender mailSender;
	
	@Autowired
	private UserService userService;
	
	// TODO Include locale.
//	@Autowired
//    private MessageSource messageSources;
	
	@EventListener
	public void handleEvent(OnRegistrationNaturalPersonCompleteEvent event) { 
		
		String userLoginAlias = event.getUserLoginAlias();
		String userLoginEmail = event.getUserLoginEmail();
		Boolean updateToken = event.getUpdate();
		
		try {
			
	        String token = UUID.randomUUID().toString();
			
	        LOGGER.info("Confirmation token: " + token + " for user " + userLoginAlias);
	        
	        if(updateToken) {
	        	userService.updateVerificationTokenForUserAlias(userLoginAlias, token);
	        } else {
	        	userService.recordVerificationTokenForUserAlias(userLoginAlias, token);
	        }
			
	        String subject = "Registration Confirmation";
	        String confirmationUrl 
	          = event.getUrl() + "/regitrationConfirm?token=" + token;
	        // String message = messages.getMessage("message.regSucc", null, event.getLocale());
	        // String message = "You registered successfully. We will send you a confirmation message to your email account.";
	        String message = "You registered successfully. To confirm your registration, please click on the below link";
	        
	        SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo(userLoginEmail);
	        email.setSubject(subject);
	        // TODO Check server url [Add it like a property]
	        email.setText(message + "\r\n" + "http://localhost:8080" + confirmationUrl);
	        
	        LOGGER.info("Confirmation token: " + token + " ; sending email to: " + userLoginEmail);
	        mailSender.send(email);
		} catch (/* NaturalPerson */Exception e) {
			LOGGER.error("Processing event (token generation for confirmation) ["
						 + event.getClass() + " ]: user =>  " + userLoginAlias + "; exceptionMsg => " + e.getMessage());
		}
        
	}

}
