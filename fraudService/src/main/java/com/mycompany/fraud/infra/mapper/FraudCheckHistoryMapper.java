package com.mycompany.fraud.infra.mapper;

import com.mycompany.fraud.domain.model.FraudCheckHistory;
import com.mycompany.fraud.infra.entity.FraudCheckHistoryEntity;

public class FraudCheckHistoryMapper {

    public static FraudCheckHistoryEntity toEntity(FraudCheckHistory domain) {
        return FraudCheckHistoryEntity.builder()
                .id(null)
                .customerId(domain.getCustomerId())
                .createdAt(domain.getCreatedAt())
                .isFraud(domain.getFraud())
                .build();
    }

    public static FraudCheckHistory toDomain(FraudCheckHistoryEntity entity) {
        return new FraudCheckHistory(entity.getCustomerId(), entity.getIsFraud(), entity.getCreatedAt());
    }

}
