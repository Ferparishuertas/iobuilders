package local.poc.blockchain.customers.management.registration.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
@Entity
@Table(name = "geographical_address")
public class ContactAddress extends ContactChannel {
	
	@NotBlank(message="The address is mandatory.")
	@Column(name="address", nullable = false, unique = false, length = 250)
	private String value;
	
	@Column(name="postal_code", nullable = true, unique = false, length = 150)
	private String postalCode;
	
	@NotNull(message="The country associated to this address is mandatory.")
	// @ManyToOne(targetEntity = Country.class)
	@JoinColumn(name="country_id", nullable = false, unique = false)
	private Country.Ref country;
	
}
