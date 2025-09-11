package com.mycompany.fraud.web.mapper;

import com.mycompany.fraud.domain.model.FraudCheckHistory;
import com.mycompany.fraud.web.dto.response.FraudCheckHistoryResponse;
import org.springframework.stereotype.Component;

@Component
public class FraudCheckHistoryWebMapper {

    public FraudCheckHistoryResponse toDto(FraudCheckHistory fraudCheckHistory) {
        String message = fraudCheckHistory.getIsFraud()
                ? "User was flagged as a fraud"
                : "User has never been flagged as fraud";

        return new FraudCheckHistoryResponse(fraudCheckHistory.getIsFraud(), message);
    }

}
