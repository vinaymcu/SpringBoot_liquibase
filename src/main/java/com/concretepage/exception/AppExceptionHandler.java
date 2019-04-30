package com.concretepage.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class AppExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(AppExceptionHandler.class);

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error occurred");
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler(ArticleNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(ArticleNotFoundException ex,
			WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		logger.info("inside AppExceptionHandler errorDetails:" + errorDetails);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler({ Exception.class })
//	public ResponseEntity<Object> handleAll( HttpRequestMethodNotSupportedException ex, WebRequest request) {
//		logger.info("inside AppExceptionHandler handleAll:");
//		
//		StringBuilder builder = new StringBuilder();
//	    builder.append(ex.getMethod());
//	    builder.append(
//	      " POST method is not supported for this request. ");
//	   // ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));
//		ApiError apiError = new ApiError(HttpStatus.METHOD_NOT_ALLOWED, 
//			      ex.getLocalizedMessage(), builder.toString());
//				
//		return new ResponseEntity<Object>(
//			      apiError, new HttpHeaders(), apiError.getStatus());
//		 
//	}

//	@Override
//	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
//	  HttpRequestMethodNotSupportedException ex, 
//	  HttpHeaders headers, 
//	  HttpStatus status, 
//	  WebRequest request) {
//		logger.info(" inside handleHttpRequestMethodNotSupported ");
//	    StringBuilder builder = new StringBuilder();
//	    builder.append(ex.getMethod());
//	    builder.append(
//	      " method is not supported for this request. Supported methods are ");
//	    ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));
//	 
//	    ApiError apiError = new ApiError(HttpStatus.METHOD_NOT_ALLOWED, 
//	      ex.getLocalizedMessage(), builder.toString());
//	    logger.info(" end inside handleHttpRequestMethodNotSupported ");
//	    return new ResponseEntity<Object>(
//	      apiError, new HttpHeaders(), apiError.getStatus());
//	}

}