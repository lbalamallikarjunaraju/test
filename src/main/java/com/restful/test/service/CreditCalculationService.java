package com.restful.test.service;

import com.restful.test.dto.CompanyType;
import com.restful.test.dto.CreditScoreInputs;
import com.restful.test.exception.CustomBadRequestException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CreditCalculationService {

    public int getCreditScore(CreditScoreInputs creditScoreInputs) throws CustomBadRequestException {
        AtomicInteger score = new AtomicInteger();
        CompanyType companyType = CompanyType.convertFrom(creditScoreInputs.getCompanyType());
        if(companyType == null){
            throw new CustomBadRequestException("Wrong company type");
        }
        score.addAndGet(companyType.getScore());
        score.addAndGet(getScoreByNumberOfEmployees(creditScoreInputs.getNumberOfEmployees()));
        score.addAndGet(getScoreByTimeInBusiness(creditScoreInputs.getNumberOfYearsOperated()));
        return score.get();
    }

    private int getScoreByNumberOfEmployees(int numberOfEmployees) {
        if (numberOfEmployees < 6) {
            return 0;
        } else if (numberOfEmployees < 11) {
            return 20;
        } else if (numberOfEmployees < 15) {
            return 32;
        } else if (numberOfEmployees < 21) {
            return 55;
        } else {
            return 70;
        }
    }

    private int getScoreByTimeInBusiness(int timeInBusiness) {
        if (timeInBusiness < 4) {
            return 0;
        } else if (timeInBusiness < 10) {
            return 28;
        } else if (timeInBusiness < 16) {
            return 36;
        } else {
            return 59;
        }
    }
}
