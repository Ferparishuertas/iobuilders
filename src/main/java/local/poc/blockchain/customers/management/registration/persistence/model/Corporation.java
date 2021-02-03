package local.poc.blockchain.customers.management.registration.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "corporation")
public class Corporation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id", nullable = false, unique = true)
	private Long id;
	
	@NotNull(message="The type of this corporation must be indicated.")
	@ManyToOne(targetEntity = CorporationType.class)
	@JoinColumn(name="type", nullable = false, unique = false)
	private CorporationType.Ref type;
	
	@NotBlank(message="The name of the corporation must be indicated.")
	@Column(name="name", nullable = false, unique = false, length = 250)
	private String name;
	
	@Column(name="description", nullable = true, unique = false, length = 2000)
	private String description;
	
	@NotEmpty(message="One office of this corporation must be indicated at least.")
	@OneToMany(mappedBy = "corporation", fetch = FetchType.EAGER)
	private List<CorporationOffice> offices;
	
	@Embedded
	private DBReg dbReg;
	
	//
	// The abstract virtual corporation office represent to the corporation in an abstract way.
	// All the corporation must register a virtual corporation office, at least.
	// 
	
}
