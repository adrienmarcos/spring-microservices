package com.mycompany.customer.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycompany.customer.domain.model.Address;
import com.mycompany.customer.domain.model.Gender;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

    @JsonProperty("socialSecurityNumber")
    private String socialSecurityNumber;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("gender")
    private Gender gender;

    @JsonProperty("address")
    private Address address;

}
