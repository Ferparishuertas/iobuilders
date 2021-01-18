package local.poc.blockchain.customers.management.registration.mail;

import java.io.InputStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class DefaultJavaMailSender implements JavaMailSender {
	
	private static final Logger LOGGER = LogManager.getLogger(DefaultJavaMailSender.class);

	@Override
	public void send(SimpleMailMessage simpleMessage) throws MailException {
		LOGGER.debug("send(SimpleMailMessage) => " + simpleMessage);
	}

	@Override
	public void send(SimpleMailMessage... simpleMessages) throws MailException {
		LOGGER.debug("send(SimpleMailMessage...) => " +
					Stream.of(simpleMessages).map(SimpleMailMessage::toString)
								  .collect(Collectors.joining("/-//-/", "[", "]")));
	}

	@Override
	public MimeMessage createMimeMessage() {
		LOGGER.debug("createMimeMessage()");
		return new MimeMessage((Session)null);
	}

	@Override
	public MimeMessage createMimeMessage(InputStream contentStream) throws MailException {
		LOGGER.debug("createMimeMessage(InputStream)");
		return new MimeMessage((Session)null);
	}

	@Override
	public void send(MimeMessage mimeMessage) throws MailException {
		LOGGER.debug("send(MimeMessage)");
	}

	@Override
	public void send(MimeMessage... mimeMessages) throws MailException {
		LOGGER.debug("send(MimeMessage...) => " +
		Stream.of(mimeMessages).map(MimeMessage::toString)
		  .collect(Collectors.joining("/-//-/", "[", "]")));
	}

	@Override
	public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {
		LOGGER.debug("send(MimeMessagePreparator)");
	}

	@Override
	public void send(MimeMessagePreparator... mimeMessagePreparators) throws MailException {
		LOGGER.debug("send(MimeMessagePreparator...)");
	}

}
