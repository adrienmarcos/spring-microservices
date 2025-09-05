package com.mycompany.fraud.domain.service;

import com.mycompany.fraud.web.dto.response.FraudCheckHistoryResponse;

public interface FraudCheckHistoryService {
    FraudCheckHistoryResponse isFraudster(Integer customerId);
}
