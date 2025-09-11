package com.mycompany.fraud.web.controller;

import com.mycompany.fraud.web.dto.response.FraudCheckHistoryResponse;
import com.mycompany.fraud.application.service.FraudCheckHistoryServiceImp;
import com.mycompany.fraud.web.mapper.FraudCheckHistoryWebMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraudCheck")
@AllArgsConstructor
public class FraudCheckHistoryController {

    private final FraudCheckHistoryServiceImp fraudCheckHistoryService;
    private final FraudCheckHistoryWebMapper mapper;

    @GetMapping("/{customerId}")
    ResponseEntity<FraudCheckHistoryResponse> isFraudster(@PathVariable("customerId") Integer customerId) {
        var fraudCheckHistory = fraudCheckHistoryService.isFraudster(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDto(fraudCheckHistory));
    }

}
