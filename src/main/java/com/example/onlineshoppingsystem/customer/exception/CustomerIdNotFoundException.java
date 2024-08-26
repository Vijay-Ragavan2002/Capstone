package com.example.onlineshoppingsystem.customer.exception;

public class CustomerIdNotFoundException extends RuntimeException
{
    public CustomerIdNotFoundException (String message)
    {
        super(message);
    }
}
