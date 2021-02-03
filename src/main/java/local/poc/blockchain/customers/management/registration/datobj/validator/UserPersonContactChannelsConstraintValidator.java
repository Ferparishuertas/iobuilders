package local.poc.blockchain.customers.management.registration.datobj.validator;

import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_ADDRESS;
import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_EMAIL;
import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_MESSENGER;
import static local.poc.blockchain.customers.management.registration.util.Global.ContactChannelType.CHANNEL_TELEPHONE;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

import local.poc.blockchain.customers.management.registration.datobj.common.ContactChannelWithUser;

public class UserPersonContactChannelsConstraintValidator
implements ConstraintValidator<UserPersonContactChannelsConstraint, List<? extends ContactChannelWithUser>> {
	
	@Autowired
	Validator validator;

	@Override
	public boolean
	isValid(List<? extends ContactChannelWithUser> values,
			ConstraintValidatorContext context) {
		List<String> messages = new ArrayList<>();
		checkMandatoryChannels(values, messages);
		checkChannel(CHANNEL_ADDRESS, values, messages);
		checkChannel(CHANNEL_EMAIL, values, messages);
		checkChannel(CHANNEL_MESSENGER, values, messages);
		checkChannel(CHANNEL_TELEPHONE, values, messages);
		boolean result = messages.isEmpty();
		if(!result) {
			String text = messages.stream().collect(Collectors.joining("|"));
			context.buildConstraintViolationWithTemplate(text).addConstraintViolation()
			.disableDefaultConstraintViolation();
		}
		return result;
	}
	
	/**
	 * Check if the list of <code>channels</code> contains at least one item
	 * of the next channels: telephone, email and (geographical) address. It
	 * returns <code>false</code> if any of them is not included, and a
	 * validation message is appended to <code>messages</code>.
	 * @param channels The list of channels.
	 * @param messages The list in which a new validation message will be
	 * 		 		   added in the case <code>false</code> is returned.
	 * @return <code>true</code>, if one item of telephone, email and
	 * 		   address is included at least, <code>false</code> in other case.
	 */
	private boolean
	checkMandatoryChannels(List<? extends ContactChannelWithUser> channels,
						   final List<String> messages) {
		boolean foundAddress = false;
		boolean foundEmail = false;
		boolean foundTelephone = false;
		for(ContactChannelWithUser val : channels) {
			switch(val.getChannel()) {
			case CHANNEL_ADDRESS:
				foundAddress = true;
				break;
			case CHANNEL_EMAIL:
				foundEmail = true;
				break;
			case CHANNEL_TELEPHONE:
				foundTelephone = true;
				break;
			}
		}
		boolean result = foundAddress && foundEmail && foundTelephone;
		if(!result) {
			messages.add(
				"At least, a geographical address, an email and a telphone number must be indicated for a natural person.");
		}
		return result;
	}
	
	/**
	 * Validates all the channels in <code>channelList</code> that are
	 * of type <code>channel</code>. It returns <code>false</code>, if
	 * any of the channels is not valid. The validation messages are
	 * appended in the list <code>messages</code>.
	 * @param channel The type of channels to be validated.
	 * @param channelList The list of all the channels from which those
	 *        of type <code>channel</code> will be validated.
	 * @param messages The validation messages if any of the channel is
	 *        not valid.
	 * @return <code>true</code>, if valid, else <code>false</code>.
	 */
	private boolean
	checkChannel(String channel,
				 List<? extends ContactChannelWithUser> channelList,
				 final List<String> messages) {
		List<String> newMessages = new ArrayList<>();
		channelList.stream().filter(x -> x.getChannel().equals(channel)).forEach(
			contactChannel -> {
				String value = contactChannel.getValue();
				Set<ConstraintViolation<ContactChannelWithUser>> violations =
					validator.validate(contactChannel, new Class<?>[]{});
				String vMsgs = violations.stream()
										 .map(v -> "[" + channel + " !!! " + value + "]" + v.getMessage())
										 .sorted()
										 .collect(Collectors.joining(";"));
				if(!vMsgs.trim().isEmpty()) {
					newMessages.add(vMsgs);
				}
			}
		);
		messages.addAll(newMessages);
		return newMessages.isEmpty();
	}
	
}
