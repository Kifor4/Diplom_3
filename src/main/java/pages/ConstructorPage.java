package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class ConstructorPage extends BasePage {
    @FindBy(xpath = ".//button[text() = 'Войти в аккаунт']")
    private SelenideElement loginButton;

    @Step("Клик по кнопке \"Войти в аккаунт\"")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return page(LoginPage.class);
    }
}
