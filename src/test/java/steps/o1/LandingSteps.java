package steps.o1;

import capabilities.BaseClass;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.android.o1.AndroidLaunchPage;
import pages.ios.o1.IOSLaunchPage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LandingSteps extends BaseClass {

    IOSLaunchPage iosLaunchPage;
    AndroidLaunchPage androidLaunchPage;

    @Given("Appium server is running")
    public void appiumServerIsRunning() {
        service = startServer();
    }

    @Given("^Appium server and simulator with application type (.+) started$")
    public void appiumServerAndApplicationiOSRunning(String appType) throws IOException, InterruptedException {
        setupClassGlobal(appType);
    }

    @When("I verify landing page is loaded")
    public void verifyLandingPageLoaded() {
        if (getAppType().equals("iOS") ) {
            iosLaunchPage = new IOSLaunchPage(iosDriver);
            Assert.assertTrue(iosLaunchPage.isLoaded(iosDriver));
        } else if (appType.equals("Android") ) {
            androidLaunchPage = new AndroidLaunchPage(androidDriver);
            Assert.assertTrue(androidLaunchPage.isLoaded(androidDriver));
        }
    }

    @Then("I verify elements on landing page")
    public void verifyElementsLandingDataPage(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        if (getAppType().equals("iOS")) {
            for (Map<String, String> row : rows) {
                iosLaunchPage.verifyLogInButton(row.get("logInButton"));
                iosLaunchPage.verifyWelcomeLabel(row.get("logoLabel"));
                iosLaunchPage.verifySignUpButton(row.get("signUpButton"));
            }
        } else if (getAppType().equals("Android")) {
            for (Map<String, String> row : rows) {
                androidLaunchPage.verifyLogInButton(row.get("logInButton"));
                androidLaunchPage.verifyWelcomeLabel(row.get("logoLabel"));
                androidLaunchPage.verifySignUpButton(row.get("signUpButton"));
            }
        }
    }

    @Then("^I confirm tests completed with result (.+)$")
    public void confitmTets(String result) {
        System.out.println("CUCUMBER TESTS PASSED WITH RESILT: " + result);

    }

    @After
    public void stopAppiumServer(){
        System.out.println("Stop appium server");
        service.stop();
    }
}
