package com.mycompany.customer.domain.repository;

import com.mycompany.customer.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findBySocialSecurityNumber(String socialSecurityNumber);

}
