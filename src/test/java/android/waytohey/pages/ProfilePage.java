package android.waytohey.pages;


import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

 import io.appium.java_client.MultiTouchAction;

import  io.appium.java_client.TouchAction;


public class ProfilePage {

    @Step("Проверяем, что в профиле отображается инфа о юзере")
    public  ProfilePage checkVisitCardInfoIsVisibleInProfile() {
        $x("//*[@resource-id='ivisitcard_info']").shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что в профиле отображается аватар")
    public ProfilePage checkVisitCardAvatarIsVisibleInProfile() {
        $x("//*[@resource-id='visitcard_avatar']").shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что в профиле отображается аватар")
    public void openPhotoUploadWindow() {
        $x("//*[contains(@text,'add') or contains(@content-desc,'add')]").click();
    }

    @Step("Проверяем, что в профиле отображается аватар")
    public void cheackHeaderInPhotoUploadWindow() {
        $x("//*[contains(@text,'Add your photos') or contains(@content-desc,'Add your photos')]")
                .shouldBe(visible);
    }






/*
    @Step("Проверка статуса в анкете")
    public void checkStatus(String status) {
        $("#profile_view_mood").shouldHave(text(status)).shouldBe(visible);
    }

    @Step("Заполняем раздел Обо мне")
    public ProfilePage changeAboutMe(String aboutMe) {
        $("#aboutme a").scrollIntoView(true).shouldBe(visible).click();
        $("textarea[name='about']").scrollIntoView(true).shouldBe(visible).setValue(aboutMe);
        $("#ieditsubmit").click();
        return this;
    }

    @Step("Проверяем текст в разделе Обо мне")
    public void checkAboutMe(String aboutMe) {
        $("#profile_view_aboutme").scrollIntoView(true)
                .shouldHave(text(aboutMe)).shouldBe(visible);
    }

   */

}
