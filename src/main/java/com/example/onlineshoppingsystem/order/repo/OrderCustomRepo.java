package com.example.onlineshoppingsystem.order.repo;

public interface OrderCustomRepo
{
    public void orderProduct(int customerId, int productId, int quantity);

    public void orderFromCart(int customerId);

    public void updateOrder(int customerId, int productId, int quantity);

    public String deleteProduct(int customerId, int productId);

    public void cancelOrder(int customerId);

    public String reduceQuantity(int customerId, int productId, int quantity);

}
