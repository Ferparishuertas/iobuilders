package local.poc.blockchain.customers.management.registration.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import local.poc.blockchain.customers.management.registration.persistence.converter.CountryConverter;
import lombok.Data;

@Data
@Entity
@Table(name="person_nationality")
public class PersonNationality {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id", nullable = false, unique = true)
	private Integer id;
	
	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", nullable = false, unique = false)
	private Person person;
	
	@NotNull
	// @ManyToOne(targetEntity = Country.class)
	@JoinColumn(name = "country_id", nullable = false, unique = false)
	@Convert(converter = CountryConverter.class)
	private Country.Ref country;
	
	@Column(name="level_position", nullable = true, unique = false)
	private Integer levelPosition;
	
	@Column(name="description", nullable = true, unique = false, length = 250)
	private String description;
	
	@Embedded
	private DBReg dbReg;
	
}
