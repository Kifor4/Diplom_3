import io.qameta.allure.junit4.DisplayName;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.BasePage;
import pages.ConstructorPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@RunWith(JUnitParamsRunner.class)
@DisplayName("Конструктор")
public class ConstructorTests extends BaseTest {
    @Test
    @DisplayName("Переход в конструктор по кнопке")
    @Parameters({BASE_URL + "/feed", BASE_URL + "/login", BASE_URL + "/register", BASE_URL + "/forgot-password"})
    public void positiveConstructorTransactionByButton(String url) {
        open(url, BasePage.class)
                .clickConstructorButton()
                .checkUrl();
    }

    @Test
    @DisplayName("Переход в конструктор по логотипу")
    @Parameters({BASE_URL + "/feed", BASE_URL + "/login", BASE_URL + "/register", BASE_URL + "/forgot-password"})
    public void positiveConstructorTransactionByLogo(String url) {
        open(url, BasePage.class)
                .clickLogo()
                .checkUrl();
    }

    @Test
    @DisplayName("Переходы по разделам конструктора")
    public void positiveTabsSelection() {
        open(BASE_URL, ConstructorPage.class)
                .clickSousTab()
                .checkSousTabSelected()
                .clickFillingTab()
                .checkFillingTabSelected()
                .clickBreadTab()
                .checkBreadTabSelected();
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
