package android.waytohey.tests;

import android.waytohey.pages.LoginPage;
import android.waytohey.pages.MainPage;
import android.waytohey.pages.ProfilePage;
import org.junit.jupiter.api.Test;

import static android.waytohey.testdata.TestData.userSuccess;

public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    void checkSectionWithLogo(){
        mainPage.checkTextOnMainPage()
                .checkLogoOnMainPage();
    }

}
