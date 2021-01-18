package local.poc.blockchain.customers.management.registration.service.exception;

import local.poc.blockchain.customers.management.registration.service.error.ServiceError;

public class UserServiceException extends ServiceException {

	private static final long serialVersionUID = 6625277109531112363L;

	public UserServiceException() {
		super();
	}

	public UserServiceException(ServiceError serviceError) {
		super(serviceError);
	}

	public UserServiceException(String message, ServiceError serviceError) {
		super(message, serviceError);
	}

	public UserServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
			ServiceError serviceError) {
		super(message, cause, enableSuppression, writableStackTrace, serviceError);
	}

	public UserServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserServiceException(String message, Throwable cause, ServiceError serviceError) {
		super(message, cause, serviceError);
	}

	public UserServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserServiceException(String message) {
		super(message);
	}

	public UserServiceException(Throwable cause, ServiceError serviceError) {
		super(cause, serviceError);
	}

	public UserServiceException(Throwable cause) {
		super(cause);
	}

	
}
