package com.example.onlineshoppingsystem.product.service;

import com.example.onlineshoppingsystem.product.dto.Product;
import com.example.onlineshoppingsystem.product.exception.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ProductService
{
    public Product save(Product product);

    public List<Product> findAll();

    public void delete(int productId);

    public Product update(Product product);

    public Optional<Product> findByProductId(int productId) throws ProductNotFoundException;

    public List<Product> findByCatagory(String prodCategory) throws ProductNotFoundException;

    public Product findByProductName(String productName) throws ProductNotFoundException;

    public List<Product> findByProductPrice(double productPrice);

    public List<Product> findByProductRating(int productRating);

    public List<Product> findByProductPriceGreaterThan(double productPrice);

    public List<Product> findByProductPriceLessThan(double productPrice);


}
