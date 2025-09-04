package com.mycompany.customer.domain.service;

import com.mycompany.customer.domain.model.Address;
import com.mycompany.customer.domain.model.Customer;
import com.mycompany.customer.web.dto.request.CustomerRegistrationRequest;
import com.mycompany.customer.web.dto.response.AddressResponse;
import com.mycompany.customer.web.dto.response.CustomerResponse;
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
    public void register(CustomerRegistrationRequest request) throws ConflictException {
        if (isDuplicated(request.socialSecurityNumber()))
            throw new ConflictException("Customer is already registered");

        var addressDomain = new Address(
            request.address().address(),
            request.address().city(),
            request.address().zipCode(),
            request.address().coutry()
        );

        var customerDomain = new Customer(
            request.socialSecurityNumber(),
            request.firstName(),
            request.lastName(),
            request.email(),
            request.gender(),
            addressDomain
        );

        customerRepository.save(customerDomain);
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
    public CustomerResponse find(String socialSecurityNumber) {
        var customer = customerRepository.find(socialSecurityNumber)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        return new CustomerResponse(
            customer.getSocialSecurityNumber(),
            customer.getFirstName(),
            customer.getLastName(),
            customer.getEmail(),
            customer.getGender(),
            new AddressResponse(
                customer.getAddress().getAddress(),
                customer.getAddress().getCity(),
                customer.getAddress().getZipCode(),
                customer.getAddress().getCountry()
            )
        );
    }

    @Override
    public List<CustomerResponse> getAll() {
        return customerRepository.getAll()
                .stream()
                .map(customer -> new CustomerResponse(
                        customer.getSocialSecurityNumber(),
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getEmail(),
                        customer.getGender(),
                        new AddressResponse(
                            customer.getAddress().getAddress(),
                            customer.getAddress().getCity(),
                            customer.getAddress().getZipCode(),
                            customer.getAddress().getCountry()
                        )
                ))
                .toList();
    }

}
