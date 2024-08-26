package com.example.onlineshoppingsystem.cart.controller;

import com.example.onlineshoppingsystem.cart.dto.Cart;
import com.example.onlineshoppingsystem.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shop/Cart")
public class CartController
{
    @Autowired
    private CartService cartService;

    @PostMapping("/addToCart")
    public void addToCart(@RequestParam int customerId,@RequestParam int productId,@RequestParam int quantity)
    {
        cartService.addToCart(customerId,productId,quantity);
    }

    @PostMapping("/removeItem")
    public void removeFromCart(@RequestParam int customerId, @RequestParam int productId, @RequestParam int quantity)
    {
        cartService.removeFromCart(customerId,productId,quantity);
    }

    @GetMapping("/findCart/{cartId}")
    public Cart findByCartId(@PathVariable int cartId)
    {
        return cartService.findByCartId(cartId);
    }

    @DeleteMapping("/removeCart")
    public void removeCart(@RequestParam int customerId)
    {
        cartService.removeCart(customerId);
    }

    @GetMapping("/customerCart")
    public Cart findByCustomerId(@RequestParam int customerId)
    {
        return cartService.findByCustomerId(customerId);
    }
}
