package com.mycompany.fraud.application.service;

import com.mycompany.fraud.domain.model.FraudCheckHistory;
import com.mycompany.fraud.domain.service.FraudCheckHistoryService;
import com.mycompany.fraud.infra.repository.FraudCheckHistoryRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FraudCheckHistoryServiceImp implements FraudCheckHistoryService {

    private final FraudCheckHistoryRepositoryImpl fraudCheckHistoryRepository;

    @Override
    public FraudCheckHistory isFraudster(Integer customerId) {
        Optional<FraudCheckHistory> existing = fraudCheckHistoryRepository.findLastByCustomerId(customerId);
        boolean isFraud = existing.map(FraudCheckHistory::getIsFraud).orElse(false);
        FraudCheckHistory newHistory = new FraudCheckHistory(customerId, isFraud, LocalDateTime.now());
        fraudCheckHistoryRepository.save(newHistory);
        return newHistory;
    }

}
