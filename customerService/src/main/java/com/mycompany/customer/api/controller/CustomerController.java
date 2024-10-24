package com.mycompany.customer.api.controller;

import com.mycompany.customer.api.model.request.CustomerRegistrationRequestRequest;
import com.mycompany.customer.domain.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    void registerCustomer(@RequestBody CustomerRegistrationRequestRequest customerRegistrationRequestRequest) {
        log.info("new customer registration {}", customerRegistrationRequestRequest);
        customerService.register(customerRegistrationRequestRequest);
    }

}
