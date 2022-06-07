import org.testng.annotations.Test;
import pages.ExternalPage;
import pages.HomePage;
import pages.LoginPage;

import static base.Constants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static utils.RandomUtils.*;

public class LoginTests extends BaseTest{
    @Test
    public void shouldBeSignInWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.goToLoginPage();
        loginPage.loginWithCredentials(USER_EMAIL, USER_PASSWORD);

        assertThat(
                "When user try to sign up, should be able to see my account field ",
                homePage.isSignedIn(),
                is(true)
        );
    }

    @Test
    public void shouldNotSignInWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToLoginPage();
        loginPage.loginWithCredentials(randomMail(), randomPassword());

        assertThat(
                "When user try to sign up with invalid credentials, should be able to see error modal ",
                loginPage.isErrorModalBoxExists(),
                is(true)
        );
    }

    @Test
    public void shouldBeShownErrorMessageWithInvalidMail() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToLoginPage();
        loginPage.setMail(randomText());
        loginPage.setPassword(randomPassword());

        assertThat(
                "When user try to set invalid mail, should be able to see error message ",
                loginPage.isMailErrorCorrect(INVALID_MAIL_MESSAGE),
                is(true)
        );
    }

    @Test
    public void shouldBeNavigateFacebookWhenClickTheSignInFacebook() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToLoginPage();
        ExternalPage externalPage = loginPage.clickSignInWithFacebook();
        String externalPageUrl = externalPage.getExternalPageUrl();

        assertThat(
                "When user try to sign in with facebook, should be able to navigate facebook page ",
                externalPageUrl,
                containsString("facebook")
        );
    }
}
