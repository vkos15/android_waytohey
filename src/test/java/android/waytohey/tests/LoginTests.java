package android.waytohey.tests;

import android.waytohey.pages.ProfilePage;
import org.junit.jupiter.api.Test;
import android.waytohey.pages.LoginPage;

import static android.waytohey.testdata.TestData.userSuccess;
import static android.waytohey.testdata.TestData.userWrongLogin;

public class LoginTests extends TestBase{

    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();

    @Test
    void wrongLoginTest() {
        loginPage.openLoginWindow()
                .typeLogin(userWrongLogin.getLogin())
                .typePassword(userWrongLogin.getPass())
                .submitLoginForm();
        loginPage.checkErrorLoginMessage("User with that username doesn't exist");
    }

    @Test
    void emptyLoginTest() {
        loginPage.openLoginWindow()
                .typePassword(userWrongLogin.getPass())
                .submitLoginForm();
        loginPage.checkErrorLoginMessage("Please enter your login");
    }

    @Test
    void successLogin() {
        loginPage.openLoginWindow()
                .typeLogin(userSuccess.getLogin())
                .typePassword(userSuccess.getPass())
                .submitLoginForm();
        profilePage.checkVisitCardInfoIsVisibleInProfile();

    }

    @Test
    void emptyPassTest() {
        loginPage.openLoginWindow()
                .typeLogin(userWrongLogin.getLogin())
                .submitLoginForm();
        loginPage.checkErrorPasswordMessage("Enter the password");
    }

}
