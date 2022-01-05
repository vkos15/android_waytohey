package android.waytohey.drivers;

import android.waytohey.config.Project;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getBrowserStackUrl() {
        try {
            return new URL(Project.config.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {


        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", Project.config.user());
        desiredCapabilities.setCapability("browserstack.key", Project.config.key());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", "bs://1f224bcf78f3471e94fcfcd2c29708ebd304af91");

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", "Google Pixel 3");
        desiredCapabilities.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "Waytohey Project");
        desiredCapabilities.setCapability("build", "browserstack-build-1");
        desiredCapabilities.setCapability("name", "waytohey_test");

        return new AndroidDriver(getBrowserStackUrl(), desiredCapabilities);
    }
}
