package local.poc.blockchain.customers.management.registration.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.GONE;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NOT_IMPLEMENTED;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import local.poc.blockchain.customers.management.registration.controller.APIControllerHelper.APIResponse;
import local.poc.blockchain.customers.management.registration.exception.AutoConversionException;
import local.poc.blockchain.customers.management.registration.exception.DateJsonDeserializerException;
import local.poc.blockchain.customers.management.registration.service.error.NaturalPersonServiceError;
import local.poc.blockchain.customers.management.registration.service.error.ReferencesServiceError;
import local.poc.blockchain.customers.management.registration.service.error.ServiceError;
import local.poc.blockchain.customers.management.registration.service.error.UserServiceError;
import local.poc.blockchain.customers.management.registration.service.exception.NaturalPersonServiceException;
import local.poc.blockchain.customers.management.registration.service.exception.ReferencesServiceException;
import local.poc.blockchain.customers.management.registration.service.exception.UserServiceException;

@ControllerAdvice
public class APIControllerExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(APIControllerExceptionHandler.class);
	
	@Override
	protected ResponseEntity<Object>
	handleExceptionInternal(Exception ex,
							@Nullable Object body,
							HttpHeaders headers,
							HttpStatus status,
							WebRequest request) {
		if (INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute(
					WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
		}
		String devMsg = generateDevMsg(request);
		if(body == null ) {
			LOGGER.error("INTERNAL EXCEPTION: " + devMsg + " ;;; " + ex.getMessage(), ex);
		}
        return APIResponse.payload(body)
        				  .httpHeaders(headers)
        				  .devMsg(devMsg)
        				  .status(status)
        				  .responseEntity(Object.class);
	}
	
	protected ResponseEntity<Object>
	handleExceptionInternal(Exception ex,
							@Nullable Object body,
							HttpHeaders headers,
							HttpStatus status,
							WebRequest request,
							Integer code) {
		if (INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute(
					WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
		}
		String devMsg = generateDevMsg(request);
		if(body == null ) {
			LOGGER.error("INTERNAL EXCEPTION: " + devMsg + " ;;; " + ex.getMessage(), ex);
		}
		if(code == null) {
			code = 127;
		}
        return APIResponse.payload(body)
        				  .httpHeaders(headers)
        				  .devMsg(devMsg)
        				  .status(status)
        				  .code(code)
        				  .responseEntity(Object.class);
	}
	
	
	@Override
	protected ResponseEntity<Object>
	handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
								 HttpHeaders headers,
								 HttpStatus status,
								 WebRequest request) {
		Class<?> clazz = ex.getRootCause().getClass();
		Object body = null;
		Integer code = null;
		if (JsonParseException.class.equals(clazz)) {
			body = "JSON Malformed. " + ((JsonParseException)(ex.getRootCause())).getOriginalMessage();
			code = 22;
		} else if (InvalidFormatException.class.equals(clazz)) {
			body = "Invalid JSON message. " + ((InvalidFormatException)(ex.getRootCause())).getOriginalMessage();
			code = 22;
		} else if (DateJsonDeserializerException.class.isAssignableFrom(clazz)) {
			body = "JSON Date bad format. " + ((DateJsonDeserializerException)(ex.getRootCause())).getMessage();
			code = 22;
		} else if (IOException.class.equals(clazz)) {
			body = "Invalid message. " + ((IOException)(ex.getRootCause())).getMessage();
			code = 22;
		}
		if(body != null && String.class.equals(body.getClass())) {
			body = ((String)body).replace("\"", "").replace("`", "");
		}
		return handleExceptionInternal(ex, body, headers, status, request, code);
	}
	
	@ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseStatus(value = BAD_REQUEST)
    public ResponseEntity<Object>
	handleResourceNotFoundException(ConstraintViolationException ex) {
        Map<String, String> payload = new HashMap<>();
	    ex.getConstraintViolations().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getMessage();
	        payload.put(fieldName, errorMessage);
	    });
        return APIResponse.payload(payload)
        				  .devMsg("N/A")
        				  .code(22)
        				  .badRequest()
        				  .responseEntity(Object.class);
    }
	
	@Override
	protected ResponseEntity<Object>
	handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
								 HttpHeaders headers,
								 HttpStatus status,
								 WebRequest request) {
		Map<String, String> payload = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        payload.put(fieldName, errorMessage);
	    });
        return APIResponse.payload(payload)
        				  .devMsg("N/A")
        				  .code(22)
        				  .badRequest()
        				  .responseEntity(Object.class);
	}
	
	@ExceptionHandler(value = {UnsupportedOperationException.class})
    @ResponseStatus(value = NOT_IMPLEMENTED)
    public ResponseEntity<Object>
	handleUnsupportedOperationException(UnsupportedOperationException ex,
										WebRequest request) {
        String payload = ex.getMessage();
        return APIResponse.payload(payload)
        				  .devMsg("N/A")
        				  .badRequest()
        				  .responseEntity(Object.class);
    }
	
	@ExceptionHandler(value = {
			AutoConversionException.class,
			UnexpectedTypeException.class,
			NullPointerException.class})
    @ResponseStatus(value = INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object>
	handleAutoConversionException(Exception ex,
								  WebRequest request) {
		String devMsg = generateDevMsg(request);
		LOGGER.error(devMsg + " ;;; " + ex.getMessage(), ex);
		String payload = "Internal error managing the information. Please, contact to the administrator.";
		return APIResponse.payload(payload)
						  .devMsg(devMsg)
						  .internalServerError()
						  .responseEntity(Object.class);
    }
	
	@ExceptionHandler(value = {NaturalPersonServiceException.class})
    public ResponseEntity<Object>
	handleAutoConversionException(NaturalPersonServiceException ex,
								  WebRequest request) {
		ServiceError serviceError = ex.getServiceError();
		NaturalPersonServiceError err = NaturalPersonServiceError.resolve(serviceError);
		HttpStatus status = INTERNAL_SERVER_ERROR;
		String devMsg = "N/A";
		String payload = ex.getMessage();
		switch(err) {
		case LIST_OF_USERS_EMPTY:
		case USER_EMAIL_ALIAS_NOT_FOUND:
		case USER_LOGIN_ALIAS_NOT_FOUND:
		case USER_NOT_FOUND:
			status = NOT_FOUND;
			break;
		case USER_EMAIL_ALIAS_FOUND:
		case USER_FOUND:
		case USER_LOGIN_ALIAS_FOUND:
		case USER_LOGIN_ALIAS_OR_EMAIL_FOUND:
			status = CONFLICT;
			break;
		case UNEXPECTED_ERROR:
		default:
			devMsg = generateDevMsg(request);
			LOGGER.error(devMsg + " ;;; " + ex.getMessage(), ex);
			payload = "Internal error managing the information. Please, contact the administrator.";
			status = INTERNAL_SERVER_ERROR;
			break;
		}
		return APIResponse.payload(payload)
						  .devMsg(devMsg)
						  .status(status)
						  .responseEntity(Object.class);
    }
	
	@ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object>
	handleUserviceException(UserServiceException ex,
							WebRequest request) {
		ServiceError  serviceError = ex.getServiceError();
		UserServiceError err = UserServiceError.resolve(serviceError);
		HttpStatus status = INTERNAL_SERVER_ERROR;
		String devMsg = "N/A";
		String payload = ex.getMessage();
		switch(err) {
		case TOKEN_EXPIRED:
			status = GONE;
			break;
		case TOKEN_FOUND:
		case USER_ENABLED:
		case USER_FOUND:
			status = CONFLICT;
			break;
		case TOKEN_NOT_FOUND:
		case USER_EMAIL_ALIAS_NOT_FOUND:
		case USER_LOGIN_ALIAS_NOT_FOUND:
		case USER_NOT_FOUND:
			status = NOT_FOUND;
			break;
		case UNEXPECTED_ERROR:
		default:
			devMsg = generateDevMsg(request);
			LOGGER.error(devMsg + " ;;; " + ex.getMessage(), ex);
			payload = "Internal error managing the information. Please, contact the administrator.";
			status = INTERNAL_SERVER_ERROR;
			break;
		}
		return APIResponse.payload(payload)
						  .devMsg(devMsg)
						  .status(status)
						  .responseEntity(Object.class);
	}
	
	@ExceptionHandler(value = {ReferencesServiceException.class})
    public ResponseEntity<Object>
	handleReferencesServiceException(ReferencesServiceException ex,
									 WebRequest request) {
		ServiceError  serviceError = ex.getServiceError();
		ReferencesServiceError err = ReferencesServiceError.resolve(serviceError);
		HttpStatus status = INTERNAL_SERVER_ERROR;
		String devMsg = "N/A";
		String payload = ex.getMessage();
		switch(err) {
		case UNEXPECTED_ERROR:
		default:
			devMsg = generateDevMsg(request);
			LOGGER.error(devMsg + " ;;; " + ex.getMessage(), ex);
			payload = "Internal error managing the information. Please, contact the administrator.";
			status = INTERNAL_SERVER_ERROR;
			break;
		}
		return APIResponse.payload(payload)
						  .devMsg(devMsg)
						  .status(status)
						  .responseEntity(Object.class);
	}
	
	private String generateDevMsg(WebRequest request) {
		String devMsg = "ERRSERV[" + UUID.randomUUID().toString() + "]";
		if(request instanceof ServletWebRequest) {
			devMsg += "[" + ((ServletWebRequest)request).getRequest().getRequestURI() + "]";
		}
		return devMsg;
	}
	
}
