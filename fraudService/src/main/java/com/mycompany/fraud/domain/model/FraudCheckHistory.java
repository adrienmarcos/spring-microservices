package com.mycompany.fraud.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class FraudCheckHistory {

    private final Integer customerId;
    private final Boolean isFraud;
    private final LocalDateTime createdAt;

    public FraudCheckHistory(Integer customerId, Boolean isFraud, LocalDateTime createdAt) {
        this.customerId = customerId;
        this.isFraud = isFraud;
        this.createdAt = createdAt;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Boolean getFraud() {
        return isFraud;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FraudCheckHistory that)) return false;
        return Objects.equals(customerId, that.customerId) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, createdAt);
    }

}
