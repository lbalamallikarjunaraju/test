package com.restful.test.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final String BASE_PACKAGE = "com.restful.test";
    private ApiInfo metaData = new ApiInfo("Credit score APIs", "APIs documentation for CreditScore", "1.0", "Terms of service",
            new Contact("Bala", "-", "info@test.com"), "Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0",
            emptyList());

    private List<ResponseMessage> customDefaultResponseMessages() {
        List<ResponseMessage> responseMessageBuilders = new ArrayList<>();
        responseMessageBuilders.add(new ResponseMessageBuilder().code(400).message("Bad request").build());
        responseMessageBuilders.add(new ResponseMessageBuilder().code(500).message("Internal server error").build());
        return responseMessageBuilders;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .globalResponseMessage(RequestMethod.GET, this.customDefaultResponseMessages())
                .globalResponseMessage(RequestMethod.POST, this.customDefaultResponseMessages())
                .globalResponseMessage(RequestMethod.PATCH, this.customDefaultResponseMessages())
                .globalResponseMessage(RequestMethod.PUT, this.customDefaultResponseMessages())
                .globalResponseMessage(RequestMethod.DELETE, this.customDefaultResponseMessages())
                .apiInfo(this.metaData);
    }
}
