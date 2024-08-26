package com.example.onlineshoppingsystem.order.repo;

import com.example.onlineshoppingsystem.cart.dto.Cart;
import com.example.onlineshoppingsystem.cart.exception.CartNotFoundException;
import com.example.onlineshoppingsystem.cartLine.dto.CartLine;
import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.customer.exception.CustomerIdNotFoundException;
import com.example.onlineshoppingsystem.customer.service.CustomerService;
import com.example.onlineshoppingsystem.order.dto.Order;
import com.example.onlineshoppingsystem.order.dto.OrderItem;
import com.example.onlineshoppingsystem.order.exception.OrderNotFoundException;
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
public class OrderCustomRepoImpl implements OrderCustomRepo
{
    @PersistenceContext
    @Autowired
    private EntityManager em;

    @Autowired
    CustomerService service;

    @Transactional
    @Override
    public void orderProduct(int customerId, int productId, int quantity)
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
        Order newOrder = new Order();
        newOrder.setCustomerId(customerId);
        List<OrderItem> orderItems = new ArrayList<>();
        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setOrderProdId(productId);
        item.setOrderProductPrice(product.getProductPrice());
        item.setOrderQuantity(quantity);
        item.setOrderStatus(true);
        item.setOrderProductPrice(product.getProductPrice());
        item.setOrderProductTotal(product.getProductPrice() * quantity);
        em.persist(item);
        orderItems.add(item);
        newOrder.setOrderItems(orderItems);
        newOrder.setTotalPrice(item.getOrderProductTotal());
        em.persist(newOrder);
        customer.setOrder(newOrder);
        em.persist(customer);
    }

    @Transactional
    @Override
    public void orderFromCart(int customerId)
    {
        Customer customer = em.find(Customer.class, customerId);
        if (customer == null)
        {
            throw new CustomerIdNotFoundException("No customer with id : "+customerId);
        }
        Cart cart = customer.getCart();
        if (cart == null)
        {
            throw new CartNotFoundException("No cart found for customer with id : "+customerId);
        }
        Order order = new Order();
        order.setCustomerId(customerId);
        List<OrderItem> orderItemList = new ArrayList<>();
        if (cart != null)
        {
            List<CartLine> cartLines = cart.getProductList();
            for (CartLine prod : cartLines)
            {
                OrderItem item = new OrderItem();
                item.setProduct(prod.getProduct());
                item.setOrderProdId(prod.getProductId());
                item.setOrderQuantity(prod.getQuantity());
                item.setOrderProductPrice(prod.getUnitPrice());
                item.setOrderProductTotal(prod.getTotalPrice());
                item.setOrderStatus(true);
                order.setTotalPrice(order.getTotalPrice() + item.getOrderProductTotal());
                em.persist(item);
                orderItemList.add(item);
            }
            order.setOrderItems(orderItemList);
            em.persist(order);
            customer.setOrder(order);
            em.persist(customer);

            cart.getProductList().clear();
            em.persist(cart);
        }
    }

    @Transactional
    @Override
    public void updateOrder(int customerId, int productId,int quantity)
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
        Order order = customer.getOrder();
        if(order == null)
        {
            throw new OrderNotFoundException("No order with Customer Id : "+customerId);
        }
        if(order != null)
        {
            for (OrderItem orderItem : order.getOrderItems())
            {
                if (orderItem.getOrderProdId() == productId)
                {
                    orderItem.setOrderQuantity(orderItem.getOrderQuantity() + quantity);
                    orderItem.setOrderProductTotal(orderItem.getOrderProductTotal() + (quantity * orderItem.getOrderProductPrice()));
                }
                order.setTotalPrice(order.getTotalPrice() + (orderItem.getOrderProductPrice() * quantity));
            }
            em.persist(order);
            em.persist(customer);
        }
    }

    @Transactional
    @Override
    public String deleteProduct(int customerId, int productId)
    {
        Customer customer = em.find(Customer.class, customerId);
        Product product = em.find(Product.class, productId);
        if (customer == null)
        {
            throw new CustomerIdNotFoundException("No customer with id : "+customerId);
        }
        Order order = customer.getOrder();
        if(order == null)
        {
            throw new OrderNotFoundException("No order with Customer Id : "+customerId);
        }
        if(order != null)
        {
            for (OrderItem orderItem : order.getOrderItems())
            {
                if (orderItem.getOrderProdId() == productId)
                {
                    order.getOrderItems().remove(orderItem);
                    em.remove(orderItem);
                    order.setTotalPrice(order.getTotalPrice() - orderItem.getOrderProductPrice() * orderItem.getOrderQuantity());
                    em.persist(customer);
                    return "removed";
                }
            }
        }
        return "product not found";
    }

    @Transactional
    @Override
    public void cancelOrder(int customerId)
    {
        Customer customer = em.find(Customer.class, customerId);
        if (customer == null)
        {
            throw new CustomerIdNotFoundException("No customer with id : "+customerId);
        }
        Order order = customer.getOrder();
        if(order == null)
        {
            throw new OrderNotFoundException("No order with Customer Id : "+customerId);
        }
        if (order != null)
        {
            customer.setOrder(null);
        }
        em.persist(customer);
    }

    @Override
    public String reduceQuantity(int customerId, int productId, int quantity)
    {
        Customer customer = em.find(Customer.class, customerId);
        Product product = em.find(Product.class, productId);
        if (customer == null)
        {
            throw new CustomerIdNotFoundException("No customer with id : "+customerId);
        }
        Order order = customer.getOrder();
        if(order == null)
        {
            throw new OrderNotFoundException("No order with Customer Id : "+customerId);
        }
        else
        {
            for (OrderItem orderItem : order.getOrderItems())
            {
                if (orderItem.getOrderProdId() == productId)
                {
                    if (orderItem.getOrderQuantity() > 1)
                    {
                        orderItem.setOrderQuantity(orderItem.getOrderQuantity() - quantity);
                        orderItem.setOrderProductTotal(orderItem.getOrderProductTotal() - (orderItem.getOrderProductPrice() * quantity));
                        em.persist(orderItem);
                        order.setTotalPrice(order.getTotalPrice() - (orderItem.getOrderProductPrice() * quantity));
                        em.persist(customer);
                        return "removed";
                    }
                    else
                    {
                        order.getOrderItems().remove(orderItem);
                        em.remove(orderItem);
                        order.setTotalPrice(order.getTotalPrice() - (orderItem.getOrderProductPrice()*orderItem.getOrderQuantity()));
                        em.persist(customer);
                        return "removed";
                    }
                }
            }
        }
        return null;
    }
}