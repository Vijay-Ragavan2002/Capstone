package com.example.onlineshoppingsystem.customer.dto;

import com.example.onlineshoppingsystem.cart.dto.Cart;
import com.example.onlineshoppingsystem.order.dto.Order;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Customer
{
    @Id
    private int customerId;
    private String customerName;
    private String customerCity;
    private int customerPinCode;
    private String customerPhone;
    private String customerEmail;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cart cart;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Order order;
}
