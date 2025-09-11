package com.mycompany.customer.web.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record AddressRequest(

    @JsonProperty("address")
    @NotBlank(message = "Address cannot be empty")
    String address,

    @JsonProperty("city")
    @NotBlank(message = "City cannot be empty")
    String city,

    @JsonProperty("zipCode")
    @NotBlank(message = "Zip Code cannot be empty")
    String zipCode,

    @JsonProperty("country")
    @NotBlank(message = "Country cannot be empty")
    String country

) { }
