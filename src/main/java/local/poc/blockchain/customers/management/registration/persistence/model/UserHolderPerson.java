package local.poc.blockchain.customers.management.registration.persistence.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
@Entity
@Table(name = "user_holder_person")
public class UserHolderPerson extends UserHolder {
	
	@NotNull(message="The person for this user holder of natural people must be specified.")
	@ManyToOne(targetEntity = Person.class)
	@JoinColumn(name = "person_id")
	private Person person;
}
