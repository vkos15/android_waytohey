package android.waytohey.drivers;

import android.waytohey.config.Project;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidMobileDriver implements WebDriverProvider {

    public static URL getSelenoidUrl() {
        try {
            return new URL(
                    Project.configSelenoid.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", Project.configSelenoid.deviceName());
        desiredCapabilities.setCapability("version", Project.configSelenoid.version());
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);
        desiredCapabilities.setCapability("appPackage", "com.waytohey.mobile");
        desiredCapabilities.setCapability("appActivity", "ru.mylove.android.ui.splash.SplashActivity");
        desiredCapabilities.setCapability("app", apkUrl());

        return new AndroidDriver(getSelenoidUrl(), desiredCapabilities);
    }

    private URL apkUrl() {
        try {
            return new URL("https://github.com/vkos15/android_waytohey/releases/download/v112094/w2h_112094.apk");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
