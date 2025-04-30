package com.demo.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.demo.payload.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleException(
			Exception e,
			WebRequest request
			){
		ErrorDetails error = new ErrorDetails(e.getMessage(), new Date(), request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(ResourceNotfoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotfoundException(
			ResourceNotfoundException e,
			WebRequest request
			){
		ErrorDetails error = new ErrorDetails(e.getMessage(), new Date(), request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
