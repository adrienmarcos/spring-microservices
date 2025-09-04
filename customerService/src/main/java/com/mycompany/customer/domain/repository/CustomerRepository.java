package com.mycompany.customer.domain.repository;

import com.mycompany.customer.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    void save(Customer customer);
    Optional<Customer> find(String socialSecurityNumber);
    List<Customer> getAll();
    void delete(Customer customer);
}
