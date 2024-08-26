package com.example.onlineshoppingsystem.order.dto;

import com.example.onlineshoppingsystem.product.dto.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class OrderItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderItemId;
    private int orderProdId;
    private int orderQuantity;

    @ManyToOne
    Product product;

    private double orderProductPrice;
    private double orderProductTotal;
    private boolean orderStatus;
}
