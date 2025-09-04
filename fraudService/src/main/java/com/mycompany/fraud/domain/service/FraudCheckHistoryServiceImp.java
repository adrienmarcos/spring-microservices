package com.mycompany.fraud.domain.service;

import com.mycompany.fraud.web.dto.response.FraudCheckResponse;
import com.mycompany.fraud.domain.repository.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FraudCheckHistoryServiceImp implements FraudCheckHistoryService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    @Override
    public FraudCheckResponse isFraudster(Integer customerId) {
        return new FraudCheckResponse(true, "User flagged as fraud");
    }

}
