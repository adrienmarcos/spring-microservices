package com.mycompany.fraud.infra.repository;

import com.mycompany.fraud.infra.entity.FraudCheckHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaFraudCheckHistoryRepository extends JpaRepository<FraudCheckHistoryEntity, Integer> {
    Optional<FraudCheckHistoryEntity> findByCustomerId(Integer customerId);
    Optional<FraudCheckHistoryEntity> findLastByCustomerId(Integer customerId);
}
