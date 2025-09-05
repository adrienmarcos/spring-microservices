package com.mycompany.fraud.infra.repository;

import com.mycompany.fraud.domain.model.FraudCheckHistory;
import com.mycompany.fraud.domain.repository.FraudCheckHistoryRepository;
import com.mycompany.fraud.infra.entity.FraudCheckHistoryEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

interface JpaFraudCheckHistoryRepository extends JpaRepository<FraudCheckHistoryEntity, Integer> {
    Optional<FraudCheckHistoryEntity> findByCustomerId(Integer customerId);
}

@Repository
@AllArgsConstructor
public class FraudCheckHistoryRepositoryImpl implements FraudCheckHistoryRepository {

    private final JpaFraudCheckHistoryRepository jpaFraudCheckHistoryRepository;

    @Override
    public Optional<FraudCheckHistory> find(Integer customerId) {
        return jpaFraudCheckHistoryRepository.findByCustomerId(customerId)
                .map(entity -> new FraudCheckHistory(
                        entity.getCustomerId(),
                        entity.getIsFraud(),
                        entity.getCreatedAt()
                ));
    }

}
