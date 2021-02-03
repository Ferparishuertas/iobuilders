package local.poc.blockchain.customers.management.registration.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import local.poc.blockchain.customers.management.registration.persistence.converter.PersonOfficialDocumentTypeConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
@Entity
@Table(name = "person_official_document")
public class PersonOfficialDocument extends OfficialDocument {
	
	@NotNull
	// @ManyToOne(targetEntity = PersonOfficialDocumentType.class)
	@JoinColumn(name = "document_type", nullable = false, unique = false)
	@Convert(converter = PersonOfficialDocumentTypeConverter.class)
	private PersonOfficialDocumentType.Ref type;
	
	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", nullable = false, unique = false)
	private Person person;
	
}
