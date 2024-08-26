package com.example.onlineshoppingsystem.customer.service;

import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.customer.exception.*;

import java.util.List;
import java.util.Optional;

public interface CustomerService
{
    public Customer save(Customer customer);

    public List<Customer> findAll();

    public Customer update(Customer customer);

    public void delete(int customerId);

    public Optional<Customer> findByCustomerId(int customerId) throws CustomerIdNotFoundException;

    public Customer findByCustomerName(String customerName) throws CustomerNameNotFoundException;

    public List<Customer> findByCustomerCity(String customerCity) throws CustomerCityNotFoundException;

    public List<Customer> findByCustomerPinCode(int customerPinCode);

    public List<Customer> findByCustomerPhone(String customerPhone) throws CustomerPhoneNotFoundException;

    public List<Customer> findByCustomerEmail(String customerEmail) throws CustomerEmailNotFoundException;

}
