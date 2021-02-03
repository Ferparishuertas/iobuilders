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
@Table(name = "corporation_official_document")
public class CorporationOfficialDocument extends OfficialDocument {
	
	@NotNull(message="The corporation document type must be specified.")
	@ManyToOne(targetEntity = CorporationOfficialDocumentType.class)
	@JoinColumn(name = "document_type", nullable = false, unique = false)
	private CorporationOfficialDocumentType.Ref type;
	
	@NotNull(message="The corporation office to whose this document belongs must be specified.")
	@ManyToOne(targetEntity = CorporationOffice.class)
	@JoinColumn(name = "corporation_office_id")
	private CorporationOffice coporationOffice;
}
