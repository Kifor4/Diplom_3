package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class BasePage {
    @FindBy(xpath = ".//p[text() = 'Личный Кабинет']")
    private SelenideElement profileButton;

    @Step("Клик по кнопке \"Личный кабинет\"")
    public LoginPage noAuthClickProfileButton() {
        profileButton.click();
        return page(LoginPage.class);
    }

    @Step("Клик по кнопке \"Личный кабинет\"")
    public ProfilePage authClickProfileButton() {
        profileButton.click();
        return page(ProfilePage.class);
    }
}
