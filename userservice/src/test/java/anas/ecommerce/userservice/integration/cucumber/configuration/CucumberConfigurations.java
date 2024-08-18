package anas.ecommerce.userservice.integration.cucumber.configuration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.openapitools.client.api.CreateCartForUserControllerApi;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberConfigurations {
    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder();
    }
}
