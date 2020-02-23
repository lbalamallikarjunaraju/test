package com.restful.test.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class CreditScoreInputs {

    @Positive(message = "number of employees should be positive number")
    private int numberOfEmployees;
    @NotNull(message = "Company type is mandatory")
    private String companyType;

    @PositiveOrZero(message = "time in business should be positive number")
    private int numberOfYearsOperated;

    public CreditScoreInputs(@Positive(message = "number of employees should be positive number") int numberOfEmployees,
                             @NotNull(message = "Company type is mandatory") String companyType,
                             @Positive(message = "time in business should be positive number") int numberOfYearsOperated) {
        this.numberOfEmployees = numberOfEmployees;
        this.companyType = companyType;
        this.numberOfYearsOperated = numberOfYearsOperated;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String getCompanyType() {
        return companyType;
    }

    public int getNumberOfYearsOperated() {
        return numberOfYearsOperated;
    }

    @Override
    public String toString() {
        return "CreditScoreInputs{" +
                "numberOfEmployees=" + numberOfEmployees +
                ", companyType=" + companyType +
                ", timeInBusiness=" + numberOfYearsOperated +
                '}';
    }
}
