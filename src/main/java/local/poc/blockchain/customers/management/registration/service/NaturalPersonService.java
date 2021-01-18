package local.poc.blockchain.customers.management.registration.service;

import java.util.List;

import local.poc.blockchain.customers.management.registration.datobj.svo.OptionListUserPersonSVO;
import local.poc.blockchain.customers.management.registration.datobj.svo.UserPersonInfoSVO;
import local.poc.blockchain.customers.management.registration.service.exception.NaturalPersonServiceException;

public interface NaturalPersonService {
	
	/**
	 * Insert (i.e. register) a new natural person user in the system. It does
	 * not check any particular condition on the user. It is supposed that the
	 * svo object has been validated previously.
	 * @param userPersonInfo
	 * @return true if the user was correctly inserted in the system.
	 * @throws NaturalPersonServiceException, if an unexpected condition
	 * 		   happens.
	 */
	public Boolean registerNewUser(UserPersonInfoSVO userPersonInfo)
	throws NaturalPersonServiceException;
	
	
	/**
	 * Return the list of references to the natural users registered in the system.
	 * The references are object of type <code>OptionListUserPersonSVO</code>, for
	 * which each field are mapped as follows:
	 * - option => The registration alias of the user.
	 * - alias  => The registration alias of the user.
	 * - email  => The registration email of the user.
	 * - url    => A root url to which the option will be appended. This field is
	 *             optional and could be ommited. It is created only for helping
	 *             in the rest response to point to particular urls where finding
	 *             the information for each user.
	 * @param urlRoot null, or a url or string to which the <code>option</code>
	 * 		 		  value will be appended.
	 * @return The list of users that are registered in the system.
	 * @throws NaturalPersonServiceException, if an unexpected condition
	 * 		   happens.
	 */
	public List<OptionListUserPersonSVO> getUserList(String urlRoot)
	throws NaturalPersonServiceException;
	
	/**
	 * Returns the natural person user whose user's alias is <code>userLoginAlias</code> 
	 * @param userLoginAlias The alias of the user.
	 * @return the user, if it is a natural user and he/she is registered in the system.
	 * @throws NaturalPersonServiceException if the natural person user is not found
	 * 			or any unexpected condition arises.
	 */
	public UserPersonInfoSVO getUser(String userLoginAlias)
	throws NaturalPersonServiceException;
	
}
