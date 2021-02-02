package local.poc.blockchain.customers.management.registration.service.error;

public enum AdminServiceError implements ServiceError {
	
	CANNOT_CREATE_ADMIN_USER(100, "Cannot create user admin."),
	UNEXPECTED_ERROR(1000, "Unexpected error.");
	
	private final int code;
	
	private final String description;
	
	private AdminServiceError(int code, String description) {
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
	
	public static AdminServiceError resolve(ServiceError serviceError) {
		AdminServiceError result = null;
		for(AdminServiceError err : AdminServiceError.values()) {
			if(err.code == serviceError.getCode()) {
				result = err;
				break;
			}
		}
		return result;
	}

}
