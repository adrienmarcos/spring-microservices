package com.mycompany.fraud.web.controller;

import com.mycompany.fraud.web.dto.response.FraudCheckResponse;
import com.mycompany.fraud.domain.service.FraudCheckHistoryServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraudCheck")
@AllArgsConstructor
public class FraudCheckHistoryController {

    private final FraudCheckHistoryServiceImp fraudCheckHistoryService;

    @GetMapping("/{customerId}")
    ResponseEntity<FraudCheckResponse> isFraudster(@PathVariable("customerId") Integer customerId) {
        return ResponseEntity.status(HttpStatus.OK).body(fraudCheckHistoryService.isFraudster(customerId));
    }

}
