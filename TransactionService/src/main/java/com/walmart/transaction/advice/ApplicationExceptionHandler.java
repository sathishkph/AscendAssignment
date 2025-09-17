package com.walmart.transaction.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.walmart.transaction.dto.ErrorResponse;
import com.walmart.transaction.exception.InsufficientBalanceException;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<String> handleInsufficentBalanceException(InsufficientBalanceException e) {
		return new ResponseEntity<>("Transaction Exception: " + e.getMessage(), HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),
				"Validation error. Check 'errors' field for details.");

		for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			errorResponse.addValidationError(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return ResponseEntity.unprocessableEntity().body(errorResponse);
	}

	@ExceptionHandler(java.nio.file.AccessDeniedException.class)
	public ResponseEntity<String> handleAccessDeniedException(java.nio.file.AccessDeniedException e) {
		return new ResponseEntity<>("You are not authorized to make this transaction.Please try login.", HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleRunTimeException(Exception e) {
		return new ResponseEntity<>("Internal Server Error ,Please refresh the page ",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
