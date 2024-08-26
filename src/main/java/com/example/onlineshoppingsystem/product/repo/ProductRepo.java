package com.example.onlineshoppingsystem.product.repo;

import com.example.onlineshoppingsystem.product.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>
{
    public Product findByProductName(String productName);

    public List<Product> findByProductCatagory(String prodCategory);

    public List<Product> findByProductPrice(double productPrice);

    public List<Product> findByProductRating(int productRating);

    public List<Product> findByProductPriceGreaterThan(double productPrice);

    public List<Product> findByProductPriceLessThan(double productPrice);
}
