package com.sharma.app.ws.mobileappws.ui.model.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sharma.app.ws.mobileappws.ui.model.response.CustomExceptionMessage;

// Default way to handle Exception Centralized

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
		
		// Line 26 - 30 Is for custom error Message
		// Creating custom error message Descritption
		
		String errorMessageDescription =   ex.getLocalizedMessage();
		if (errorMessageDescription == null)
			errorMessageDescription = ex.toString();
		
		CustomExceptionMessage cem = new CustomExceptionMessage(new Date(), errorMessageDescription);
		
		
		return new ResponseEntity<>(cem,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
