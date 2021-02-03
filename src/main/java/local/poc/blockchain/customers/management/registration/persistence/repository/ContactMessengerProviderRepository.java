package local.poc.blockchain.customers.management.registration.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import local.poc.blockchain.customers.management.registration.persistence.model.ContactMessengerProvider;


@Repository
public interface ContactMessengerProviderRepository
extends CrudRepository<ContactMessengerProvider, Long>, ContactMessengerProviderRepositoryCustom {
	
	public Optional<ContactMessengerProvider> findOneByName(String name);
	
}