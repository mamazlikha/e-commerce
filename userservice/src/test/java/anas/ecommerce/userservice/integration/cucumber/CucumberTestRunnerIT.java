package anas.ecommerce.userservice.integration.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "classpath:features/" },
        plugin = { "pretty" },
        glue={ "anas.ecommerce.userservice.integration.cucumber.stepdef", "anas.ecommerce.userservice" })
public class CucumberTestRunnerIT {

}