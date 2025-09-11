package com.mycompany.customer.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AddressResponse(

    @JsonProperty("address")
    String address,

    @JsonProperty("city")
    String city,

    @JsonProperty("zipCode")
    String zipCode,

    @JsonProperty("country")
    String country

) { }
