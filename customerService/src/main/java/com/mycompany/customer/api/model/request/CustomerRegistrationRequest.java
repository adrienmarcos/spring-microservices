package com.mycompany.customer.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycompany.customer.domain.model.Address;
import com.mycompany.customer.domain.model.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CustomerRegistrationRequest {

    @JsonProperty("socialSecurityNumber")
    @NotBlank(message = "Social security number cannot be empty")
    private String socialSecurityNumber;

    @JsonProperty("firstName")
    @NotBlank(message = "Field first name cannot be empty")
    private String firstName;

    @JsonProperty("lastName")
    @NotBlank(message = "Field last name cannot be empty")
    private String lastName;

    @JsonProperty("email")
    @Email(message = "Field email is not valid")
    @NotBlank(message = "Field email cannot be empty")
    private String email;

    @JsonProperty("gender")
    @NotNull(message = "Field gender cannot be empty")
    private Gender gender;

    @JsonProperty("address")
    private Address address;

}
