package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/features/LandingPage.feature",
        plugin = "json:target/jsonReports/cucumber-report.json",
        glue = "steps")

public class TestRunner {
}