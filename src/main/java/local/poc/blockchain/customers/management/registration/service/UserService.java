package local.poc.blockchain.customers.management.registration.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import local.poc.blockchain.customers.management.registration.service.exception.UserServiceException;

public interface UserService extends UserDetailsService {
	
	/**
	 * Returns if the user's alias and/or registration email address are present in the
	 * system for the same user. You can check any of them separately or both at the
	 * same time. In the latest case, the result will be false if any or the two are not
	 * present. By setting the parameters to the value you want to check they will be
	 * considered. An <code>IllegalArgumentException</code> is thrown if both parameters
	 * are null.
	 * @param loginAlias, the user alias to check.
	 * @param loginEmail, the email address to check.
	 * @return true if all the parameters to be checked are present for the same user, else false.
	 * @throws IllegalArgumentException if none of the parameters are indicated to be checked.
	 */
	public Boolean checkUserLoginAliasAndEmail(String loginAlias, String loginEmail)
	throws IllegalArgumentException;
	
	/**
	 * Records the verification <code>token</code> associated to the user's alias,
	 * <code>loginAlias</code>, in the system. Throws an <code>UserServiceException</code>
	 * if the user's alias is not registered in the system, the user is enabled already or
	 * the <code>token</code> was recorded before. The token will be available for
	 * the verification of the user 24h since it is recorded. Then, it will expire and be
	 * invalidated, and other token has to be generated for another try of verification.
	 * This has to be done with the method <code>updateVerificationTokenForUserAlias</code>.
	 * @param loginAlias The alias of the user.
	 * @param token The token to be recorded.
	 * @return true, if the token was updated.
	 * @throws UserServiceException, if the user's alias cannot be found, the user is enabled
	 * or the token was recorded previously.
	 */
	public Boolean recordVerificationTokenForUserAlias(String loginAlias, String token)
	throws UserServiceException;
	
	/**
	 * Update the verification <code>token</code> associated to the user's alias,
	 * <code>loginAlias</code>, in the system. Throws an <code>UserServiceException</code>
	 * if the user's alias is not registered in the system, the user is enabled or there
	 * are not any previous validaton token in the system for such user. The token will be
	 * available for the verification of the user 24h since it is recorded.
	 * @param loginAlias The alias of the user.
	 * @param token The token to be updated.
	 * @return true if the token was recorded, else false.
	 * @throws UserServiceException, if the user's alias cannot be found, the user is enabled
	 * or the token was recorded previously.
	 */
	public Boolean updateVerificationTokenForUserAlias(String loginAlias, String token)
	throws UserServiceException;
	
	/**
	 * Based on the verificaction <code>token</code>, the user associated to it
	 * is enabled if it was not done previously. A <code>UserServiceException</code>
	 * is thrown if the token was not recorded in the system, the token was expired
	 * or the user was enabled already.  
	 * @param token The verification token.
	 * @return true, if the user was enabled.
	 * @throws UserServiceException, if the token cannot be found, it is expired or the user
	 * associated to it is enabled already.
	 */
	public Boolean enableUserForVerificationToken(String token)
	throws UserServiceException;
	
	
	/**
	 * Return the token for the user whose alias is <code>loginAlias</code>.
	 * @param loginAlias
	 * @return The token if it was registered, else throw a <code>UserServiceException</code>.
	 * @throws UserServiceException, if the user or the token do not exists in the system.
	 */
	public String getVerificationToken(String loginAlias)
	throws UserServiceException;
	

}
