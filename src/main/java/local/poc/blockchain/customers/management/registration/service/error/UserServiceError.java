package local.poc.blockchain.customers.management.registration.service.error;

public enum UserServiceError implements ServiceError {

	USER_FOUND(1, "The user was registered in the system"), // Not used yet
	USER_NOT_FOUND(2, "The user is not registered in the system"),
	USER_LOGIN_ALIAS_NOT_FOUND(3, "The login alias is not registered in the system."), // Not used yet
	USER_EMAIL_ALIAS_NOT_FOUND(4, "The login email is not registered in the system."), // Not used yet
	USER_ENABLED(5, "The user is already enabled."),
	TOKEN_FOUND(11, "The token was registered in the system."),
	TOKEN_NOT_FOUND(12, "The token is not registered in the system."),
	TOKEN_EXPIRED(13, "The token expired."),
	UNEXPECTED_ERROR(1000, "Unexpected error.");
	
	private final int code;
	
	private final String description;
	
	private UserServiceError(int code, String description) {
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
	
	public static UserServiceError resolve(ServiceError serviceError) {
		UserServiceError result = null;
		for(UserServiceError err : UserServiceError.values()) {
			if(err.code == serviceError.getCode()) {
				result = err;
				break;
			}
		}
		return result;
	}

}
