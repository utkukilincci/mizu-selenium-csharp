package pages;

import org.openqa.selenium.WebDriver;

public class ExternalPage extends BaseMethods{
    public ExternalPage(WebDriver driver) { super(driver); }

    public String getExternalPageUrl() {
        return getUrl();
    }
}
