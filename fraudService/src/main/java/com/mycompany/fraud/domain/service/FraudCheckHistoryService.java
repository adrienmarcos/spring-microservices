package com.mycompany.fraud.domain.service;

import com.mycompany.fraud.web.dto.response.FraudCheckResponse;

public interface FraudCheckHistoryService {
    FraudCheckResponse isFraudster(Integer customerId);
}
