package com.mycompany.customer.infra.repository;

import com.mycompany.customer.infra.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface JpaCustomerEntityRepository extends JpaRepository<CustomerEntity, Integer> {
    Optional<CustomerEntity> findBySocialSecurityNumber(String socialSecurityNumber);
}
