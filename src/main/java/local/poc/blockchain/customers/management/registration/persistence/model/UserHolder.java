package local.poc.blockchain.customers.management.registration.persistence.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class UserHolder {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id", nullable = false, unique = true)
	private Long id;
	
	@NotNull(message="The user for this user holder must be specified.")
	@OneToOne(targetEntity = User.class)
	private User user;
	
	@Embedded
	private DBReg dbReg;
	
}
