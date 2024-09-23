package com.glchallenge.handler;

 import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
		String detail = "";
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            detail += error.getField() + " - " + error.getDefaultMessage();
        }

        ValidationErrorResponse errorResponse = new ValidationErrorResponse(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            detail
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
