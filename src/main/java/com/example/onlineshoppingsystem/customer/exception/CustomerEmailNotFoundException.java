package com.example.onlineshoppingsystem.customer.exception;

public class CustomerEmailNotFoundException extends RuntimeException
{
    public CustomerEmailNotFoundException (String message)
    {
        super(message);
    }
}
