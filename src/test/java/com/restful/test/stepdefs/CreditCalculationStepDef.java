package com.restful.test.stepdefs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restful.test.SpringIntegrationTest;
import com.restful.test.dto.CompanyType;
import com.restful.test.dto.CreditScoreInputs;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Objects;

import static com.restful.test.util.Endpoints.CREDIT_SCORE_API;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class CreditCalculationStepDef extends SpringIntegrationTest {

    private Logger logger = LoggerFactory.getLogger(CreditCalculationStepDef.class);
    private int score;

    @When("The calculateCreditAssessmentScore API is called with parameters {int}, {string}, {int}")
    public void the_calculateCreditAssessmentScore_API_is_called_with_parameters(Integer numberOfEmployees, String companyType, Integer numberOfYearsOperated)
            throws Exception {
        CreditScoreInputs request = new CreditScoreInputs(numberOfEmployees, companyType, numberOfYearsOperated);

        String response = mockMvc.perform(MockMvcRequestBuilders.post(CREDIT_SCORE_API)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(getStatus(numberOfEmployees, companyType, numberOfYearsOperated))
                .andReturn().getResponse().getContentAsString();
        logger.info(response);
        if(Objects.nonNull(response) && !response.isEmpty()) {
            score = Integer.parseInt(response);
        }
    }

    @Then("The credit assessment score should match {int}")
    public void the_credit_assessment_score_should_match(Integer result) {
        assertEquals(result.intValue(), score);
    }

    private ResultMatcher getStatus(Integer numberOfEmployees, String companyType, Integer numberOfYearsOperated) {
        if (numberOfEmployees < 1 || CompanyType.convertFrom(companyType) == null || numberOfYearsOperated < 0) {
            return MockMvcResultMatchers.status().isBadRequest();
        }
        return MockMvcResultMatchers.status().isOk();
    }
}
