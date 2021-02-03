package local.poc.blockchain.customers.management.registration.service.error;

public enum ReferencesServiceError implements ServiceError {
	
	UNEXPECTED_ERROR(1000, "Unexpected error.");
	
	private final int code;
	
	private final String description;
	
	private ReferencesServiceError(int code, String description) {
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
	
	public static ReferencesServiceError resolve(ServiceError serviceError) {
		ReferencesServiceError result = null;
		for(ReferencesServiceError err : ReferencesServiceError.values()) {
			if(err.code == serviceError.getCode()) {
				result = err;
				break;
			}
		}
		return result;
	}

}
