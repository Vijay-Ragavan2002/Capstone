package com.example.onlineshoppingsystem.customer.controller;

import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shop/customers")
public class CustomerController
{
    @Autowired
     private CustomerService customerService;

    @PostMapping("/add")
    public Customer save(@RequestBody Customer customer)
    {
        return customerService.save(customer);
    }

    @GetMapping("/findall")
    public List<Customer> findAll()
    {
        return customerService.findAll();
    }

    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer)
    {
        return customerService.update(customer);
    }

    @DeleteMapping("/deleteById/{customerId}")
    public void deleteById(@PathVariable ("customerId") int customerId)
    {
        customerService.delete(customerId);
    }

    @GetMapping("/findByCustomerId/{customerId}")
    public Optional<Customer> findById(@PathVariable ("customerId") int customerId)
    {
        return customerService.findByCustomerId(customerId);
    }

    @GetMapping("/findByCustomerName/{customerName}")
    public Customer findByCustomerName(@PathVariable ("customerName") String customerName)
    {
        return customerService.findByCustomerName(customerName);
    }

    @GetMapping("/findByCustomerCity/{customerCity}")
    public List<Customer> findByCustomerCity(@PathVariable ("customerCity") String customerCity)
    {
        return customerService.findByCustomerCity(customerCity);
    }

    @GetMapping("/findByCustomerPinCode/{customerPinCode}")
    public List<Customer> findByCustomerPinCode(@PathVariable ("customerPinCode") int customerPinCode)
    {
        return customerService.findByCustomerPinCode(customerPinCode);
    }

    @GetMapping("/findByCustomerPhone/{customerPhone}")
    public List<Customer> findByCustomerPhone(@PathVariable ("customerPhone") String customerPhone)
    {
        return customerService.findByCustomerPhone(customerPhone);
    }

    @GetMapping("/findByCustomerEmail/{customerEmail}")
    public List<Customer> findByCustomerEmail(@PathVariable ("customerEmail") String customerEmail)
    {
        return customerService.findByCustomerEmail(customerEmail);
    }

}
