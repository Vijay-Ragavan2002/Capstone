package com.example.onlineshoppingsystem.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandlerCustomer
{
    @ExceptionHandler(CustomerIdNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCustomerIdNotFoundException(CustomerIdNotFoundException ex)
    {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("No Existing Customer with", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerNameNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCustomerNameNotFoundException(CustomerNameNotFoundException ex)
    {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("No Existing Customer with Name ", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerCityNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCustomerCityNotFoundException(CustomerCityNotFoundException ex)
    {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("No Existing Customer with city ", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerPhoneNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCustomerPhoneNotFoundException(CustomerPhoneNotFoundException ex)
    {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("No Existing Customer with Phone ", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerEmailNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCustomerEmailNotFoundException(CustomerEmailNotFoundException ex)
    {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("No Existing Customer with Email ", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerPinCodeNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCustomerPinCodeNotFoundException(CustomerPinCodeNotFoundException ex)
    {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("No Existing Customer with PinCode ", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
