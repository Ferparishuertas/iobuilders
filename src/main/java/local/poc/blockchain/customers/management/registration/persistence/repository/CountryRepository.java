package local.poc.blockchain.customers.management.registration.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import local.poc.blockchain.customers.management.registration.persistence.model.Country;


@Repository
public interface CountryRepository
extends CrudRepository<Country, Long>, CountryRepositoryCustom {
	
	Optional<Country> findOneByAlpha3(String alpha3);
	
}