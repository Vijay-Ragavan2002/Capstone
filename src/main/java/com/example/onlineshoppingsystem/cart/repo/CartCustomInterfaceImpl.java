package com.example.onlineshoppingsystem.cart.repo;

import com.example.onlineshoppingsystem.cart.dto.Cart;
import com.example.onlineshoppingsystem.cart.exception.CartNotFoundException;
import com.example.onlineshoppingsystem.cartLine.dto.CartLine;
import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.customer.exception.CustomerIdNotFoundException;
import com.example.onlineshoppingsystem.product.dto.Product;
import com.example.onlineshoppingsystem.product.exception.ProductNotFoundException;
import com.example.onlineshoppingsystem.product.exception.ProductOutOfStockException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartCustomInterfaceImpl implements CartCustomInterface
{
    @PersistenceContext
    @Autowired
    EntityManager em;

    @Transactional
    public String addToCart(int customerId, int productId, int quantity)
    {
        Customer customer = em.find(Customer.class, customerId);
        Product product = em.find(Product.class, productId);
        if (product.getProductStock() < quantity)
        {
            throw new ProductOutOfStockException("for product with Id" + productId);
        }
        if (customer == null)
        {
            throw new CustomerIdNotFoundException("No customer with id : "+customerId);
        }
        if (product == null)
        {
            throw new ProductNotFoundException("No product with id : "+productId);
        }
        Cart cart = customer.getCart();

        if (cart != null)
        {
            List<CartLine> cartItems = cart.getProductList();
            for (CartLine item : cartItems)
            {
                if (item.getProduct() == product)
                {
                    item.setQuantity(item.getQuantity() + quantity);
                    item.setTotalPrice((float) (item.getTotalPrice() + (quantity * product.getProductPrice())));
                    return "added";
                }
            }
            CartLine newCartLine = new CartLine();
            newCartLine.setProduct(product);
            newCartLine.setProductId(productId);
            newCartLine.setUnitPrice((float) product.getProductPrice());
            newCartLine.setQuantity(quantity);
            newCartLine.setTotalPrice((float) product.getProductPrice() * quantity);
            em.persist(newCartLine);
            cartItems.add(newCartLine);
            em.persist(cart);
            customer.setCart(cart);
            em.persist(customer);
        }
        else
        {
            Cart newCart = new Cart();
            newCart.setCustomer(customer);
            CartLine newCartLine = new CartLine();
            newCartLine.setProduct(product);
            newCartLine.setProductId(productId);
            newCartLine.setUnitPrice((float) product.getProductPrice());
            newCartLine.setQuantity(quantity);
            newCartLine.setTotalPrice((float) product.getProductPrice() * quantity);
            newCart.getProductList().add(newCartLine);
            em.persist(newCartLine);
            em.persist(newCart);
            customer.setCart(newCart);
            em.persist(customer);
        }
        return "added";
    }

    @Transactional
    public String removeFromCart(int customerId, int productId, int quantity)
    {
        Customer customer = em.find(Customer.class, customerId);
        Product product = em.find(Product.class, productId);
        if (customer == null)
        {
            throw new CustomerIdNotFoundException("No customer with id : "+ customerId);
        }
        if (product == null)
        {
            throw new ProductNotFoundException("No product with id : "+productId);
        }
        Cart cart = customer.getCart();
        if (cart == null)
        {
            throw new CartNotFoundException("No cart found for customer with id : "+customerId);
        }
        if (cart!=null)
        {
            List<CartLine> cartItems = cart.getProductList();
            for (CartLine item : cartItems)
            {
                if (item.getProduct() == product)
                {
                    if (item.getQuantity() > 1)
                    {
                        item.setQuantity(item.getQuantity() - quantity);
                        item.setTotalPrice((float) (item.getTotalPrice() - (quantity * product.getProductPrice())));
                        em.persist(item);
                        em.persist(customer);
                        return "removed";
                    }
                    else
                    {
                        cartItems.remove(item);
                        em.persist(customer);
                        return "removed";
                    }
                }
            }
        }
        return null;
    }

    @Transactional
    @Override
    public void removeCart(int customerId)
    {
        Customer customer = em.find(Customer.class, customerId);
        if (customer == null)
        {
            throw new CustomerIdNotFoundException("No customer with id : "+ customerId);
        }
        Cart cart = customer.getCart();
        if (cart == null)
        {
            throw new CartNotFoundException("No cart found for customer with id : "+customerId);
        }
        List<CartLine> cartItems = new ArrayList<>();
        cart.setProductList(cartItems);
        em.persist(customer);
    }
}
