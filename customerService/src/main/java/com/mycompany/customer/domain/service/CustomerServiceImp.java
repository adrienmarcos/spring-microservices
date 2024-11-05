package com.mycompany.customer.domain.service;

import com.mycompany.customer.api.model.request.CustomerRegistrationRequest;
import com.mycompany.customer.api.model.response.CustomerResponse;
import com.mycompany.customer.domain.exception.ConflictException;
import com.mycompany.customer.domain.model.Customer;
import com.mycompany.customer.domain.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public record CustomerServiceImp(CustomerRepository customerRepository) implements CustomerService {

    @Override
    public void register(CustomerRegistrationRequest customerRegistrationRequest) throws ConflictException {
        if (isDuplicated(customerRegistrationRequest.getSocialSecurityNumber()))
            throw new ConflictException("Customer is already registered");

        var customer = Customer.builder()
                .socialSecurityNumber(customerRegistrationRequest.getSocialSecurityNumber())
                .firstName(customerRegistrationRequest.getFirstName())
                .lastName(customerRegistrationRequest.getLastName())
                .email(customerRegistrationRequest.getEmail())
                .address(customerRegistrationRequest.getAddress())
                .build();
        customerRepository.save(customer);
    }

    private Boolean isDuplicated(String socialSecurityNumber) {
        return customerRepository.findBySocialSecurityNumber(socialSecurityNumber) != null;
    }

    @Override
    public void delete(Integer customerId) {
        var customer = customerRepository.findById(customerId).orElseThrow(() -> {
            return new EntityNotFoundException("Customer was not found");
        });
        customerRepository.delete(customer);
    }

    @Override
    public CustomerResponse find(String socialSecurityNumber) {
        var customer = customerRepository.find(socialSecurityNumber);
        if (customer == null) throw new EntityNotFoundException("Customer was not found");
        return customer;
    }

    @Override
    public List<CustomerResponse> getAll() {
        return customerRepository.getAll();
    }

}
