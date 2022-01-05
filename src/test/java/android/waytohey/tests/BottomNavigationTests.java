package android.waytohey.tests;

import android.waytohey.pages.BottomNavigationBar;
import android.waytohey.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static android.waytohey.testdata.TestData.userSuccess;

public class BottomNavigationTests extends TestBase {

    BottomNavigationBar menu = new BottomNavigationBar();
    LoginPage loginPage = new LoginPage();

    @Test
    void checkMessages(){
        loginPage.login(userSuccess.getLogin(),userSuccess.getPass());
        menu.openMessages();
        menu.checkHeaderInMessages();
    }

    @Test
    void checkLikes(){
        loginPage.login(userSuccess.getLogin(),userSuccess.getPass());
        menu.openLikes();
        menu.checkHeaderLikes();
    }

    @Test
    void checkSearch(){
        loginPage.login(userSuccess.getLogin(),userSuccess.getPass());
        menu.openSearch();
        menu.checkHeaderInSearch();
    }
}
