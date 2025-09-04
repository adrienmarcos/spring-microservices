package com.mycompany.customer.infra.repository;

import com.mycompany.customer.domain.model.Address;
import com.mycompany.customer.domain.model.Customer;
import com.mycompany.customer.domain.repository.CustomerRepository;
import com.mycompany.customer.infra.entity.AddressEntity;
import com.mycompany.customer.infra.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

interface JpaCustomerEntityRepository extends JpaRepository<CustomerEntity, Integer> {
    Optional<CustomerEntity> findBySocialSecurityNumber(String socialSecurityNumber);
}

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JpaCustomerEntityRepository jpaCustomerEntityRepository;

    public CustomerRepositoryImpl(JpaCustomerEntityRepository jpaCustomerEntityRepository) {
        this.jpaCustomerEntityRepository = jpaCustomerEntityRepository;
    }

    @Override
    public void save(Customer customer) {
        var entity = new CustomerEntity().builder()
                .socialSecurityNumber(customer.getSocialSecurityNumber())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .gender(customer.getGender())
                .addressEntity(new AddressEntity().builder()
                        .address(customer.getAddress().getAddress())
                        .city(customer.getAddress().getCity())
                        .zipCode(customer.getAddress().getZipCode())
                        .country(customer.getAddress().getCountry())
                        .build()
                )
                .build();
        jpaCustomerEntityRepository.save(entity);
    }

    @Override
    public Optional<Customer> find(String socialSecurityNumber) {
        return jpaCustomerEntityRepository.findBySocialSecurityNumber(socialSecurityNumber)
                .map(entity -> new Customer(
                        entity.getSocialSecurityNumber(),
                        entity.getFirstName(),
                        entity.getLastName(),
                        entity.getEmail(),
                        entity.getGender(),
                        new Address(
                                entity.getAddressEntity().getAddress(),
                                entity.getAddressEntity().getCity(),
                                entity.getAddressEntity().getZipCode(),
                                entity.getAddressEntity().getCountry()
                        )
                ));
    }

    @Override
    public List<Customer> getAll() {
        return jpaCustomerEntityRepository.findAll()
                .stream()
                .map(entity -> new Customer(
                        entity.getSocialSecurityNumber(),
                        entity.getFirstName(),
                        entity.getLastName(),
                        entity.getEmail(),
                        entity.getGender(),
                        new Address(
                                entity.getAddressEntity().getCountry(),
                                entity.getAddressEntity().getCity(),
                                entity.getAddressEntity().getZipCode(),
                                entity.getAddressEntity().getCountry()
                        )
                ))
                .toList();
    }

    @Override
    public void delete(Customer customer) {
        jpaCustomerEntityRepository.findBySocialSecurityNumber(customer.getSocialSecurityNumber()).ifPresent(jpaCustomerEntityRepository::delete);
    }

}
