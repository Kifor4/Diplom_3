import api.UserDeleter;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Регистрация")
public class RegistrationTests extends BaseTest {
    private String name;
    private String email;
    private String password;

    @Before
    public void setUp() {
        name = RandomStringUtils.randomAlphabetic(5, 10);
        email = name.toLowerCase() + "@testmail.test";
        password = RandomStringUtils.randomAlphanumeric(6, 10);
    }

    @Test
    @DisplayName("Регистрация нового пользователя")
    public void positiveAccountRegistration() {
        open(BASE_URL, BasePage.class)
                .noAuthClickProfileButton()
                .clickRegistrationLink()
                .setRegistrationFields(name, email, password)
                .clickRegistrationButtonSuccessful()
                .setLoginFields(email, password)
                .clickLoginButtonSuccessful()
                .authClickProfileButton()
                .checkUserData(name, email);
    }

    @Test
    @DisplayName("Регистрация нового пользователя с паролем из 5-ти символов")
    public void negativeAccountRegistration() {
        password = password.substring(0, 5);
        open(BASE_URL, BasePage.class)
                .noAuthClickProfileButton()
                .clickRegistrationLink()
                .setRegistrationFields(name, email, password)
                .clickRegistrationButtonUnsuccessful()
                .checkInvalidPasswordMessage()
                .noAuthClickProfileButton()
                .setLoginFields(email, password)
                .clickLoginButtonUnsuccessful()
                .checkUrl();
    }

    @After
    public void tearDown() {
        closeWebDriver();
        try {
            new UserDeleter().deleteUserPool(email, password);
        } catch (Exception ignore) {
        }
    }
}
