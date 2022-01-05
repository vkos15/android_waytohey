package android.waytohey.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final static String TEXT_ON_MAIN_PAGE = "Free dating website for connecting singles";

    @Step("Проверяем текст на главной странице")
    public MainPage checkTextOnMainPage() {
        SelenideElement text_section= $x("//*[@text='"+TEXT_ON_MAIN_PAGE+"']");
        if(!text_section.isDisplayed())
        $x("//*[@content-desc='"+TEXT_ON_MAIN_PAGE+"']").shouldBe(visible);
        return this;
    }

    public MainPage checkLogoOnMainPage() {
        $x("//*[@resource-id='form_logo']").shouldBe(visible);
        return this;
    }
}
