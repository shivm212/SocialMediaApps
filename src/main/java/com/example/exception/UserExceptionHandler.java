package com.example.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler  {
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<UserDetailsException> handleAllException(Exception ex, WebRequest request) throws Exception {
		UserDetailsException errDtails = new UserDetailsException(ex.getMessage(),request.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<>(errDtails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<UserDetailsException> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		UserDetailsException errDtails = new UserDetailsException(ex.getMessage(),request.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<>(errDtails,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		UserDetailsException errDtails = new UserDetailsException(ex.getFieldError().getDefaultMessage(),request.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<>(errDtails,HttpStatus.BAD_REQUEST);
	}
	

}
