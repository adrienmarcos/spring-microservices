package com.mycompany.fraud.domain.service;

import com.mycompany.fraud.api.model.response.FraudCheckResponse;

public interface FraudCheckHistoryService {
    FraudCheckResponse isFraudster(Integer customerId);
}
