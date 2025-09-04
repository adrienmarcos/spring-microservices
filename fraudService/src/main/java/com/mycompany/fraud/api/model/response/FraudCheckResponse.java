package com.mycompany.fraud.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FraudCheckResponse(

    @JsonProperty("fraud")
    Boolean fraud,

    @JsonProperty("message")
    String message

) { }
