package com.example.onlineshoppingsystem.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandlerProduct
{
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProductNotFoundException(ProductNotFoundException ex)
    {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("No Existing Product : ", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductOutOfStockException.class)
    public ResponseEntity<Map<String, String>> handleProductOutOfStockException(ProductOutOfStockException ex)
    {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("No Stock : ", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
