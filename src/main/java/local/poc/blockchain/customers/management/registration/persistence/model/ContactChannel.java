package local.poc.blockchain.customers.management.registration.persistence.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "contact_channel")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ContactChannel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id", nullable = false, unique = true)
	private Long id;
	
	@Column(name="level_position", nullable = true, unique = false)
	private Integer levelPosition;
	
	@Column(name="description", nullable = true, unique = false, length = 250)
	private String description;
	
	@Embedded
	private DBReg dbReg;
	
}
