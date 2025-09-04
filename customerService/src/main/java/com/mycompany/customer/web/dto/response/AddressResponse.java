package com.mycompany.customer.web.dto.response;

public record AddressResponse(
    String address,
    String city,
    String zipCode,
    String coutry
) { }
