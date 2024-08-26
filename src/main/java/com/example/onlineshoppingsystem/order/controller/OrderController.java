package com.example.onlineshoppingsystem.order.controller;

import com.example.onlineshoppingsystem.order.dto.Order;
import com.example.onlineshoppingsystem.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop/order")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public void orderProduct(@RequestParam int customerId, @RequestParam int productId, @RequestParam int quantity)
    {
        orderService.orderProduct(customerId, productId, quantity);
    }

    @PostMapping("/orderFromCart")
    public void orderFromCart(@RequestParam int customerId)
    {
        orderService.orderFromCart(customerId);
    }

    @PostMapping("/update")
    public void updateOrder(@RequestParam int customerId, @RequestParam int productId, @RequestParam int quantity)
    {
        orderService.updateOrder(customerId, productId, quantity);
    }

    //not working
    @PostMapping("/quantity")
    public void reduceQuantity(@RequestParam int customerId, @RequestParam int productId, @RequestParam int quantity)
    {
        orderService.reduceQuantity(customerId,productId,quantity);
    }

    @PostMapping("/deleteProduct")
    public void deleteProduct(@RequestParam int customerId, @RequestParam int productId)
    {
        orderService.deleteProduct(customerId,productId);
    }

    @PostMapping("/cancel")
    public void cancelOrder(@RequestParam int customerId)
    {
        orderService.cancelOrder(customerId);
    }

    @GetMapping("/findall")
    public List<Order> findAll()
    {
        return orderService.findAll();
    }
}
