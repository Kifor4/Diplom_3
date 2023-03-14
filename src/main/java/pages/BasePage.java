package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class BasePage {
    @FindBy(xpath = ".//p[text() = 'Конструктор']")
    private SelenideElement constructorButton;
    @FindBy(xpath = ".//p[text() = 'Лента Заказов']")
    private SelenideElement feedButton;
    @FindBy(className = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;
    @FindBy(xpath = ".//p[text() = 'Личный Кабинет']")
    private SelenideElement profileButton;

    @Step("Клик по кнопке \"Конструктор\"")
    public ConstructorPage clickConstructorButton() {
        constructorButton.click();
        return page(ConstructorPage.class);
    }

    @Step("Клик по кнопке \"Лента Заказов\"")
    public FeedPage clickFeedButtonButton() {
        feedButton.click();
        return page(FeedPage.class);
    }

    @Step("Клик по логотипу")
    public ConstructorPage clickLogo() {
        logo.click();
        return page(ConstructorPage.class);
    }

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
