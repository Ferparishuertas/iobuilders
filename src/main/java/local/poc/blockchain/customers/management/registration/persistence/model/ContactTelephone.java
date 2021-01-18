package local.poc.blockchain.customers.management.registration.persistence.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import local.poc.blockchain.customers.management.registration.persistence.converter.TelephoneTypeConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
@Entity
@Table(name = "telephone")
public class ContactTelephone extends ContactChannel {
	
	@NotNull
	// @ManyToOne(targetEntity = ContactTelephoneType.class)
	@Convert(converter = TelephoneTypeConverter.class)
	@JoinColumn(name = "type", nullable = false, unique = false)
	private ContactTelephoneType.Ref type;
	
	@NotBlank(message="The telephone's number/code must be indicated.")
	@Column(name = "code", nullable = false, unique = false, length = 250)
	private String value;
	
}
