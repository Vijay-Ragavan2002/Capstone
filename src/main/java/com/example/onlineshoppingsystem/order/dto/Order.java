package com.example.onlineshoppingsystem.order.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Table(name = "OrderTable")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private int customerId;
    private double totalPrice;

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;
}
