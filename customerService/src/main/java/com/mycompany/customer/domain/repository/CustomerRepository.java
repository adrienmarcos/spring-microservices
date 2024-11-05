package com.mycompany.customer.domain.repository;

import com.mycompany.customer.api.model.response.CustomerResponse;
import com.mycompany.customer.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findBySocialSecurityNumber(String socialSecurityNumber);

    @Query( "SELECT new com.mycompany.customer.api.model.response.CustomerResponse(c.socialSecurityNumber, " +
                "c.firstName, c.lastName, c.email, c.gender, c.address) " +
            "FROM Customer c WHERE c.socialSecurityNumber = :socialSecurityNumber")
    CustomerResponse find(@Param("socialSecurityNumber") String socialSecurityNumber);

    @Query( "SELECT new com.mycompany.customer.api.model.response.CustomerResponse(c.socialSecurityNumber, " +
                "c.firstName, c.lastName, c.email, c.gender, c.address) " +
            "FROM Customer c")
    List<CustomerResponse> getAll();

}
