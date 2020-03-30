package com.teste.ithappens.exceptions;

import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.teste.ithappens.dto.Response;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	// Exception lançado manualmente
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Response<?>> handleCustomException(CustomException e) throws IOException {
		Response<?> response = new Response<>();
		String msg = e.getMessage();
		if (e.getHttpStatus() == HttpStatus.NOT_FOUND) {
			LOG.error("ERRO: " + msg);
			msg = "Not found";
		}
		LOG.error("ERRO: " + msg);
		response.getErrors().add(msg);
		return ResponseEntity.status(e.getHttpStatus()).body(response);
	}	

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Response<?>> handleIllegalArgumentException(IllegalArgumentException e) throws IOException {
		Response<?> response = new Response<>();
		LOG.error("ERROR: " + e);
		response.getErrors().add(e.getMessage());
		return ResponseEntity.badRequest().body(response);
	}

	@ExceptionHandler(TransactionSystemException.class)
	public ResponseEntity<Response<?>> handleTransactionSystemException(Exception e) throws IOException {
		Response<?> response = new Response<>();
		Throwable cause = ((TransactionSystemException) e).getRootCause();
		Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) cause)
				.getConstraintViolations();
		for (ConstraintViolation<?> violation : constraintViolations) {
			LOG.error("ERRO: " + violation.getMessage());
			response.getErrors().add(violation.getMessage());
		}
		return ResponseEntity.badRequest().body(response);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response<?>> handleException(Exception e) throws IOException {
		Response<?> response = new Response<>();
		e.printStackTrace();
		LOG.error("ERROR: " + e);
		response.getErrors().add(e.getLocalizedMessage());
		return ResponseEntity.badRequest().body(response);
	}
}