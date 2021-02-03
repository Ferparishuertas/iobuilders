package local.poc.blockchain.customers.management.registration.service.exception;

import local.poc.blockchain.customers.management.registration.service.error.ServiceError;

public class NaturalPersonServiceException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public NaturalPersonServiceException() {
		super();
	}

	public NaturalPersonServiceException(ServiceError serviceError) {
		super(serviceError);
	}

	public NaturalPersonServiceException(String message, ServiceError serviceError) {
		super(message, serviceError);
	}

	public NaturalPersonServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace, ServiceError serviceError) {
		super(message, cause, enableSuppression, writableStackTrace, serviceError);
	}

	public NaturalPersonServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NaturalPersonServiceException(String message, Throwable cause, ServiceError serviceError) {
		super(message, cause, serviceError);
	}

	public NaturalPersonServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public NaturalPersonServiceException(String message) {
		super(message);
	}

	public NaturalPersonServiceException(Throwable cause, ServiceError serviceError) {
		super(cause, serviceError);
	}

	public NaturalPersonServiceException(Throwable cause) {
		super(cause);
		
	}
	
}
