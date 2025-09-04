package com.mycompany.customer.web.dto.request;

public record AddressRequest(
    String address,
    String city,
    String zipCode,
    String coutry
) { }
