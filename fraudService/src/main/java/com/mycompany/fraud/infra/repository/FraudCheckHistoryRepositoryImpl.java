package com.mycompany.fraud.infra.repository;

import com.mycompany.fraud.domain.repository.FraudCheckHistoryRepository;
import com.mycompany.fraud.infra.entity.FraudCheckHistoryEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class FraudCheckHistoryRepositoryImpl implements FraudCheckHistoryRepository {

    private final JpaFraudCheckHistoryRepository jpaFraudCheckHistoryRepository;

    @Override
    public Optional<FraudCheckHistoryEntity> findLastByCustomerId(Integer customerId) {
        return jpaFraudCheckHistoryRepository.findLastByCustomerId(customerId);
    }

    @Override
    public void save(FraudCheckHistoryEntity fraudCheckHistory) {
        jpaFraudCheckHistoryRepository.save(fraudCheckHistory);
    }

}
