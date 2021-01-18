package local.poc.blockchain.customers.management.registration.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import local.poc.blockchain.customers.management.registration.persistence.model.PersonOfficialDocumentType;


@Repository
public interface PersonOfficialDocumentTypeRepository
extends CrudRepository<PersonOfficialDocumentType, Long>, PersonOfficialDocumentTypeRepositoryCustom {
	
	public Optional<PersonOfficialDocumentType> findOneByName(String name);

}