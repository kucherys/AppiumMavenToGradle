package pages.ios.o1;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EligibilityModalPage {

    IOSDriver<IOSElement> driver;
    ProductCarouselPage productCarouselPage;

    By closeButton = By.id("button.close");
    By eligibilityLabel = By.id("label.title");

    public EligibilityModalPage(IOSDriver<IOSElement> driver){
        this.driver = driver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> driver){
        return driver.findElement(eligibilityLabel).isDisplayed();
    }

    public void verifyCloseButton(){
        String actualName = driver.findElement(closeButton).getText();
        Assert.assertEquals("multiply", actualName);
    }

    public ProductCarouselPage closeEligibilityModal(){
        driver.findElementByAccessibilityId("button.close").click();
        productCarouselPage = new ProductCarouselPage(driver);
        return productCarouselPage;
    }

    public void verifyEligibilityLabelName(String expectedName){
        String actualName = driver.findElement(eligibilityLabel).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyEligibilityList(List<String> expectedString){
        String str = driver.findElementByAccessibilityId("text.eligibilityCriteria").getText();
        List<String> actualString = Pattern.compile("•\t")
                .splitAsStream(str)
                .collect(Collectors.toList());
        List<String> transformActual = new ArrayList<>();
        actualString.forEach(s -> transformActual.add(s.replace("\n", "")));
        transformActual.removeAll(Arrays.asList("", null));

        System.out.println("ACTUAL");
        for (String i:transformActual){
            System.out.println(i);
        }

        Assert.assertTrue(transformActual.equals(expectedString));
    }

}
