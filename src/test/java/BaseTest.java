import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    protected static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String WEB_DRIVER_PATH = "src/main/resources/chromedriver.exe";
//    private static final String WEB_DRIVER_PATH = "src/main/resources/yandexdriver.exe";

    static {
        System.setProperty("webdriver.chrome.driver", WEB_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
    }
}
