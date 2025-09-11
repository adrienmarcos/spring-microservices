package com.mycompany.customer.domain.service;

import com.mycompany.customer.domain.model.Customer;
import com.mycompany.customer.domain.exception.ConflictException;

import java.util.List;

public interface CustomerService {
    void register(Customer customer) throws ConflictException;
    void delete(String socialSecurityNumber);
    Customer find(String socialSecurityNumber);
    List<Customer> getAll();
}
