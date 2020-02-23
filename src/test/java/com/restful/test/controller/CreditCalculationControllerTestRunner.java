package com.restful.test.controller;

import com.restful.test.SpringIntegrationTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue = "com.restful.test.stepdefs",
        plugin = { "pretty", "html:target/cucumber" })
public class CreditCalculationControllerTestRunner extends SpringIntegrationTest {
}
