package com.example.onlineshoppingsystem.cartLine.dto;

import com.example.onlineshoppingsystem.cart.dto.Cart;
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
public class CartLine
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartLineId;
    private int quantity;
    private int productId;
    private float unitPrice;
    private float totalPrice;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cart cart;
}
