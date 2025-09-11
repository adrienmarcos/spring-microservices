package com.mycompany.fraud.domain.repository;

import com.mycompany.fraud.infra.entity.FraudCheckHistoryEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FraudCheckHistoryRepository {
    Optional<FraudCheckHistoryEntity> findLastByCustomerId(Integer customerId);
    void save(FraudCheckHistoryEntity fraudCheckHistory);
}
