package com.mycompany.customer.infra.repository;

import com.mycompany.customer.domain.model.Customer;
import com.mycompany.customer.domain.repository.CustomerRepository;
import com.mycompany.customer.infra.mapper.CustomerEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JpaCustomerEntityRepository jpaCustomerEntityRepository;
    private final CustomerEntityMapper mapper;

    @Override
    public void save(Customer customer) {
        jpaCustomerEntityRepository.save(mapper.toEntity(customer));
    }

    @Override
    public Optional<Customer> find(String socialSecurityNumber) {
        return jpaCustomerEntityRepository.findBySocialSecurityNumber(socialSecurityNumber).map(mapper::toDomain);
    }

    @Override
    public List<Customer> getAll() {
        return jpaCustomerEntityRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Customer customer) {
        jpaCustomerEntityRepository.delete(mapper.toEntity(customer));
    }

}
