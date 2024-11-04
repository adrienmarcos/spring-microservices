package com.mycompany.customer.domain.service;

import com.mycompany.customer.api.model.request.CustomerRegistrationRequest;

public interface CustomerService {

    void register(CustomerRegistrationRequest customerRegistrationRequestRequest);
    void delete(Integer customerId);
}
