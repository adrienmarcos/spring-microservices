package com.mycompany.customer.domain.model;

import java.util.Objects;

public class Address {

    private final String address;
    private final String city;
    private final String zipCode;
    private final String country;

    public Address(String address, String city, String zipCode, String country) {
        if (zipCode == null || zipCode.isBlank()) {
            throw new IllegalArgumentException("Zip code cannot be empty");
        }
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Address address1)) return false;
        return Objects.equals(address, address1.address) && Objects.equals(city, address1.city) && Objects.equals(zipCode, address1.zipCode) && Objects.equals(country, address1.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, city, zipCode, country);
    }

}
