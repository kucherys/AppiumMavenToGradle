package capabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseClass extends Capabilities {

    public static IOSDriver<IOSElement> iosDriver;
    public static AndroidDriver<AndroidElement> androidDriver;
    public static String appType;

    public static String getAppType() {
        return appType;
    }

    public static void setAppType(String appType) {
        BaseClass.appType = appType;
    }

    @BeforeClass
    public void setupClassGlobal(String type) throws IOException, InterruptedException {
        service = startServer();
        setAppType(type);
        if (getAppType().equals("iOS")) {
            iosDriver = capabilitiesIos("Digibank.app");
        }

        else if (getAppType().equals("Android")) {
            androidDriver = capabilitiesAndroid("digibank-0.0.24-debug.apk");
        }
    }

    @AfterClass
    public void cleanUpClassGlobal() {
        System.out.println("Global class clean up");
        service.stop();
    }

    @BeforeMethod
    public void setupGlobal() {
        System.out.println("Global method setup");
    }

    @AfterMethod
    public void cleanUpGlobal() {
        System.out.println("Global method clean up");
    }

    public String removeFirstLastChar(String str) {
        return str = str.substring(1, str.length() - 1);
    }


}
