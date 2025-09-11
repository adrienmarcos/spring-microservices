package com.mycompany.fraud.application.service;

import com.mycompany.fraud.domain.service.FraudCheckHistoryService;
import com.mycompany.fraud.infra.entity.FraudCheckHistoryEntity;
import com.mycompany.fraud.infra.repository.FraudCheckHistoryRepositoryImpl;
import com.mycompany.fraud.web.dto.response.FraudCheckHistoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FraudCheckHistoryServiceImp implements FraudCheckHistoryService {

    private final FraudCheckHistoryRepositoryImpl fraudCheckHistoryRepository;

    @Override
    public FraudCheckHistoryResponse isFraudster(Integer customerId) {
        Optional<FraudCheckHistoryEntity> existing = fraudCheckHistoryRepository.findLastByCustomerId(customerId);

        FraudCheckHistoryResponse response = existing
                .map(history -> new FraudCheckHistoryResponse(
                        history.getIsFraud(),
                        "User was flagged as a fraud"
                ))
                .orElseGet(() -> new FraudCheckHistoryResponse(
                        false,
                        "User has never been flagged as fraud"
                ));

        FraudCheckHistoryEntity newHistory = FraudCheckHistoryEntity.builder()
                .customerId(customerId)
                .isFraud(response.isFraud())
                .createdAt(LocalDateTime.now())
                .build();
        fraudCheckHistoryRepository.save(newHistory);

        return response;
    }

}
