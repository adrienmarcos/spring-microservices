package com.mycompany.customer.api.controller;

import com.mycompany.customer.api.model.request.CustomerRegistrationRequest;
import com.mycompany.customer.api.model.response.CustomerResponse;
import com.mycompany.customer.domain.exception.ConflictException;
import com.mycompany.customer.domain.service.CustomerServiceImp;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerServiceImp customerService;

    @PostMapping
    ResponseEntity<Void> register(@RequestBody @Valid CustomerRegistrationRequest customerRegistrationRequest) throws ConflictException {
        customerService.register(customerRegistrationRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{socialSecurityNumber}")
    ResponseEntity<Void> delete(@PathVariable("socialSecurityNumber") String ssnumber) {
        customerService.delete(ssnumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{socialSecurityNumber}")
    ResponseEntity<CustomerResponse> find(@PathVariable("socialSecurityNumber") String ssnumber) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.find(ssnumber));
    }

    @GetMapping
    ResponseEntity<List<CustomerResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAll());
    }

}
