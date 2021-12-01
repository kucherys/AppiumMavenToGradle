package pages.o1;

import capabilities.BaseClassIos;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TermsConditionsPage extends BaseClassIos {

    EligibilityConfirmPage eligibilityConfirmPage;

    By titleLabel = By.id("label.title");
    By bodyText = By.id("label.description");
    By confirmButton = By.id("button.confirm");
    By checkbox = By.id("checkbox.button");
    By personelData  = By.id("cell.index_0");

    public TermsConditionsPage(IOSDriver<IOSElement> driver){
        this.driver = driver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> driver){
        return driver.findElement(bodyText).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName){
        String actualName = driver.findElement(titleLabel).getText();
//        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyBodyTextLabel(String expectedName){
        String actualName = driver.findElement(bodyText).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifySignUpButton(String expectedName){
        String actualName = driver.findElement(confirmButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyPersonalDataText(String expectedName){
        String actualName = driver.findElement(personelData).getText();
        Assert.assertEquals(actualName, expectedName);
    }

    public EligibilityConfirmPage getEligibilityConfirmPage (IOSDriver<IOSElement> driver){
        driver.findElement(checkbox).click();
        driver.findElement(confirmButton).click();
        return new EligibilityConfirmPage(driver);
    }
}
