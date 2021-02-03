package local.poc.blockchain.customers.management.registration.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import local.poc.blockchain.customers.management.registration.persistence.model.ContactTelephoneType;


@Repository
public interface ContactTelephoneTypeRepository
extends CrudRepository<ContactTelephoneType, Long>, ContactTelephoneTypeRepositoryCustom {
	
	public Optional<ContactTelephoneType> findOneByName(String name);

}