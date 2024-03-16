package anas.ecommerce.userservice.integration.cucumber.configuration;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.boot.test.context.SpringBootTest.*;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "classpath:features/" },
        glue={ "anas.ecommerce.userservice.integration.cucumber.stepdef", "anas.ecommerce.userservice.integration.cucumber.configuration" }) // specify the package where your step definitions are
public class CucumberIntegrationTest {

}