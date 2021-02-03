package local.poc.blockchain.customers.management.registration.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import local.poc.blockchain.customers.management.registration.persistence.model.User;
import local.poc.blockchain.customers.management.registration.persistence.model.VerificationToken;

@Repository
public interface VerificationTokenRepository
extends CrudRepository<VerificationToken, Long>, VerificationTokenRepositoryCustom {
	
	public Optional<VerificationToken> findOneByToken(String token);
	
	public Optional<VerificationToken> findOneByUser(User user);
	
}
