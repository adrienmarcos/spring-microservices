package com.mycompany.fraud.domain.service;

import com.mycompany.fraud.domain.repository.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public record FraudCheckHistoryServiceImp(FraudCheckHistoryRepository fraudCheckHistoryRepository) implements FraudCheckHistoryService {

}
