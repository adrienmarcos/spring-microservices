package com.mycompany.fraud.domain.service;

import com.mycompany.fraud.infra.repository.FraudCheckHistoryRepositoryImpl;
import com.mycompany.fraud.web.dto.response.FraudCheckHistoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FraudCheckHistoryServiceImp implements FraudCheckHistoryService {

    private final FraudCheckHistoryRepositoryImpl fraudCheckHistoryRepository;

    @Override
    public FraudCheckHistoryResponse isFraudster(Integer customerId) {
        return fraudCheckHistoryRepository.find(customerId)
                .map(fraudCheckHistory -> new FraudCheckHistoryResponse(
                        fraudCheckHistory.getFraud(),
                        "User was flagged as a fraud"
                ))
                .orElseGet(() -> new FraudCheckHistoryResponse(
                        false,
                        "User has never been flagged as fraud"
                ));
    }

}
