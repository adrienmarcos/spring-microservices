package com.mycompany.fraud.infra.mapper;

import com.mycompany.fraud.domain.model.FraudCheckHistory;
import com.mycompany.fraud.infra.entity.FraudCheckHistoryEntity;
import org.springframework.stereotype.Component;

@Component
public class FraudCheckHistoryEntityMapper {

    public FraudCheckHistoryEntity toEntity(FraudCheckHistory domain) {
        return FraudCheckHistoryEntity.builder()
                .id(null)
                .customerId(domain.getCustomerId())
                .createdAt(domain.getCreatedAt())
                .isFraud(domain.getIsFraud())
                .build();
    }

    public FraudCheckHistory toDomain(FraudCheckHistoryEntity entity) {
        return new FraudCheckHistory(entity.getCustomerId(), entity.getIsFraud(), entity.getCreatedAt());
    }

}
