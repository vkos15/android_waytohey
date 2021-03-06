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

public class LocalMobileDriver implements WebDriverProvider {

    public static URL getAppiumServerUrl() {
        try {
            return new URL(
                    Project.configLocal.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {


        // Specify device and os_version for testing
        desiredCapabilities.setCapability("platformName", "android");
      //  desiredCapabilities.setCapability("deviceName", "Pixel_4_API_30_2");
        desiredCapabilities.setCapability("deviceName", Project.configLocal.deviceName());
        desiredCapabilities.setCapability("automationName", "UiAutomator2");

        desiredCapabilities.setCapability("version", Project.configLocal.version());
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appPackage", "com.waytohey.mobile");
        desiredCapabilities.setCapability("appActivity", "ru.mylove.android.ui.splash.SplashActivity");
        desiredCapabilities.setCapability("app", getAbsolutePath("src/test/resources/w2h_112094.apk"));
        desiredCapabilities.setCapability("disableWindowAnimation", true);


        return new AndroidDriver(getAppiumServerUrl(), desiredCapabilities);
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");
        return file.getAbsolutePath();
    }
}
