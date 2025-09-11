package com.mycompany.customer.web.mapper;

import com.mycompany.customer.domain.model.Address;
import com.mycompany.customer.domain.model.Customer;
import com.mycompany.customer.web.dto.request.CustomerRegistrationRequest;
import com.mycompany.customer.web.dto.response.AddressResponse;
import com.mycompany.customer.web.dto.response.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerWebMapper {

    public Customer toDomain(CustomerRegistrationRequest dto) {
        Address address = new Address(
                dto.address().address(),
                dto.address().city(),
                dto.address().zipCode(),
                dto.address().coutry()
        );

        return new Customer(
                dto.socialSecurityNumber(),
                dto.firstName(),
                dto.lastName(),
                dto.email(),
                dto.gender(),
                address
        );
    }

    public CustomerResponse toDto(Customer customer) {
        var address = new AddressResponse(
                customer.getAddress().getAddress(),
                customer.getAddress().getCity(),
                customer.getAddress().getZipCode(),
                customer.getAddress().getCountry()
        );

        return new CustomerResponse(
                customer.getSocialSecurityNumber(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getGender(),
                address
        );
    }

}
