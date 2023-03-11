package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LoginPage extends BasePage {
    @FindBy(xpath = ".//input")
    private List<SelenideElement> fields;
    @FindBy(xpath = ".//button[text() = 'Войти']")
    private SelenideElement loginButton;
    @FindBy(xpath = ".//a[text() = 'Зарегистрироваться']")
    private SelenideElement registrationLink;

    @Step("Заполнение полей формы входа")
    public LoginPage setLoginFields(String email, String password){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        fields.get(0).setValue(email);
        fields.get(1).setValue(password);
        return page(LoginPage.class);
    }

    @Step("Клик по кнопке \"Войти\"")
    public ConstructorPage clickLoginButtonSuccessful(){
        loginButton.click();
        return page(ConstructorPage.class);
    }

    @Step("Клик по кнопке \"Войти\"")
    public LoginPage clickLoginButtonUnsuccessful(){
        loginButton.click();
        return page(LoginPage.class);
    }

    @Step("Клик по ссылке \"Зарегистрироваться\"")
    public RegistrationPage clickRegistrationLink(){
        registrationLink.click();
        return page(RegistrationPage.class);
    }

    @Step("Проверка, что пользователь находится на странице входа")
    public ProfilePage checkUrl() {
        Assert.assertTrue("Пользователь не находится на странице входа", url().endsWith("/login"));
        return page(ProfilePage.class);
    }
}
