package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage extends BasePage {
    @FindBy(xpath = ".//input")
    private List<SelenideElement> fields;
    @FindBy(xpath = ".//button[text() = 'Зарегистрироваться']")
    private SelenideElement registrationButton;

    @Step("Заполнение полей формы регистрации")
    public RegistrationPage setRegistrationFields(String name, String email, String password){
        fields.get(0).setValue(name);
        fields.get(1).setValue(email);
        fields.get(2).setValue(password);
        return page(RegistrationPage.class);
    }

    @Step("Клик по кнопке \"Зарегистрироваться\"")
    public LoginPage clickRegistrationButton(){
        registrationButton.click();
        return page(LoginPage.class);
    }
}
