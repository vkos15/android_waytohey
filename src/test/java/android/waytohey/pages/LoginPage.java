package android.waytohey.pages;

import android.waytohey.config.waytohey.WaytoheyProject;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static android.waytohey.testdata.TestData.userSuccess;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private SelenideElement login  = $x("//*[@resource-id='input_login']");
    private SelenideElement password =  $x("//*[@resource-id='input_pass']");

    @Step("Открываем окно логина")
    public LoginPage openLoginWindow() {
        WebDriverRunner.getWebDriver().get("https://waytohey.com/#login");
        return this;
    }

    @Step("Указываем логин")
    public LoginPage typeLogin(String login) {
        this.login.setValue(login);
        return this;
    }

    @Step("Указываем пароль")
    public LoginPage typePassword(String password) {
        this.password.setValue(password);
        return this;
    }

    @Step("Войти")
    public void submitLoginForm() {
        SelenideElement submitLogin = $x("//*[@text=\"Let's go\"]");
        if (!submitLogin.isDisplayed())
            $x("//*[@content-desc=\"Let's go\"]").click();
        else submitLogin.click();
    }

    @Step("Проверяем, что отобразилось сообщение об ошибке")
    public LoginPage checkErrorLoginMessage(String error) {
      SelenideElement error_with_text = $$(MobileBy.className("android.view.View")).filterBy(text(error)).first();
      //на старых версиях chrome webview локаторы отличаются
        // и проверить конкретный текст ошибки невозможно, проверяем просто наличие ошибки
      if (!error_with_text.isDisplayed())
          $x("//*[@resource-id='input_login']/following-sibling::*[1]").shouldBe(visible);
        return this;
    }

    @Step("Проверяем сообщение об ошибке")
    public LoginPage checkErrorPasswordMessage(String error) {
        SelenideElement error_with_text = $$(MobileBy.className("android.view.View")).filterBy(text(error)).first();
        //на старых версиях chrome webview локаторы отличаются
        // и проверить конкретный текст ошибки невозможно, проверяем просто наличие ошибки возле поля
        if (!error_with_text.isDisplayed())
            $x("//*[@resource-id='input_pass']/following-sibling::*[1]").shouldBe(visible);
        return this;
    }

    @Step("Входим под пользователем {login} ")
    public void login(String login, String password) {
        this.openLoginWindow()
                .typeLogin(login)
                .typePassword(password)
                .submitLoginForm();
        $x("//*[@resource-id='ivisitcard_info']").shouldBe(visible);
    }
}
