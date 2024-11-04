package com.mycompany.customer.api.controller;

import com.mycompany.customer.api.model.request.CustomerRegistrationRequest;
import com.mycompany.customer.domain.model.Customer;
import com.mycompany.customer.domain.service.CustomerServiceImp;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerServiceImp customerService) {

    @PostMapping
    ResponseEntity<Void> register(@RequestBody @Valid CustomerRegistrationRequest customerRegistrationRequest) {
        customerService.register(customerRegistrationRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping
//    ResponseEntity<List<Customer>> getAll() {
//        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAll());
//    }

}
