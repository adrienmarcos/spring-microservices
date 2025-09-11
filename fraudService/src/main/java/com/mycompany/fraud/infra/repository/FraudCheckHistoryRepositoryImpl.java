package com.mycompany.fraud.infra.repository;

import com.mycompany.fraud.domain.model.FraudCheckHistory;
import com.mycompany.fraud.domain.repository.FraudCheckHistoryRepository;
import com.mycompany.fraud.infra.mapper.FraudCheckHistoryEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class FraudCheckHistoryRepositoryImpl implements FraudCheckHistoryRepository {

    private final JpaFraudCheckHistoryRepository jpaFraudCheckHistoryRepository;
    private final FraudCheckHistoryEntityMapper mapper;

    @Override
    public Optional<FraudCheckHistory> findLastByCustomerId(Integer customerId) {
        return jpaFraudCheckHistoryRepository.findLastByCustomerId(customerId).map(mapper::toDomain);
    }

    @Override
    public void save(FraudCheckHistory fraudCheckHistory) {
        jpaFraudCheckHistoryRepository.save(mapper.toEntity(fraudCheckHistory));
    }

}
