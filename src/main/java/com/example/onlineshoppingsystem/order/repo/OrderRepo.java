package com.example.onlineshoppingsystem.order.repo;

import com.example.onlineshoppingsystem.order.dto.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>, OrderCustomRepo
{

}
