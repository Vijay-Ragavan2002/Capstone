package com.example.onlineshoppingsystem.product.controller;

import com.example.onlineshoppingsystem.product.dto.Product;
import com.example.onlineshoppingsystem.product.exception.ProductNotFoundException;
import com.example.onlineshoppingsystem.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shop/products")
public class ProductController
{
    @Autowired
    ProductService productService;

    @PostMapping()
    public Product save(@RequestBody Product p)
    {
        return productService.save(p);
    }

    @GetMapping("/findall")
    public List<Product> getAll()
    {
        return productService.findAll();
    }

    @DeleteMapping("/{productId}")
    public void deleteById(@PathVariable ("productId") int id)
    {
        productService.delete(id);
    }

    @PutMapping("/update")
    public Product update(@RequestBody Product p)
    {
        return productService.update(p);
    }

    @GetMapping("/getByProductId/{productId}")
    public Optional<Product> findById(@PathVariable ("productId") int productId)
    {
        try {
            return productService.findByProductId(productId);
        }catch (ProductNotFoundException e){
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/getByCatagory/{productCatagory}")
    public List<Product> findByCatagory(@PathVariable ("productCatagory") String productCatagory)
    {
        try {
            return productService.findByCatagory(productCatagory);
        }catch (ProductNotFoundException e)
        {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/getByProductName/{productName}")
    public Product findByProductName(@PathVariable ("productName") String productName)
    {
        try {
            return productService.findByProductName(productName);
        }catch (ProductNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getByProductPrice/{productPrice}")
    public List<Product> findByProductPrice(@PathVariable ("productPrice") double productPrice)
    {
        return productService.findByProductPrice(productPrice);
    }

    @GetMapping("/getByProductRating/{productRating}")
    public List<Product> findByProductRating(@PathVariable ("productRating") int productRating)
    {
        return productService.findByProductRating(productRating);
    }

    @GetMapping("/getByProductPriceGreaterThan/{productPrice}")
    public List<Product> findByProductPriceGreaterThan(@PathVariable ("productPrice") double productPrice)
    {
        return productService.findByProductPriceGreaterThan(productPrice);
    }

    @GetMapping("/getByProductPriceLessThan/{productPrice}")
    public List<Product> findByProductPriceLessThan(@PathVariable ("productPrice") double productPrice)
    {
        return productService.findByProductPriceLessThan(productPrice);
    }

}
