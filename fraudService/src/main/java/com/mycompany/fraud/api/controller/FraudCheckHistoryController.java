package com.mycompany.fraud.api.controller;

import com.mycompany.fraud.domain.service.FraudCheckHistoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraudCheck")
public record FraudCheckHistoryController(FraudCheckHistoryService fraudCheckHistoryService) {

}
