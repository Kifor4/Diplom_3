package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage extends BasePage {
    @FindBy(xpath = ".//input")
    private List<SelenideElement> fields;
    @FindBy(xpath = ".//button[text() = 'Зарегистрироваться']")
    private SelenideElement registrationButton;
    @FindBy(xpath = ".//p[text() = 'Некорректный пароль']")
    private SelenideElement invalidPasswordMessage;

    @Step("Заполнение полей формы регистрации")
    public RegistrationPage setRegistrationFields(String name, String email, String password){
        fields.get(0).setValue(name);
        fields.get(1).setValue(email);
        fields.get(2).setValue(password);
        return page(RegistrationPage.class);
    }

    @Step("Клик по кнопке \"Зарегистрироваться\"")
    public LoginPage clickRegistrationButtonSuccessful(){
        registrationButton.click();
        return page(LoginPage.class);
    }

    @Step("Клик по кнопке \"Зарегистрироваться\"")
    public RegistrationPage clickRegistrationButtonUnsuccessful(){
        registrationButton.click();
        return page(RegistrationPage.class);
    }

    @Step("Проверка появления сообщения о некорректности пароля")
    public RegistrationPage checkInvalidPasswordMessage() {
        Assert.assertTrue("Не появляется сообщение о некорректности пароля", invalidPasswordMessage.isDisplayed());
        return page(RegistrationPage.class);
    }
}
