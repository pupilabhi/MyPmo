package com.connectivity.vikray.advice;

import java.util.Optional;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.connectivity.vikray.exception.ResourceNotFoundException;

@ControllerAdvice
public class PMOControllerAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	  public ResponseEntity<VndErrors> notFoundException(final ResourceNotFoundException e) {
	    return error(e, HttpStatus.NOT_FOUND, e.toString());
	  }

	  private ResponseEntity<VndErrors> error(
	      final Exception exception, final HttpStatus httpStatus, final String logRef) {
	    final String message =
	        Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
	    return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
	  }

	  @ExceptionHandler(IllegalArgumentException.class)
	  public ResponseEntity<VndErrors> assertionException(final IllegalArgumentException e) {
	    return error(e, HttpStatus.NOT_FOUND, e.getLocalizedMessage());
	  }
}
