import api.APIHelper;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.BasePage;
import pages.LoginPage;

import java.lang.reflect.InvocationTargetException;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Авторизация")
@RunWith(Parameterized.class)
public class LoginTests extends BaseTest {
    private APIHelper helper;
    private String name;
    private String email;
    private String password;
    private String url;
    private String startClass;
    private String methodName;

    public LoginTests(String url, String startClass, String methodName) {
        this.url = url;
        this.startClass = startClass;
        this.methodName = methodName;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {BASE_URL, "pages.BasePage", "noAuthClickProfileButton"},
                {BASE_URL, "pages.ConstructorPage", "clickLoginButton"},
                {BASE_URL + "/register", "pages.RegistrationPage", "clickLoginLink"},
                {BASE_URL + "/forgot-password", "pages.ForgotPasswordPage", "clickLoginLink"}
        };
    }

    @Before
    public void setUp() {
        helper = new APIHelper();
        name = RandomStringUtils.randomAlphabetic(5, 10);
        email = name.toLowerCase() + "@testmail.test";
        password = RandomStringUtils.randomAlphanumeric(6, 10);
        helper.registerUser(email, password, name);
    }

    @Test
    public void positiveLogin() {
        try {
            Class po = Class.forName(startClass);
            BasePage startPage = (BasePage) open(url, Class.forName(startClass));
            LoginPage loginPage = (LoginPage) po.getMethod("noAuthClickProfileButton").invoke(startPage);
            loginPage
                    .setLoginFields(email, password)
                    .clickLoginButtonSuccessful()
                    .authClickProfileButton()
                    .checkUserData(name, email);
        } catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
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
