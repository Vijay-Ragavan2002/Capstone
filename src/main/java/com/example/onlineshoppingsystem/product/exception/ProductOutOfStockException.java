package com.example.onlineshoppingsystem.product.exception;

public class ProductOutOfStockException extends RuntimeException
{
    public ProductOutOfStockException(String message)
    {
        super(message);
    }
}
