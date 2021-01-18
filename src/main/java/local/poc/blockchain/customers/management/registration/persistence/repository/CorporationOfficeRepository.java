package local.poc.blockchain.customers.management.registration.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import local.poc.blockchain.customers.management.registration.persistence.model.CorporationOffice;


@Repository
public interface CorporationOfficeRepository
extends CrudRepository<CorporationOffice, Long>, CorporationOfficeRepositoryCustom {

}