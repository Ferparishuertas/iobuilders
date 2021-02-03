package local.poc.blockchain.customers.management.registration.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import local.poc.blockchain.customers.management.registration.persistence.model.ContactMessenger;


@Repository
public interface ContactMessengerRepository
extends CrudRepository<ContactMessenger, Long>, ContactMessengerRepositoryCustom {

}