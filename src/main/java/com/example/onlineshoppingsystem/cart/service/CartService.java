package com.example.onlineshoppingsystem.cart.service;

import com.example.onlineshoppingsystem.cart.dto.Cart;

public interface CartService
{
    public void addToCart(int customerId, int productId,int quantity);

    public void removeFromCart(int customerId, int productId, int quantity);

    public Cart findByCartId(int cartId);

    public void removeCart(int customerId);

    public Cart findByCustomerId(int customerId);
}
