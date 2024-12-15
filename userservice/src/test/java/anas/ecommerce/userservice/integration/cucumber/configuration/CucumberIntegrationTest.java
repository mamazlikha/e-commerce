package anas.ecommerce.userservice.integration.cucumber.configuration;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "classpath:features/" },
        glue={ "anas.ecommerce.userservice.integration.cucumber.stepdef", "anas.ecommerce.userservice.integration.cucumber.configuration" }) // specify the package where your step definitions are
public class CucumberIntegrationTest {

}