package com.mycompany.fraud.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FraudCheckHistoryResponse(

    @JsonProperty("fraud")
    Boolean fraud,

    @JsonProperty("message")
    String message

) { }
