package com.example.onlineshoppingsystem.cart.repo;

import com.example.onlineshoppingsystem.cart.dto.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>,CartCustomInterface
{

}
