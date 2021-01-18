package local.poc.blockchain.customers.management.registration.service.exception;

import local.poc.blockchain.customers.management.registration.service.error.ServiceError;

public class ReferencesServiceException extends ServiceException {

	private static final long serialVersionUID = 7026417954343861919L;

	public ReferencesServiceException() {
		super();
	}

	public ReferencesServiceException(ServiceError serviceError) {
		super(serviceError);
	}

	public ReferencesServiceException(String message, ServiceError serviceError) {
		super(message, serviceError);
	}

	public ReferencesServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace, ServiceError serviceError) {
		super(message, cause, enableSuppression, writableStackTrace, serviceError);
	}

	public ReferencesServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ReferencesServiceException(String message, Throwable cause, ServiceError serviceError) {
		super(message, cause, serviceError);
	}

	public ReferencesServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReferencesServiceException(String message) {
		super(message);
	}

	public ReferencesServiceException(Throwable cause, ServiceError serviceError) {
		super(cause, serviceError);
	}

	public ReferencesServiceException(Throwable cause) {
		super(cause);
	}
	
	
	
}
