package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/resources/features"},
        plugin = {"json:target/jsonReports/cucumber-report.json"},
        glue = {"steps"},
        tags = "@landAndroid")

public class TestRunner {
}
