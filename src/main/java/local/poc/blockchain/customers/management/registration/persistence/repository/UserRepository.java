package local.poc.blockchain.customers.management.registration.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import local.poc.blockchain.customers.management.registration.persistence.model.User;


@Repository
public interface UserRepository
extends CrudRepository<User, Long>, UserRepositoryCustom {
	
	public Optional<User> findOneByLoginAlias(String loginAlias);
	
	public Optional<User> findOneByLoginEmail(String loginEmail);
	
	public boolean existsByLoginAliasAndLoginEmail
	(String loginAlias, String loginEmail);
	
	public boolean existsByLoginAlias(String loginAlias);
	
	public boolean existsByLoginEmail(String loginEmail);
	
	@Query("SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM User u WHERE 'ADMIN' MEMBER OF u.authorities")
	public boolean isThereAnyAdmin();
	
}