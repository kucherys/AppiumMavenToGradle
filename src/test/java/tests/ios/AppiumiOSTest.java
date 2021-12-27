package tests.ios;

import capabilities.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ios.o1.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppiumiOSTest extends BaseClass {

    IOSLaunchPage iosLaunchPage;
    EligibilityModalPage eligibilityModalPage;

    @Test (enabled = false)
    public void verify_launching_page() {
        iosLaunchPage = new IOSLaunchPage(iosDriver);
        iosLaunchPage.verifyLogInButton("Log In");
        iosLaunchPage.verifyWelcomeLabel("Welcome to ARBM Digibank");
        iosLaunchPage.verifySignUpButton("I'm new to [ARBM Digibank]");
    }

    @Test (enabled = false)
    public void verify_product_carousel_page() {
        iosLaunchPage = new IOSLaunchPage(iosDriver);
        ProductCarouselPage prodCarPage = iosLaunchPage.logInToProductCarouselPage(iosDriver);
        prodCarPage.verifyInstructionText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ullamcorper aliquet risus");
        prodCarPage.verifyLogoLabel("DigiBank");
        prodCarPage.verifyOpenBankAccountButton("Open Bank Account");
        prodCarPage.verifyEligibilityLabel("Am I eligible?");
        for(int i = 0; i<3; i++) {
            iosDriver.findElementByAccessibilityId("pageControl").click();
        }
    }
    @Test (enabled = false)
    public void verify_product_eligibility_modal() {
        iosLaunchPage = new IOSLaunchPage(iosDriver);
        ProductCarouselPage prodCarPage = iosLaunchPage.logInToProductCarouselPage(iosDriver);
        eligibilityModalPage = prodCarPage.openEligibilityModal(iosDriver);
        eligibilityModalPage.verifyCloseButton();
        eligibilityModalPage.verifyEligibilityLabelName("Eligibility criteria");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "I am a Malaysian with a MyKad, residing in Malaysia",
                "I am aged 18 and above",
                "I have an existing internet banking account with another bank in Malaysia",
                "I am NOT a US person",
                "I am NOT a tax resident in any other country",
                "I am applying for an individual account");
        eligibilityModalPage.verifyEligibilityList(list);
        eligibilityModalPage.closeEligibilityModal();

        for(int i = 0; i<3; i++) {
            iosDriver.findElementByAccessibilityId("pageControl").click();
        }

        eligibilityModalPage = prodCarPage.openEligibilityModal(iosDriver);
        eligibilityModalPage.verifyCloseButton();
        eligibilityModalPage.verifyEligibilityLabelName("Eligibility criteria");
        eligibilityModalPage.verifyEligibilityList(list);
        eligibilityModalPage.closeEligibilityModal();

    }

    @Test (enabled = false)
    public void verify_app_flow_page() {
        iosLaunchPage = new IOSLaunchPage(iosDriver);
        ProductCarouselPage prodCarPage = iosLaunchPage.logInToProductCarouselPage(iosDriver);
        AppFlowPage appFlowPage = prodCarPage.getAppFlowPage(iosDriver);
        appFlowPage.verifyTitleLabel("This shouldn't take long at all");
        appFlowPage.verifyLabelDescription("We pride ourselves on a quick sign up");
//        appFlowPage.verifySecondTextLabel("Please ensure you have your MyKad with you before starting the process");
        appFlowPage.verifyProgressBarLabels("Sign up & ID verification","Personal details",
                "Create an account", "Top up account");
        appFlowPage.verifySignUpButton("Let's sign up");
    }

    @Test (enabled = false)
    public void verify_terms_conditions_page() {
        iosLaunchPage = new IOSLaunchPage(iosDriver);
        ProductCarouselPage prodCarPage = iosLaunchPage.logInToProductCarouselPage(iosDriver);
        AppFlowPage appFlowPage = prodCarPage.getAppFlowPage(iosDriver);
        TermsConditionsPage termsConditionsPage = appFlowPage.getTermsConditionsPage(iosDriver);
        termsConditionsPage.verifyBodyTextLabel("We're committed to protecting the data you share with us. Please contact our customer care team with any queries.");
        termsConditionsPage.verifySignUpButton("Confirm");
        termsConditionsPage.verifyTitleLabel("Welcome to a new way of banking");
        termsConditionsPage.verifyPersonalDataText("Personal Data Protection");

    }

    @Test (enabled = false)
    public void verify_eligbility_page() {
        iosLaunchPage = new IOSLaunchPage(iosDriver);
        ProductCarouselPage prodCarPage = iosLaunchPage.logInToProductCarouselPage(iosDriver);
        AppFlowPage appFlowPage = prodCarPage.getAppFlowPage(iosDriver);
        TermsConditionsPage termsConditionsPage = appFlowPage.getTermsConditionsPage(iosDriver);
        EligibilityConfirmPage eligibilityConfirmPage = termsConditionsPage.getEligibilityConfirmPage(iosDriver);
        eligibilityConfirmPage.verifyTitleLabel("I'm eligible because...");
        eligibilityConfirmPage.verifyTipText("Tip: You are a US person if you are either a US citizen, a US resident or a Green Card holder.");
        eligibilityConfirmPage.verifyConfirmEligibleButton("I confirm I am eligible");
        eligibilityConfirmPage.verifyConfirmNotEligibleButton("I am not eligible");

    }

    @Test (enabled = false)
    public void verify_capture_name_page() throws InterruptedException {
        iosLaunchPage = new IOSLaunchPage(iosDriver);
        ProductCarouselPage prodCarPage = iosLaunchPage.logInToProductCarouselPage(iosDriver);
        AppFlowPage appFlowPage = prodCarPage.getAppFlowPage(iosDriver);
        TermsConditionsPage termsConditionsPage = appFlowPage.getTermsConditionsPage(iosDriver);
        EligibilityConfirmPage eligibilityConfirmPage = termsConditionsPage.getEligibilityConfirmPage(iosDriver);
        NameCapturePage captureNamePage = eligibilityConfirmPage.getCaptureNamePage(iosDriver);
        captureNamePage.verifyBodyTextLabel("This name is just a friendly way for us to address you. " +
                "We won't show it on your DigiBank card or anything official.");
        captureNamePage.verifyTitleLabel("What should we call you?");
        captureNamePage.verifyNextButton("Next");
        captureNamePage.fillNameTextField("User");

    }

    @Test (enabled = false)
    public void verify_capture_phone_page() throws InterruptedException {
        iosLaunchPage = new IOSLaunchPage(iosDriver);
        ProductCarouselPage prodCarPage = iosLaunchPage.logInToProductCarouselPage(iosDriver);
        AppFlowPage appFlowPage = prodCarPage.getAppFlowPage(iosDriver);
        TermsConditionsPage termsConditionsPage = appFlowPage.getTermsConditionsPage(iosDriver);
        EligibilityConfirmPage eligibilityConfirmPage = termsConditionsPage.getEligibilityConfirmPage(iosDriver);
        NameCapturePage captureNamePage = eligibilityConfirmPage.getCaptureNamePage(iosDriver);
        captureNamePage.fillNameTextField("User");
        PhoneCapturePage phoneCapturePage = captureNamePage.getPhoneCapturePage(iosDriver);
        phoneCapturePage.fillPhoneNumberField("1123456789");
        Assert.assertTrue(phoneCapturePage.getConfirmButtonStatus());
        phoneCapturePage.fillPhoneNumberField("1223456789");
        Assert.assertFalse(phoneCapturePage.getConfirmButtonStatus());
        phoneCapturePage.fillPhoneNumberField("122345678");
        Assert.assertTrue(phoneCapturePage.getConfirmButtonStatus());
        phoneCapturePage.getConfirmButtonName("Confirm");
        phoneCapturePage.verifyTitleLabel("What is your mobile number?");
    }
}
