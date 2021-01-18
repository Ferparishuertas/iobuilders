package local.poc.blockchain.customers.management.registration.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import local.poc.blockchain.customers.management.registration.persistence.model.ContactTelephone;


@Repository
public interface ContactTelephoneRepository
extends CrudRepository<ContactTelephone, Long>, ContactTelephoneRepositoryCustom {

}