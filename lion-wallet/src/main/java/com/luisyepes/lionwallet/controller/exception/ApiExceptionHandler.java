package com.luisyepes.lionwallet.controller.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.luisyepes.lionwallet.domain.exception.CategoryAlreadyExistsException;
import com.luisyepes.lionwallet.domain.exception.CategoryNotFoundException;
import com.luisyepes.lionwallet.validation.util.ErrorMessages;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<?> handleNoResourceFoundException(Exception ex){
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(), 
				ex.getClass().getSimpleName(),
				ErrorMessages.RESOURCE_NOT_FOUND);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({
		IncorrectMovementRqstException.class,
		MissingServletRequestParameterException.class
	})
	public ResponseEntity<?> handleBadRequestException(Exception ex){
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(), 
				ex.getClass().getSimpleName(),
				ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({
		CategoryNotFoundException.class
	})
	public ResponseEntity<?> handleNotFoundException(Exception ex){
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(), 
				ex.getClass().getSimpleName(),
				ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({
		CategoryAlreadyExistsException.class
	})
	public ResponseEntity<?> handleConflictException(Exception ex){
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(), 
				ex.getClass().getSimpleName(),
				ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
	}
	
}
