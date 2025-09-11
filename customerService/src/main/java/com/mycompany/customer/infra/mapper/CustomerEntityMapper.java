package com.mycompany.customer.infra.mapper;

import com.mycompany.customer.domain.model.Address;
import com.mycompany.customer.domain.model.Customer;
import com.mycompany.customer.infra.entity.AddressEntity;
import com.mycompany.customer.infra.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityMapper {

    public CustomerEntity toEntity(Customer domain) {
        AddressEntity address = null;
        if (domain.getAddress() != null) {
            address = AddressEntity.builder()
                    .address(domain.getAddress().getAddress())
                    .city(domain.getAddress().getCity())
                    .zipCode(domain.getAddress().getZipCode())
                    .country(domain.getAddress().getCountry())
                    .build();
        }

        var entity = CustomerEntity.builder()
                .socialSecurityNumber(domain.getSocialSecurityNumber())
                .firstName(domain.getFirstName())
                .lastName(domain.getLastName())
                .email(domain.getEmail())
                .gender(domain.getGender())
                .address(address)
                .build();

        return entity;
    }

    public Customer toDomain(CustomerEntity entity) {
        Address address = null;
        if (entity.getAddress() != null) {
            address = new Address(
                    entity.getAddress().getAddress(),
                    entity.getAddress().getCity(),
                    entity.getAddress().getZipCode(),
                    entity.getAddress().getCountry()
            );
        }

        return new Customer(
                entity.getSocialSecurityNumber(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getGender(),
                address
        );
    }

}
