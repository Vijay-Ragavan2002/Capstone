package com.example.onlineshoppingsystem.product.exception;

public class ProductNotFoundException extends RuntimeException
{
    public ProductNotFoundException(String message)
    {
        super(message);
    }
}
