package com.mycompany.fraud.domain.service;

import com.mycompany.fraud.domain.model.FraudCheckHistory;

public interface FraudCheckHistoryService {
    FraudCheckHistory isFraudster(Integer customerId);
}
