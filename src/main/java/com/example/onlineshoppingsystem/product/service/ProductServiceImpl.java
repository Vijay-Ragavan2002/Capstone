package com.example.onlineshoppingsystem.product.service;

import com.example.onlineshoppingsystem.product.dto.Product;
import com.example.onlineshoppingsystem.product.exception.ProductNotFoundException;
import com.example.onlineshoppingsystem.product.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    ProductRepo productRepo;

    @Override
    public Product save(Product product)
    {
        return productRepo.save(product);
    }

    @Override
    public List<Product> findAll()
    {
        List<Product> products = productRepo.findAll();
        if (products.isEmpty())
        {
            throw new ProductNotFoundException("Empty");
        }
        return products;
    }

    @Override
    public void delete(int productId)
    {
        productRepo.deleteById(productId);
    }

    @Override
    public Product update(Product product)
    {
        return productRepo.save(product);
    }

    @Override
    public Optional<Product> findByProductId(int productId) throws ProductNotFoundException
    {
        Optional<Product> product =  productRepo.findById(productId);
        if (product.isEmpty())
        {
            throw new ProductNotFoundException("with productId : "+productId);
        }
        return product;
    }

    @Override
    public List<Product> findByCatagory(String prodCategory) throws ProductNotFoundException
    {
        List<Product> p1 = productRepo.findByProductCatagory(prodCategory);
        if(p1.isEmpty())
        {
            throw new ProductNotFoundException(prodCategory);
        }
        return p1;
    }

    @Override
    public Product findByProductName(String productName) throws ProductNotFoundException
    {
        Product product = productRepo.findByProductName(productName);
        if (product == null)
        {
            throw new ProductNotFoundException(productName);
        }
        return product;
    }

    @Override
    public List<Product> findByProductPrice(double productPrice)
    {
        return productRepo.findByProductPrice(productPrice);
    }

    @Override
    public List<Product> findByProductRating(int productRating)
    {
        return productRepo.findByProductRating(productRating);
    }

    @Override
    public List<Product> findByProductPriceGreaterThan(double productPrice)
    {
        return productRepo.findByProductPriceGreaterThan(productPrice);
    }

    @Override
    public List<Product> findByProductPriceLessThan(double productPrice)
    {
        return productRepo.findByProductPriceLessThan(productPrice);
    }


}
