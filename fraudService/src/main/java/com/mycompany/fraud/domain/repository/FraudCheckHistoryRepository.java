package com.mycompany.fraud.domain.repository;

import com.mycompany.fraud.domain.model.FraudCheckHistory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FraudCheckHistoryRepository {
    Optional<FraudCheckHistory> findLastByCustomerId(Integer customerId);
    void save(FraudCheckHistory fraudCheckHistory);
}
