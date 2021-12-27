package capabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseClassAndroid extends Capabilities {

    public static AndroidDriver<AndroidElement> androidDriver;

    @BeforeClass
    public void setupClassGlobal() throws IOException, InterruptedException {
        System.out.println("Global class setup");
        service = startServer();
        androidDriver = capabilitiesAndroid("digibank-0.0.24-debug.apk");
    }

    @AfterClass
    public void cleanUpClassGlobal(){
        System.out.println("Global class clean up");
        service.stop();
    }

    @BeforeMethod
    public void setupGlobal(){
        System.out.println("Global method setup");
    }
}
