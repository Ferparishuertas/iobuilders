package local.poc.blockchain.customers.management.registration.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import local.poc.blockchain.customers.management.registration.persistence.model.User;


@Repository
public interface UserRepository
extends CrudRepository<User, Long>, UserRepositoryCustom {
	
	public Optional<User> findOneByLoginAlias(String loginAlias);
	
	public Optional<User> findOneByLoginEmail(String loginEmail);
	
}