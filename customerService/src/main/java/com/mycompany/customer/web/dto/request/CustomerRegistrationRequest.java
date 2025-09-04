package com.mycompany.customer.web.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycompany.customer.domain.model.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerRegistrationRequest(

    @JsonProperty("socialSecurityNumber")
    @NotBlank(message = "Social security number cannot be empty")
    String socialSecurityNumber,

    @JsonProperty("firstName")
    @NotBlank(message = "Field first name cannot be empty")
    String firstName,

    @JsonProperty("lastName")
    @NotBlank(message = "Field last name cannot be empty")
    String lastName,

    @JsonProperty("email")
    @Email(message = "Field email is not valid")
    @NotBlank(message = "Field email cannot be empty")
    String email,

    @JsonProperty("gender")
    @NotNull(message = "Field gender cannot be empty")
    Gender gender,

    @JsonProperty("address")
    AddressRequest address

) { }
