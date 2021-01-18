package local.poc.blockchain.customers.management.registration.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import local.poc.blockchain.customers.management.registration.persistence.model.User;
import local.poc.blockchain.customers.management.registration.persistence.model.VerificationToken;
import local.poc.blockchain.customers.management.registration.persistence.repository.UserRepository;
import local.poc.blockchain.customers.management.registration.persistence.repository.VerificationTokenRepository;
import local.poc.blockchain.customers.management.registration.service.UserService;
import local.poc.blockchain.customers.management.registration.service.exception.UserServiceException;

import local.poc.blockchain.customers.management.registration.service.error.UserServiceError;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VerificationTokenRepository verificationTokenRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findOneByLoginAlias(username).orElseThrow(
				() -> new UsernameNotFoundException("The user " + username + " is not found in the system."));
	}
	
	@Override
	public Boolean checkUserLoginAliasAndEmail(String loginAlias, String loginEmail)
	throws IllegalArgumentException {
		if(loginAlias == null && loginEmail == null) {
			throw new IllegalArgumentException("One of them at least, the login or the email, must be non null.");
		}
		boolean result = false;
		if(loginAlias != null) {
			Optional<User> opUser = userRepository.findOneByLoginAlias(loginAlias);
			if(opUser.isPresent()) {
				result = opUser.get().getLoginEmail().equals(loginEmail);
			}
		} else if(loginEmail != null) {
			Optional<User> opUser = userRepository.findOneByLoginEmail(loginEmail);
			if(opUser.isPresent()) {
				result = opUser.get().getLoginAlias().equals(loginAlias);
			}
		}
		return result;
	}
	
	@Override
	public Boolean recordVerificationTokenForUserAlias(String userLoginAlias, String token)
	throws UserServiceException {
		User user = userRepository.findOneByLoginAlias(userLoginAlias).orElseThrow(
				() -> new UserServiceException("General user not found for storing a registration token.",
												UserServiceError.USER_NOT_FOUND));
		if(user.isEnabled()) {
			throw new UserServiceException("Verification tokens cannot be created for already enabled users.",
												UserServiceError.USER_ENABLED);
		}
		if(verificationTokenRepository.findOneByToken(token).isPresent()) {
			throw new UserServiceException("The token was recorded previously.",
											UserServiceError.TOKEN_FOUND);
		}
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setUser(user);
		verificationToken.setToken(token);
		Date date = VerificationToken.calculateExpiryDate();
		verificationToken.setExpiryDate(date);
		verificationToken = verificationTokenRepository.save(verificationToken);
		return true;
	}
	
	@Override
	public Boolean updateVerificationTokenForUserAlias(String userLoginAlias, String token)
	throws UserServiceException {
		User user = userRepository.findOneByLoginAlias(userLoginAlias).orElseThrow(
				() -> new UserServiceException("General user not found for updating a registration token.",
											   UserServiceError.USER_NOT_FOUND));
		if(user.isEnabled()) {
			throw new UserServiceException("Verification tokens cannot be updated for already enabled users.",
											UserServiceError.USER_ENABLED);
		}
		VerificationToken verificationToken = verificationTokenRepository.findOneByUser(user).orElseThrow(
				() -> new UserServiceException("There are not any validation token for this user.",
												UserServiceError.TOKEN_NOT_FOUND));
		verificationToken.setToken(token);
		Date date = VerificationToken.calculateExpiryDate();
		verificationToken.setExpiryDate(date);
		verificationToken = verificationTokenRepository.save(verificationToken);
		return true;
	}

	@Override
	public Boolean enableUserForVerificationToken(String token) throws UserServiceException {
		VerificationToken verificationToken = verificationTokenRepository.findOneByToken(token).orElseThrow(
				() -> new UserServiceException("Token register cannot be found for such token value.",
												UserServiceError.TOKEN_NOT_FOUND));
		Date expiryDate = verificationToken.getExpiryDate();
		Date currentDate = new Date();
		if(expiryDate.getTime() - currentDate.getTime() < 0L) {
			throw new UserServiceException("The verification token for this user has expired.",
											UserServiceError.TOKEN_EXPIRED);
		}
		User user = verificationToken.getUser();
		if(user.isEnabled()) {
			throw new UserServiceException("The user has been verified already.",
											UserServiceError.USER_ENABLED);
		}
		user.setEnabled(true);
		userRepository.save(user);
		return true;
	}

	@Override
	public String getVerificationToken(String loginAlias) throws UserServiceException {
		User user = userRepository.findOneByLoginAlias(loginAlias).orElseThrow(
				() -> new UserServiceException(
						"An user for such alias is not found while trying the associated registration token.",
						UserServiceError.USER_NOT_FOUND));
		VerificationToken verificationToken = verificationTokenRepository.findOneByUser(user).orElseThrow(
				() -> new UserServiceException("Token register cannot be found for such user.",
												UserServiceError.TOKEN_NOT_FOUND));
		return verificationToken.getToken();
	}

}
