package com.example.onlineshoppingsystem.cart.dto;

import com.example.onlineshoppingsystem.cartLine.dto.CartLine;
import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Cart
{
    @Id
    @GeneratedValue
    private int cartId;

    @JsonBackReference
    @OneToOne//(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private List<CartLine> productList = new ArrayList<>();
}
