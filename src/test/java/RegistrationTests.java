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
                .clickRegistrationButton()
                .setLoginFields(email, password)
                .clickLoginButton()
                .authClickProfileButton()
                .checkUserData(name, email);
    }

    @After
    public void tearDown() {
        System.out.println(email + "   " + password);
        closeWebDriver();
        try {
            new UserDeleter().deleteUserPool(email, password);
        } catch (Exception ignore) {
        }
    }
}
