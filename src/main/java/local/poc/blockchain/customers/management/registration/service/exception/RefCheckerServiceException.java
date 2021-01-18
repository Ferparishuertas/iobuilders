package local.poc.blockchain.customers.management.registration.service.exception;

import local.poc.blockchain.customers.management.registration.service.error.ServiceError;

public class RefCheckerServiceException extends ServiceException {

	private static final long serialVersionUID = 5486520458323491805L;

	public RefCheckerServiceException() {
		super();
	}

	public RefCheckerServiceException(ServiceError serviceError) {
		super(serviceError);
	}

	public RefCheckerServiceException(String message, ServiceError serviceError) {
		super(message, serviceError);
	}

	public RefCheckerServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace, ServiceError serviceError) {
		super(message, cause, enableSuppression, writableStackTrace, serviceError);
	}

	public RefCheckerServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RefCheckerServiceException(String message, Throwable cause, ServiceError serviceError) {
		super(message, cause, serviceError);
	}

	public RefCheckerServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public RefCheckerServiceException(String message) {
		super(message);
	}

	public RefCheckerServiceException(Throwable cause, ServiceError serviceError) {
		super(cause, serviceError);
	}

	public RefCheckerServiceException(Throwable cause) {
		super(cause);
	}
	
}
