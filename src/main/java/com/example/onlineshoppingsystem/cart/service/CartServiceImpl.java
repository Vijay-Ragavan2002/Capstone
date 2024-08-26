package com.example.onlineshoppingsystem.cart.service;

import com.example.onlineshoppingsystem.cart.dto.Cart;
import com.example.onlineshoppingsystem.cart.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService
{
    @Autowired
    private CartRepo cartRepo;

    @Override
    public void addToCart(int customerId, int productId,int quantity)
    {
        cartRepo.addToCart(customerId,productId,quantity);
    }

    @Override
    public void removeFromCart(int customerId, int productId, int quantity)
    {
        cartRepo.removeFromCart(customerId,productId,quantity);
    }

    @Override
    public Cart findByCartId(int cartId)
    {
        return cartRepo.findById(cartId).get();
    }

    @Override
    public void removeCart(int customerId)
    {
        cartRepo.removeCart(customerId);
    }

    @Override
    public Cart findByCustomerId(int customerId)
    {
        return cartRepo.findById(customerId).get();
    }
}
