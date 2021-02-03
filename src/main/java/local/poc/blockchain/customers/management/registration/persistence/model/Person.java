package local.poc.blockchain.customers.management.registration.persistence.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import local.poc.blockchain.customers.management.registration.persistence.converter.PersonSexConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
@Entity
@Table(name = "person")
public class Person extends Customer {
	
	@NotBlank
	@Column(name="name", nullable = false, unique = false, length = 250)
	private String name;
	
	@Column(name="middle_name", nullable = true, unique = false, length = 250)
	private String middleName;
	
	@NotBlank
	@Column(name="surname_1", nullable = false, unique = false, length = 250)
	private String surname1;
	
	@Column(name="surname_2", nullable = true, unique = false, length = 250)
	private String surname2;
	
	@Temporal(TemporalType.DATE)
	@Column(name="birthdate", nullable = false, unique = false)
	private Date birthdate;
	
	@NotNull
	// @ManyToOne(targetEntity = PersonSex.class)
	@JoinColumn(name = "sex_id", nullable = false, unique = false)
	@Convert(converter = PersonSexConverter.class)
	private PersonSex.Ref sex;
	
	@NotEmpty
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<PersonNationality> nationalities;
	
	@NotEmpty
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "person_contact_channels",
			   joinColumns = {@JoinColumn(name = "person_id")},
			   inverseJoinColumns = {@JoinColumn(name = "contact_channel_id")})
	private List<ContactChannel> contactChannels;
	
	@NotEmpty
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<PersonOfficialDocument> officialDocuments;
}
