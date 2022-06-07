package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseMethods {
    private final String LOGIN_PAGE_URL = "https://www.mizu.com/en-mx/login";
    private final By MAIL_TEXT_BOX = By.id("EmailLogin");
    private final By PASSWORD_TEXT_BOX = By.id("Password");
    private final By SIGN_IN_BUTTON = By.cssSelector(".login__btn");
    private final By ERROR_MODAL_BOX = By.id("modalBox");
    private final By MAIL_ERROR = By.id("EmailLogin-Error");
    private final By PASSWORD_ERROR = By.id("Password-Error");
    private final By SIGN_IN_WITH_FACEBOOK = By.cssSelector(".login__facebook");

    public LoginPage(WebDriver driver) { super(driver); }

    public void goToLoginPage() {
        navigateUrl(LOGIN_PAGE_URL);
    }

    public void loginWithCredentials(String mail, String password) {
        sendKeys(MAIL_TEXT_BOX, mail);
        sendKeys(PASSWORD_TEXT_BOX, password);
        click(SIGN_IN_BUTTON);
    }

    public Boolean isErrorModalBoxExists() {
        return isElementExist(ERROR_MODAL_BOX);
    }

    public void setMail(String mail) {
        sendKeys(MAIL_TEXT_BOX, mail);
    }

    public void setPassword(String mail) {
        sendKeys(MAIL_TEXT_BOX, mail);
    }

    public boolean isMailErrorCorrect(String expectedError) {
        boolean isShownError = isElementExist(MAIL_ERROR);
        boolean isErrorMessageEqual = getText(MAIL_ERROR).equals(expectedError);

        return isErrorMessageEqual && isShownError;
    }

    public boolean isPasswordErrorCorrect(String expectedError) {
        boolean isShownError = isElementExist(PASSWORD_ERROR);
        boolean isErrorMessageEqual = getText(PASSWORD_ERROR).equals(expectedError);

        return isErrorMessageEqual && isShownError;
    }

    public ExternalPage clickSignInWithFacebook() {
        click(SIGN_IN_WITH_FACEBOOK);
        switchToTab();

        return new ExternalPage(driver);
    }
}
