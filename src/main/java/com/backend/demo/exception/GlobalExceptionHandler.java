package com.backend.demo.exception;

import com.backend.demo.dto.APIResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice(basePackages = "com.backend.demo.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<List<String>>> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .toList();

        APIResponse<List<String>> response = new APIResponse<>(LocalDateTime.now(),400,"validation failed",errors);


        return ResponseEntity.badRequest().body(response);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<APIResponse<List<String>>> handleConstraintViolation(
            ConstraintViolationException ex) {

        List<String> errors = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .toList();

        APIResponse<List<String>> response = new APIResponse(LocalDateTime.now(),400,"validation failed",errors);

        return ResponseEntity.badRequest().body(response);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<APIResponse<Void>> handleUserNotFound(UserNotFoundException ex){
        APIResponse<Void> response=new APIResponse(LocalDateTime.now(),404,ex.getMessage(),null);
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<Void>> handleGenericException(Exception ex){
        APIResponse<Void> response=new APIResponse(LocalDateTime.now(),500,"Internal server error",null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }


}