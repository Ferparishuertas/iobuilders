package local.poc.blockchain.customers.management.registration.service.exception;

import local.poc.blockchain.customers.management.registration.service.error.ServiceError;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 8957236152290920335L;

	private ServiceError serviceError = null;

	public ServiceException() {

	}

	public ServiceException(ServiceError serviceError) {
		this.serviceError = serviceError;
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, ServiceError serviceError) {
		super(message);
		this.serviceError = serviceError;
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(Throwable cause, ServiceError serviceError) {
		super(cause);
		this.serviceError = serviceError;
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message, Throwable cause, ServiceError serviceError) {
		super(message, cause);
		this.serviceError = serviceError;
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
			ServiceError serviceError) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.serviceError = serviceError;
	}
	
	public ServiceError getServiceError() {
		return serviceError;
	}

}
