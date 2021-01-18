package local.poc.blockchain.customers.management.registration.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import local.poc.blockchain.customers.management.registration.persistence.converter.CountryConverter;
import lombok.Data;

@Data
@MappedSuperclass
public class OfficialDocument {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id", nullable = false, unique = true)
	private Long id;
	
	@NotBlank
	@Column(name = "value", nullable = false, unique = false, length = 250)
	private String value;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "valid_until", nullable = false, unique = false)
	private Date validUntil;
	
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
