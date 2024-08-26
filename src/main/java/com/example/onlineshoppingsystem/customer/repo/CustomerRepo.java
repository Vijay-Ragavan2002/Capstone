package com.example.onlineshoppingsystem.customer.repo;

import com.example.onlineshoppingsystem.customer.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>
{
    Customer findByCustomerName(String customerName);

    public List<Customer> findByCustomerCity(String customerCity);

    List<Customer> findByCustomerPinCode(int customerPinCode);

    public List<Customer> findByCustomerPhone(String customerPhone);

    List<Customer> findByCustomerEmail(String customerEmail);
}
