package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage extends BasePage {
    @FindBy(xpath = ".//a[text() = 'Войти']")
    private SelenideElement loginLink;

    @Step("Клик по ссылке \"Войти\"")
    public LoginPage clickLoginLink() {
        loginLink.click();
        return page(LoginPage.class);
    }
}
