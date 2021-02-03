package local.poc.blockchain.customers.management.registration.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
@Entity
@Table(name = "corporation_office")
public class CorporationOffice extends Customer {
	
	@NotNull(message = "This office must be assigned to a corporation.")
	@ManyToOne(targetEntity = Corporation.class)
	@JoinColumn(name = "coporation_id", nullable = false, unique = false)
	private Corporation corporation;
	
	@NotBlank(message = "The name of this office must be indicated.")
	@Column(name="name", nullable = false, unique = false)
	private String name;
	
	@Column(name = "description", nullable = true, unique = false, length = 2000)
	private String description;
	
	@Column(name="level_position", nullable = true, unique = false)
	private Integer levelPosition;
	
	@NotNull(message = "Weather or not this office is a headquarter is unknown.")
	@Column(name="is_headquarter", nullable = false, unique = false)
	private Boolean headquarter;
	
	@NotEmpty
	@OneToMany
	@JoinTable(name = "corporation_office_contact_channels",
			   joinColumns = {@JoinColumn(name = "corporation_office_id")},
			   inverseJoinColumns = {@JoinColumn(name = "contact_channel_id")})
	// @Column(name="contact_channels", nullable = false, unique = false)
	private List<ContactChannel> contactChannels;
	
	@NotEmpty
	@OneToMany(mappedBy = "coporationOffice")
	private List<CorporationOfficialDocument> officialDocuments;
	
}
