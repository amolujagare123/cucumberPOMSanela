package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features",
        glue= "StepDefinitions",
        tags = "@TempVerify")
public class TestRunner {
}
