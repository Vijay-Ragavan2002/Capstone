package com.example.onlineshoppingsystem.cart.repo;

public interface CartCustomInterface
{
    public String addToCart(int customerId, int productId,int quantity);

    public String removeFromCart(int customerId, int productId, int quantity);

    public void removeCart(int customerId);
}
