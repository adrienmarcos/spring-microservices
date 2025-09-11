package com.mycompany.fraud.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FraudCheckHistoryResponse(

    @JsonProperty("isFraud")
    Boolean isFraud,

    @JsonProperty("message")
    String message

) { }
