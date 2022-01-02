package android.waytohey.drivers;

import android.waytohey.config.Project;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmulatorMobileDriver implements WebDriverProvider {

    public static URL getAppiumServerUrl() {
        try {
            return new URL(
                    "http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {



        // Set URL of the application under test

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", Project.configEmulator.deviceName());
      //  desiredCapabilities.setCapability("deviceName", "R58NB3H9W2Z");
        desiredCapabilities.setCapability(  "automationName","UiAutomator2");

        desiredCapabilities.setCapability("version", Project.configEmulator.version());
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appPackage", "com.waytohey.mobile");
        //desiredCapabilities.setCapability("appActivity", "org.waytohey.android.activities.RestoreAccountActivity");
        desiredCapabilities.setCapability("appActivity", "ru.mylove.android.ui.splash.SplashActivity");
       // desiredCapabilities.setCapability("appActivity", "ru.mylove.android.ui.AppWebActivity");

       // ru.mylove.android.ui.AppWebActivity
        desiredCapabilities.setCapability("app", getAbsolutePath("src/test/resources/w2h_112094.apk"));

        return new AndroidDriver(getAppiumServerUrl(), desiredCapabilities);
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");

        return file.getAbsolutePath();
    }
}
