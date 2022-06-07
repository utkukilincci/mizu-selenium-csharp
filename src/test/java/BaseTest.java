import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static base.BrowserFactory.getChromeOptions;
import static base.BrowserFactory.getFirefoxOptions;
import static base.Config.BROWSER_NAME;
import static java.time.Duration.ofSeconds;

public class BaseTest {
    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    public void setup() {
        ChromeOptions chromeOptions = getChromeOptions();
        FirefoxOptions firefoxOptions = getFirefoxOptions();

        switch (BROWSER_NAME) {
            case "chrome":
            default:
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "safari":
                driver = new SafariDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
