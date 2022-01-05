package android.waytohey.tests;

import android.waytohey.pages.LoginPage;
import android.waytohey.pages.ProfilePage;
import org.junit.jupiter.api.Test;

import static android.waytohey.testdata.TestData.userSuccess;
import static android.waytohey.testdata.TestData.userWrongLogin;

public class ProfileTests extends TestBase {
    ProfilePage profilePage = new ProfilePage();
    LoginPage loginPage = new LoginPage();

    @Test
    void checkBaseInfoInProfile() {
      loginPage.login(userSuccess.getLogin(),userSuccess.getPass());
      profilePage.checkVisitCardAvatarIsVisibleInProfile()
              .checkVisitCardInfoIsVisibleInProfile();
    }

    @Test
    void testOpenPhotoUploadWindowFromProfile() {
        loginPage.login(userSuccess.getLogin(),userSuccess.getPass());
        profilePage.openPhotoUploadWindow();
        profilePage.cheackHeaderInPhotoUploadWindow();

    }

}
