package com.mycompany.customer.domain.service;

import com.mycompany.customer.api.model.request.CustomerRegistrationRequest;
import com.mycompany.customer.api.model.response.CustomerResponse;
import com.mycompany.customer.domain.exception.ConflictException;

import java.util.List;

public interface CustomerService {
    void register(CustomerRegistrationRequest customerRegistrationRequestRequest) throws ConflictException;
    void delete(String socialSecurityNumber);
    CustomerResponse find(String socialSecurityNumber);
    List<CustomerResponse> getAll();
}
