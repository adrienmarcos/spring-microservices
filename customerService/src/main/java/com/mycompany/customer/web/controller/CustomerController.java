package com.mycompany.customer.web.controller;

import com.mycompany.customer.web.dto.request.CustomerRegistrationRequest;
import com.mycompany.customer.web.dto.response.CustomerResponse;
import com.mycompany.customer.domain.exception.ConflictException;
import com.mycompany.customer.application.service.CustomerServiceImp;
import com.mycompany.customer.web.mapper.CustomerWebMapper;
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
    private final CustomerWebMapper mapper;

    @PostMapping
    ResponseEntity<Void> register(@RequestBody @Valid CustomerRegistrationRequest request) throws ConflictException {
        var customer = mapper.toDomain(request);
        customerService.register(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{socialSecurityNumber}")
    ResponseEntity<Void> delete(@PathVariable("socialSecurityNumber") String ssnumber) {
        customerService.delete(ssnumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{socialSecurityNumber}")
    ResponseEntity<CustomerResponse> find(@PathVariable("socialSecurityNumber") String ssnumber) {
        var customer = customerService.find(ssnumber);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDto(customer));
    }

    @GetMapping
    ResponseEntity<List<CustomerResponse>> getAll() {
        var customers = customerService.getAll();
        List<CustomerResponse> response = customers.stream().map(mapper::toDto).toList();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
