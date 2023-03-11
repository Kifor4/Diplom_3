import api.APIHelper;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.BasePage;
import pages.LoginPage;

import java.lang.reflect.InvocationTargetException;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizedUserActions extends BaseTest {
    private APIHelper helper;
    private String name;
    private String email;
    private String password;

    @Before
    public void setUp() {
        helper = new APIHelper();
        name = RandomStringUtils.randomAlphabetic(5, 10);
        email = name.toLowerCase() + "@testmail.test";
        password = RandomStringUtils.randomAlphanumeric(6, 10);
        helper.registerUser(email, password, name);
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    public void positiveProfileTransaction() {
        open(BASE_URL, BasePage.class)
                .noAuthClickProfileButton()
                .setLoginFields(email, password)
                .clickLoginButtonSuccessful()
                .authClickProfileButton()
                .checkUrl();
    }

    @Test
    @DisplayName("Выход из учетной записи")
    public void positiveConstructorTransaction() {
        open(BASE_URL, BasePage.class)
                .noAuthClickProfileButton()
                .setLoginFields(email, password)
                .clickLoginButtonSuccessful()
                .authClickProfileButton()
                .clickExitButton()
                .noAuthClickProfileButton()
                .checkUrl();
    }

    @After
    public void tearDown() {
        closeWebDriver();
        try {
            helper.deleteUserPool(email, password);
        } catch (Exception ignore) {
        }
    }
}
