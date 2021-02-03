package local.poc.blockchain.customers.management.registration.exception;

public class AutoConversionException extends RuntimeException {

	private static final long serialVersionUID = -1779352377039624815L;

	public AutoConversionException() {
		// NOTHING TO DO
	}

	public AutoConversionException(String message) {
		super(message);
	}

	public AutoConversionException(Throwable cause) {
		super(cause);
	}

	public AutoConversionException(String message, Throwable cause) {
		super(message, cause);
	}

	public AutoConversionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
