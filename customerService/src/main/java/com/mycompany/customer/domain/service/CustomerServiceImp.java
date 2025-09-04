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
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void register(CustomerRegistrationRequest customerRegistrationRequest) throws ConflictException {
        if (isDuplicated(customerRegistrationRequest.socialSecurityNumber()))
            throw new ConflictException("Customer is already registered");

        var customer = Customer.builder()
                .socialSecurityNumber(customerRegistrationRequest.socialSecurityNumber())
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .address(customerRegistrationRequest.address())
                .build();
        customerRepository.save(customer);
    }

    private Boolean isDuplicated(String socialSecurityNumber) {
        return customerRepository.findBySocialSecurityNumber(socialSecurityNumber) != null;
    }

    @Override
    public void delete(String socialSecurityNumber) {
        var customer = customerRepository.findBySocialSecurityNumber(socialSecurityNumber);
        if (customer == null) throw new EntityNotFoundException("Customer was not found");
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
