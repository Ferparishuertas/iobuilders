package local.poc.blockchain.customers.management.registration.service.error;

public enum NaturalPersonServiceError implements ServiceError {
	
	USER_FOUND(1, "The user was registered in the system"), // Not used yet
	USER_NOT_FOUND(2, "The user is not registered in the system"),
	USER_LOGIN_ALIAS_FOUND(3, "The login alias is already registered in the system."), // Not used yet
	USER_LOGIN_ALIAS_NOT_FOUND(4, "The login alias is not registered in the system."), // Not used yet
	USER_EMAIL_ALIAS_FOUND(5, "The login email is already registered in the system."), // Not used yet
	USER_EMAIL_ALIAS_NOT_FOUND(6, "The login email is not registered in the system."), // Not used yet
	USER_LOGIN_ALIAS_OR_EMAIL_FOUND(7, "The login alias or the user is already present in the system."), // Not used yet
	LIST_OF_USERS_EMPTY(10, "There are not users in the system"), // Not used yet
	UNEXPECTED_ERROR(1000, "Unexpected error.");
	
	private final int code;
	
	private final String description;
	
	private NaturalPersonServiceError(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	@Override
	public int getCode() {
		return code;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	public static NaturalPersonServiceError resolve(ServiceError serviceError) {
		NaturalPersonServiceError result = null;
		for(NaturalPersonServiceError err : NaturalPersonServiceError.values()) {
			if(err.code == serviceError.getCode()) {
				result = err;
				break;
			}
		}
		return result;
	}
	
}
