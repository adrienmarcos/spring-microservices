package com.mycompany.customer.domain.model;

import java.util.Objects;

public class Customer {

    private final String socialSecurityNumber;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Gender gender;
    private final Address address;

    public Customer(String socialSecurityNumber, String firstName, String lastName, String email, Gender gender, Address address) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(socialSecurityNumber, customer.socialSecurityNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(socialSecurityNumber);
    }
}
