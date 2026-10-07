package org.example.day9.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFound(
            ResourceNotFoundException exception) {

        Map<String, String> response = new HashMap<>();

        response.put("error", "Resource Not Found");
        response.put("message", exception.getMessage());
        response.put("status", "404");

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}