package android.waytohey.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class BottomNavigationBar {

    @Step("Открываем сообщения")
    public void openMessages() {
        $x("//*[contains(@text,'messages') or contains(@content-desc,'messages')]").click();
    }

    @Step("Проверяем заголовок в сообщениях")
    public void checkHeaderInMessages() {
        $x("//*[contains(@text,'Inbox') or contains(@content-desc,'Inbox')]").shouldBe(visible);
    }

    @Step("Открываем Поиск")
    public void openSearch() {
        $x("//*[contains(@text,'search') or contains(@content-desc,'search') ]").click();
    }

    @Step("Проверяем заголовок в поиске")
    public void checkHeaderInSearch() {
        $x("//*[contains(@text,'Search settings') or contains(@content-desc,'Search settings')]").shouldBe(visible);
    }

    @Step("Открываем Симпатии")
    public void openLikes() {
        $x("//*[contains(@text,'encounters')  or contains(@content-desc,'encounters')]").click();
    }

    @Step("Проверяем, что в симпатиях загрузились фотки")
    public void checkHeaderLikes() {
        $x("//*[@resource-id='sym_photo_cont']").shouldBe(visible);
    }

    /*@Step("Открываем Кошелек")
    public void openCash() {
        $x("//*[contains(@text,'cash')]").click();
    }

    @Step("Проверяем, что в симпатиях загрузились фотки")
    public void checkCash() {
        $x("//*[@id='sym_photo_cont')]").shouldBe(visible);
    }*/



}
