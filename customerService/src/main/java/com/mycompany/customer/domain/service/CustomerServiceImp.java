package com.mycompany.customer.domain.service;

import com.mycompany.customer.api.model.request.CustomerRegistrationRequest;
import com.mycompany.customer.domain.model.Customer;
import com.mycompany.customer.domain.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record CustomerServiceImp(CustomerRepository customerRepository) implements CustomerService {

    @Override
    public void register(CustomerRegistrationRequest customerRegistrationRequestRequest) {
        var customer = Customer.builder()
                .firstName(customerRegistrationRequestRequest.getFirstName())
                .lastName(customerRegistrationRequestRequest.getLastName())
                .email(customerRegistrationRequestRequest.getEmail())
                .address(customerRegistrationRequestRequest.getAddress())
                .build();
        customerRepository.save(customer);
    }

    @Override
    public void delete(Integer customerId) {
        var customer = customerRepository.findById(customerId).orElseThrow(() -> {
            return new EntityNotFoundException("Customer not found");
        });
        customerRepository.delete(customer);
    }

}
