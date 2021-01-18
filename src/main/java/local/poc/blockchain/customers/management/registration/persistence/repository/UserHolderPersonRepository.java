package local.poc.blockchain.customers.management.registration.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import local.poc.blockchain.customers.management.registration.persistence.model.User;
import local.poc.blockchain.customers.management.registration.persistence.model.UserHolderPerson;


@Repository
public interface UserHolderPersonRepository
extends CrudRepository<UserHolderPerson, Long>, UserHolderPersonRepositoryCustom {

	public UserHolderPerson findOneByUser(User user);

}