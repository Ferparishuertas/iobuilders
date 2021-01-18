package local.poc.blockchain.customers.management.registration.persistence.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
@Entity
@Table(name = "user_holder_corporation")
public class UserHolderCorporation extends UserHolder {

	@NotEmpty
	@ManyToMany(targetEntity = CorporationOffice.class)
	@JoinTable(name="user_holder_corporation_office",
	    joinColumns=
	        @JoinColumn(name="user_holder_id", referencedColumnName="id"),
	    inverseJoinColumns=
	        @JoinColumn(name="corporation_office_id", referencedColumnName="id")
    )
	private List<CorporationOffice> companyOffices;
	
}
