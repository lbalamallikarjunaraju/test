package com.restful.test.controller;

import com.restful.test.dto.CreditScoreInputs;
import com.restful.test.exception.CustomBadRequestException;
import com.restful.test.service.CreditCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static com.restful.test.util.Endpoints.CREDIT_SCORE_API;

@RestController
public class CreditCalculationController {
    @Autowired
    private CreditCalculationService creditCalculationService;

    @PostMapping(CREDIT_SCORE_API)
    public Integer calculateCreditScore(@Valid @NotNull @RequestBody CreditScoreInputs creditScoreInputs) throws CustomBadRequestException {
        return creditCalculationService.getCreditScore(creditScoreInputs);
    }
}
