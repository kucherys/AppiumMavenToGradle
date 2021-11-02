package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TermsConditionsPage {

    IOSDriver<IOSElement> driver;
    EligibilityConfirmPage eligibilityConfirmPage;

    By titleLabel = By.id("label.title");
    By bodyText = By.id("label.description");
    By confirmButton = By.id("button.confirm");
    By checkbox = By.id("checkbox");

    public TermsConditionsPage(IOSDriver<IOSElement> driver){
        this.driver = driver;
    }

    public void verifyTitleLabel(String expectedName){
        String actualName = driver.findElement(titleLabel).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyBodyTextLabel(String expectedName){
        String actualName = driver.findElement(bodyText).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifySignUpButton(String expectedName){
        String actualName = driver.findElement(confirmButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public EligibilityConfirmPage getEligibilityConfirmPage (){
//        driver.findElement(checkbox).click();
        driver.findElement(confirmButton).click();
        eligibilityConfirmPage = new EligibilityConfirmPage(driver);
        return eligibilityConfirmPage;
    }
}