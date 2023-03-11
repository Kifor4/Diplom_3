package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

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
    public ConstructorPage clickLoginButton(){
        loginButton.click();
        return page(ConstructorPage.class);
    }

    @Step("Клик по ссылке \"Зарегистрироваться\"")
    public RegistrationPage clickRegistrationLink(){
        registrationLink.click();
        return page(RegistrationPage.class);
    }
}
