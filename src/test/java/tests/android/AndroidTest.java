package tests.android;

import capabilities.BaseClassAndroid;
import org.testng.annotations.Test;
import pages.android.o1.AndroidLaunchPage;

public class AndroidTest extends BaseClassAndroid {

    AndroidLaunchPage androidLaunchPage;

    @Test (enabled = false)
    public void verify_android_launching_page() {
        androidLaunchPage = new AndroidLaunchPage(androidDriver);
        androidLaunchPage.verifyLogInButton("Log In");
        androidLaunchPage.verifyWelcomeLabel("Welcome to ARBM Digibank");
        androidLaunchPage.verifySignUpButton("I'm new to Digibank");

        System.out.println("TEST PASSED ON TestNG");
    }
}
