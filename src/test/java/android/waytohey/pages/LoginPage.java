package android.waytohey.pages;

import android.waytohey.config.waytohey.WaytoheyProject;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {


    //private SelenideElement login =   $(MobileBy.id("input_login"));
    private SelenideElement login  = $x("//*[@resource-id='input_login']");
    private SelenideElement password =  $x("//*[@resource-id='input_pass']");
  //  private SelenideElement password = $(MobileBy.id("input_pass"));
    private SelenideElement submitLogin = $x("//android.widget.Button[@text=\"Let's go\"]");

    @Step("Открываем окно логина")
    public LoginPage openLoginWindow() {
        SelenideElement login_button=$x("//android.view.View[@content-desc=\"Log in\"]");
       if (!login_button.isDisplayed()) //на разных версиях android селекторы разные
        $x("//android.view.View[@text=\"Log in\"]").click();
               else
           login_button.click();
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
        submitLogin.click();
    }

    @Step("Проверяем сообщение об ошибке")
    public LoginPage checkErrorLoginMessage(String error) {
        //$("#input_login+i.error_message").shouldBe(visible).shouldHave(text(error));
        // $x("//*[@resource-id='input_login']/following-sibling::android.widget.TextView").shouldBe(visible).shouldHave(text(error));
        $x("//*[@resource-id='input_login']/following-sibling::*[1]").shouldBe(visible).shouldHave(text(error));
        return this;
    }

    @Step("Проверяем сообщение об ошибке")
    public LoginPage checkErrorPasswordMessage(String error) {
        $x("//*[@resource-id='input_pass']/following-sibling::android.widget.TextView").shouldBe(visible).shouldHave(text(error));
        return this;
    }

    @Step("Входим под пользователем {login} ")
    public void login(String login, String password) {
        open("#login");
        this.login.shouldBe(visible).setValue(login);
        this.password.setValue(password);
        submitLogin.click();
        $("#ivisitcard_info").shouldBe(visible);
    }


    @Step("Логин по authKey")
    public void loginByAuthKey(String authKey) {
        if (!System.getProperty("environment").equals("prod"))
            Selenide.open(authKey, "", WaytoheyProject.configW2H.auth_login(), WaytoheyProject.configW2H.auth_pass());
        else open(authKey);
    }




}
