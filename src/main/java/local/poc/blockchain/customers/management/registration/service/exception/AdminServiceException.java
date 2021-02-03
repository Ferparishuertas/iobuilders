package local.poc.blockchain.customers.management.registration.service.exception;

import local.poc.blockchain.customers.management.registration.service.error.ServiceError;

public class AdminServiceException extends ServiceException {

	private static final long serialVersionUID = 1585863820383450732L;

	public AdminServiceException() {
		super();
	}

	public AdminServiceException(ServiceError serviceError) {
		super(serviceError);
	}

	public AdminServiceException(String message, ServiceError serviceError) {
		super(message, serviceError);
	}

	public AdminServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
			ServiceError serviceError) {
		super(message, cause, enableSuppression, writableStackTrace, serviceError);
	}

	public AdminServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AdminServiceException(String message, Throwable cause, ServiceError serviceError) {
		super(message, cause, serviceError);
	}

	public AdminServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public AdminServiceException(String message) {
		super(message);
	}

	public AdminServiceException(Throwable cause, ServiceError serviceError) {
		super(cause, serviceError);
	}

	public AdminServiceException(Throwable cause) {
		super(cause);
	}

}
