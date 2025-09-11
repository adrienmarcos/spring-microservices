package com.mycompany.customer.application.service;

import com.mycompany.customer.domain.model.Customer;
import com.mycompany.customer.domain.service.CustomerService;
import com.mycompany.customer.domain.exception.ConflictException;
import com.mycompany.customer.infra.repository.CustomerRepositoryImpl;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepositoryImpl customerRepository;

    @Override
    public void register(Customer customer) throws ConflictException {
        if (isDuplicated(customer.getSocialSecurityNumber()))
            throw new ConflictException("Customer is already registered");

        // todo: check if email is valid
        // todo: check if email is not taken
        // todo: check if customer is fraudster
        // todo: send notification

        customerRepository.save(customer);
    }

    private Boolean isDuplicated(String socialSecurityNumber) {
        return customerRepository.find(socialSecurityNumber) != null;
    }

    @Override
    public void delete(String socialSecurityNumber) {
        var customer = customerRepository.find(socialSecurityNumber)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        customerRepository.delete(customer);
    }

    @Override
    public Customer find(String socialSecurityNumber) {
        return customerRepository.find(socialSecurityNumber)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

}
