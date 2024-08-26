package com.example.onlineshoppingsystem.product.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class Product
{
    @Id
    private int productId;
    private String productName;
    private String productCatagory;
    private double productPrice;
    private int productRating;
    private int productStock;
}
