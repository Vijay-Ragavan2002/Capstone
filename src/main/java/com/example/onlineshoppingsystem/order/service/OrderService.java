package com.example.onlineshoppingsystem.order.service;

import com.example.onlineshoppingsystem.order.dto.Order;

import java.util.List;

public interface OrderService
{
    public void orderProduct(int customerId, int productId, int quantity);

    public void orderFromCart(int customerId);

    public void updateOrder(int customerId, int productId, int quantity);

    public void deleteProduct(int customerId, int productId);

    public void cancelOrder(int customerId);

    public List<Order> findAll();

    public String reduceQuantity(int customerId, int productId, int quantity);
}
