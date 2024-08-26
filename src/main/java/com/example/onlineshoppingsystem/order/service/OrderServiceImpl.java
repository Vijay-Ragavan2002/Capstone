package com.example.onlineshoppingsystem.order.service;

import com.example.onlineshoppingsystem.order.dto.Order;
import com.example.onlineshoppingsystem.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public void orderProduct(int customerId, int productId, int quantity)
    {
        orderRepo.orderProduct(customerId,productId,quantity);
    }

    @Override
    public void orderFromCart(int customerId)
    {
        orderRepo.orderFromCart(customerId);
    }

    @Override
    public void updateOrder(int customerId, int productId, int quantity)
    {
        orderRepo.updateOrder(customerId,productId,quantity);
    }

    @Override
    public void deleteProduct(int customerId, int productId)
    {
        orderRepo.deleteProduct(customerId, productId);
    }

    @Override
    public void cancelOrder(int customerId)
    {
        orderRepo.cancelOrder(customerId);
    }

    @Override
    public List<Order> findAll()
    {
        return orderRepo.findAll();
    }

    @Override
    public String reduceQuantity(int customerId, int productId, int quantity)
    {
        return orderRepo.reduceQuantity(customerId,productId,quantity);
    }

}
