package com.mycompany.customer.api.controller;

import com.mycompany.customer.api.model.request.CustomerRegistrationRequestRequest;
import com.mycompany.customer.domain.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    void registerCustomer(@RequestBody CustomerRegistrationRequestRequest customerRegistrationRequestRequest) {
        customerService.register(customerRegistrationRequestRequest);
    }

}
