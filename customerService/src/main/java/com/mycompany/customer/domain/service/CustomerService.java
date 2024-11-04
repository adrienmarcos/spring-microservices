package com.mycompany.customer.domain.service;

import com.mycompany.customer.api.model.request.CustomerRegistrationRequest;
import com.mycompany.customer.domain.exception.ConflictException;

public interface CustomerService {

    void register(CustomerRegistrationRequest customerRegistrationRequestRequest) throws ConflictException;
    void delete(Integer customerId);
}
