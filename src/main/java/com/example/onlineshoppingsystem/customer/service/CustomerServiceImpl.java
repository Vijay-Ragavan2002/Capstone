package com.example.onlineshoppingsystem.customer.service;

import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.customer.exception.*;
import com.example.onlineshoppingsystem.customer.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public Customer save(Customer customer)
    {
        return customerRepo.save(customer);
    }

    @Override
    public List<Customer> findAll()
    {
        return customerRepo.findAll();
    }

    @Override
    public Customer update(Customer customer)
    {
        return customerRepo.save(customer);
    }

    @Override
    public void delete(int customerId)
    {
        customerRepo.deleteById(customerId);
    }

    @Override
    public Optional<Customer> findByCustomerId(int customerId)
    {
        Optional<Customer> customer = customerRepo.findById(customerId);
        if (customer.isEmpty())
        {
            throw new CustomerIdNotFoundException("Id : " + customerId);
        }
        return customer;
    }

    @Override
    public Customer findByCustomerName(String customerName)
    {
        Customer c1 = customerRepo.findByCustomerName(customerName);
        if (c1 == null)
        {
            throw new CustomerNameNotFoundException(customerName);
        }
        return c1;
    }

    @Override
    public List<Customer> findByCustomerCity(String customerCity)
    {
        List<Customer> c1 = customerRepo.findByCustomerCity(customerCity);
        if (c1.isEmpty())
        {
            throw new CustomerCityNotFoundException(customerCity);
        }
        return c1;
    }

    @Override
    public List<Customer> findByCustomerPinCode(int customerPinCode)
    {
        return customerRepo.findByCustomerPinCode(customerPinCode);
    }

    @Override
    public List<Customer> findByCustomerPhone(String customerPhone)
    {
        List<Customer> c1 = customerRepo.findByCustomerPhone(customerPhone);
        if (c1.isEmpty())
        {
            throw new CustomerPhoneNotFoundException(customerPhone);
        }
        return c1;
    }

    @Override
    public List<Customer> findByCustomerEmail(String customerEmail)
    {
        List<Customer> c1 = customerRepo.findByCustomerEmail(customerEmail);
        if (c1.isEmpty())
        {
            throw new CustomerEmailNotFoundException(customerEmail);
        }
        return c1;
    }
}
