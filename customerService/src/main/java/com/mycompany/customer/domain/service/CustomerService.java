package com.mycompany.customer.domain.service;

import com.mycompany.customer.api.model.request.CustomerRegistrationRequestRequest;
import com.mycompany.customer.domain.model.Customer;
import com.mycompany.customer.domain.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record CustomerService(CustomerRepository customerRepository) {

    public void register(CustomerRegistrationRequestRequest customerRegistrationRequestRequest) {
        var customer = Customer.builder()
                .firstName(customerRegistrationRequestRequest.firstName())
                .lastName(customerRegistrationRequestRequest.lastName())
                .email(customerRegistrationRequestRequest.email())
                .build();

        // TODO check if email is valid
        // TODO check if email is not taken
        // TODO check if fistName and lastName are valid

        customerRepository.save(customer);
    }
}
