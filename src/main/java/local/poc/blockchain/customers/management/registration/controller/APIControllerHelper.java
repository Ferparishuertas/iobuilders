package local.poc.blockchain.customers.management.registration.controller;

import static local.poc.blockchain.customers.management.registration.util.Global.getTimestampNowTxt;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NOT_IMPLEMENTED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import local.poc.blockchain.customers.management.registration.datobj.dto.OptionListUserPersonDTO;
import local.poc.blockchain.customers.management.registration.datobj.dto.ResponseEnvelope;
import local.poc.blockchain.customers.management.registration.datobj.dto.UserPersonInfoDTO;
import local.poc.blockchain.customers.management.registration.datobj.svo.OptionListUserPersonSVO;
import local.poc.blockchain.customers.management.registration.datobj.svo.UserPersonInfoSVO;
import local.poc.blockchain.customers.management.registration.exception.AutoConversionException;

public class APIControllerHelper {
	
	public static class APIResponseBuilder<T> {
		
		private HttpStatus httpStatus = null;
		
		private HttpHeaders httpHeaders = null;
		
		private ResponseEnvelope<T> envelope = null;
		
		public APIResponseBuilder() {
			httpStatus = NO_CONTENT;
			httpHeaders = DEFAULT_HEADERS_JSON;
			envelope = new ResponseEnvelope<T>();
			envelope.setStatus(this.httpStatus.value());
			envelope.setCode(127);
			envelope.setDevMsg("N/A");
			envelope.setPayload(null);
			envelope.setTimestamp(null);
		}
		
		public APIResponseBuilder<T> status(HttpStatus statusValue) {
			this.httpStatus = statusValue;
			this.envelope.setStatus(statusValue.value());
			return this;
		}
		
		public APIResponseBuilder<T> ok() {
			return status(OK);
		}
		
		public APIResponseBuilder<T> accepted() {
			return status(ACCEPTED);
		}
		
		public APIResponseBuilder<T> ceated() {
			return status(CREATED);
		}
		
		public APIResponseBuilder<T> badRequest() {
			return status(BAD_REQUEST);
		}
		
		public APIResponseBuilder<T> unAuthorized() {
			return status(UNAUTHORIZED);
		}
		
		public APIResponseBuilder<T> forbidden() {
			return status(FORBIDDEN);
		}
		
		public APIResponseBuilder<T> notFound() {
			return status(NOT_FOUND);
		}
		
		public APIResponseBuilder<T> noContent() {
			return status(NO_CONTENT);
		}
		
		public APIResponseBuilder<T> internalServerError() {
			return status(INTERNAL_SERVER_ERROR);
		}
		
		public APIResponseBuilder<T> notImplemented() {
			return status(NOT_IMPLEMENTED);
		}
		
		public APIResponseBuilder<T> code(Integer codeValue) {
			this.envelope.setCode(codeValue);
			return this;
		}
		
		public APIResponseBuilder<T> devMsg(String msg) {
			this.envelope.setDevMsg(msg);
			return this;
		}
		
		public APIResponseBuilder<T> httpHeaders(HttpHeaders headers) {
			this.httpHeaders = headers;
			return this;
		}
		
		public APIResponseBuilder<T> payload(T payload) {
			this.envelope.setPayload(payload);
			return this;
		}
		
		public ResponseEntity<ResponseEnvelope<T>> res() {
			envelope.setTimestamp(getTimestampNowTxt());
			return ResponseEntity.status(httpStatus)
								 .headers(httpHeaders)
								 .body(envelope);
		}
		
		public ResponseEntity<ResponseEnvelope<?>> build() {
			envelope.setTimestamp(getTimestampNowTxt());
			return ResponseEntity.status(httpStatus)
								 .headers(httpHeaders)
								 .body(envelope);
		}
		
		public <C> ResponseEntity<C> responseEntity(Class<C> clazz) {
			envelope.setTimestamp(getTimestampNowTxt());
			return ResponseEntity.status(httpStatus)
								 .headers(httpHeaders)
								 .body(clazz.cast(envelope));
		}
		
	}
	
	public static class APIResponse {
		public static <T> APIResponseBuilder<T> payload(T value) {
			return new APIResponseBuilder<T>().payload(value);
		}
	}
	
	
	/**
	 * Default http headers for the API responses.
	 */
	private static final HttpHeaders DEFAULT_HEADERS_JSON;
	static {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		DEFAULT_HEADERS_JSON = httpHeaders;
	}
	
	
	/**
	 * An empty array of objects of type Object.
	 */
	private static final Object[] EMTPY_ARRAY = new Object[] {};
	
	/**
	 * Response to be generated by the API when the unit received cannot be found in the system.
	 * @return The response indicating that the unit cannot be found.
	 */
	static ResponseEntity<ResponseEnvelope<?>> unitNotFoundResponseJson() {
		final HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	    ResponseEnvelope<String> envelop = new ResponseEnvelope<>();
		envelop.setStatus(NOT_FOUND.value());
		envelop.setCode(127);
		envelop.setDevMsg("N/A");
		envelop.setTimestamp("9999-01-01T00:00:00.000");
		envelop.setPayload("The indicated unit could not be found in the system.");
		return new ResponseEntity<>(envelop, httpHeaders, NOT_FOUND);
	}
	
	/////
	// NOTE!!!
	// Consider to use http://modelmapper.org/getting-started/
	// for conversion between models and SVO/DTO
	//
	
	/**
	 * @param <S>
	 * @param <D>
	 * @param origin
	 * @param destination
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 */
	static <S, D> void assignSameAttributes(S origin, D destination)
	throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
		   InstantiationException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		Method[] methods1 = origin.getClass().getMethods();
		Map<String, Method> getMethods =
			Stream.of(methods1)
			      .filter(m -> m.getName().startsWith("get"))
				  .collect(Collectors.toMap(m -> m.getName().replace("get", ""),
						  					m -> m));
		Method[] methods2 = destination.getClass().getMethods();
		Map<String, Method> setMethods =
			Stream.of(methods2)
			      .filter(m -> m.getName().startsWith("set"))
				  .collect(Collectors.toMap(m -> m.getName().replace("set", ""),
						  					m -> m));
		Set<String> names = getMethods.keySet();
		Set<String> names2 = setMethods.keySet();
		names.retainAll(names2);
		for(String name : names) {
			Method getMethod = getMethods.get(name);
			Method setMethod = setMethods.get(name);
			Class<?> returnType = getMethod.getReturnType();
			Class<?>[] paramTypes = setMethod.getParameterTypes();
			if(paramTypes.length == 1) {
				Class<?> paramType = paramTypes[0];
				if(returnType.equals(paramType)) {
					Object value = getMethod.invoke(origin, EMTPY_ARRAY);
					if(value == null
					   || !Collection.class.isAssignableFrom(returnType)) {
						setMethod.invoke(destination, value);
					} else {
						Collection<?> collection = (Collection<?>)value;
						@SuppressWarnings("unchecked")
						Collection<Object> peerCollection = collection.getClass().getDeclaredConstructor().newInstance(EMTPY_ARRAY);
						for(Object item : collection) {
							Object peerItem = null;
							Class<?> itemClass = item.getClass();
							String clazzName = itemClass.getSimpleName();
							if(clazzName.contains("DTO")) {
								String peerClazzName = 
								"local.poc.blockchain.customers.management.registration.datobj.svo." + clazzName.replace("DTO", "SVO");
								Class<?> peerClazz = Class.forName(peerClazzName);
								peerItem = peerClazz.getDeclaredConstructor().newInstance(EMTPY_ARRAY);
								assignSameAttributes(item, peerItem);
							} else if(clazzName.contains("SVO")) {
								String peerClazzName = 
								"local.poc.blockchain.customers.management.registration.datobj.dto." + clazzName.replace("SVO", "DTO");
								Class<?> peerClazz = Class.forName(peerClazzName);
								peerItem = peerClazz.getDeclaredConstructor().newInstance(EMTPY_ARRAY);
								assignSameAttributes(item, peerItem);
							} else { // Simple types: String, Integers, etc
								peerItem = item;
							}
							peerCollection.add(peerItem);
						}
						setMethod.invoke(destination, peerCollection);
					}
				} else {
					String returnName = returnType.getSimpleName().replace("DTO","").replace("SVO","");
					String paramName = paramType.getSimpleName().replace("DTO","").replace("SVO","");
					if(returnName.equals(paramName)) {
						Object paramObj = paramType.getDeclaredConstructor().newInstance(EMTPY_ARRAY);
						Object returnObj = getMethod.invoke(origin, EMTPY_ARRAY);
						assignSameAttributes(returnObj, paramObj);
						setMethod.invoke(destination, paramObj);
					}
				}
			}
		}
	}
	
	/**
	 * Builds a UserPersonInfoSVO object from a UserPersonInfoDTO object
	 * invoking assignSameAttributes.
	 * @param dto The object taken as reference for building the new one.
	 * @return The UserPersonInfoSVO object.
	 * @throws AutoConversionException if the svo object cannot be built automatically.
	 */
	static UserPersonInfoSVO userPersonInfoDTOtoSVO(UserPersonInfoDTO dto)
	throws AutoConversionException {
		UserPersonInfoSVO result = null;
		try {
			result = new UserPersonInfoSVO();
			assignSameAttributes(dto, result);
		} catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
				InstantiationException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			throw new AutoConversionException("Could not convert dto to svo for UserPersonInfo.", e);
		}
		return result;
	}
	
	/**
	 * Builds a UserPersonInfoDTO object from a UserPersonInfoSVO object
	 * invoking assignSameAttributes.
	 * @param svo The object taken as reference for building the new one.
	 * @return The UserPersonInfoDTO object.
	 * @throws AutoConversionException if the dto object cannot be built automatically.
	 */
	static UserPersonInfoDTO userPersonInfoSVOtoDTO(UserPersonInfoSVO svo)
	throws AutoConversionException {
		UserPersonInfoDTO result = null;
		try {
			result = new UserPersonInfoDTO();
			assignSameAttributes(svo, result);
		} catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
				InstantiationException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			throw new AutoConversionException("Could not convert svo to dto for UserPersonInfo.", e);
		}
		return result;
	}
	
	/**
	 * Builds a OptionListUserPersonDTO object from a OptionListUserPersonSVO object
	 * invoking assignSameAttributes.
	 * @param svo The object taken as reference for building the new one.
	 * @return The OptionListUserPersonDTO object.
	 * @throws AutoConversionException if the dto object cannot be built automatically.
	 */
	static OptionListUserPersonDTO optionListUserPersonSVOtoDTO(OptionListUserPersonSVO svo)
	throws AutoConversionException {
		OptionListUserPersonDTO result = null;
		try {
			result = new OptionListUserPersonDTO();
			assignSameAttributes(svo, result);
		} catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
				InstantiationException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			throw new AutoConversionException("Could not convert svo to dto for OptionListUserPerson.", e);
		}
		return result;
	}

}
