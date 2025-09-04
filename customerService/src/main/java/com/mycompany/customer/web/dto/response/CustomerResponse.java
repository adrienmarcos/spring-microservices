package com.mycompany.customer.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycompany.customer.domain.model.Gender;

public record CustomerResponse(

    @JsonProperty("socialSecurityNumber")
    String socialSecurityNumber,

    @JsonProperty("firstName")
    String firstName,

    @JsonProperty("lastName")
    String lastName,

    @JsonProperty("email")
    String email,

    @JsonProperty("gender")
    Gender gender,

    @JsonProperty("address")
    AddressResponse address

) { }
