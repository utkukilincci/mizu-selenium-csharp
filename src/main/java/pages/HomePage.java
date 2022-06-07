package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseMethods{
    private final By MY_ACCOUNT = By.cssSelector(".user-menu__item--account .user-menu__title");

    public HomePage(WebDriver driver) { super(driver); }

    public boolean isSignedIn() {
        boolean isShownMyAccount = isElementExist(MY_ACCOUNT);
        boolean isMyAccountTextCorrect = getText(MY_ACCOUNT).equals("My Account");

        return isMyAccountTextCorrect && isShownMyAccount;
    }
}
