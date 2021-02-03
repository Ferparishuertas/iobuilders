package local.poc.blockchain.customers.management.registration.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
@Entity
@Table(name = "email_address")
public class ContactEmail extends ContactChannel {
	
	@Email(message = "Invalid email address for contacting.")
	@NotBlank(message = "The email address must be indicated.")
	@Column(name = "email_address", nullable = false, unique = false, length = 250)
	private String value;

}
