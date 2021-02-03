package local.poc.blockchain.customers.management.registration.persistence.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import local.poc.blockchain.customers.management.registration.persistence.converter.MessengerProviderConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
@Entity
@Table(name = "messenger")
public class ContactMessenger extends ContactChannel {
	
	@NotNull(message="The messeger's company or service provider is mandatory.")
	// @ManyToOne(targetEntity = ContactMessengerProvider.class)
	@Convert(converter=MessengerProviderConverter.class)
	@JoinColumn(name="provider", nullable = false, unique = false)
	private ContactMessengerProvider.Ref provider;
	
	@NotBlank(message="The user associated to this customer's messenger account must be indicated.")
	@Column(name="user_code", nullable = false, unique = false, length = 250)
	private String value;
	
}
