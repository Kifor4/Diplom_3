package pages;

import api.APIHelper;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ConstructorPage extends BasePage {
    @FindBy(xpath = ".//button[text() = 'Войти в аккаунт']")
    private SelenideElement loginButton;
    @FindBy(xpath = ".//span[text() = 'Булки']")
    private SelenideElement breadTab;
    @FindBy(xpath = ".//span[text() = 'Соусы']")
    private SelenideElement sousesTab;
    @FindBy(xpath = ".//span[text() = 'Начинки']")
    private SelenideElement fillingsTab;
    @FindBy(xpath = ".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span")
    private SelenideElement selectedTab;

    @Step("Клик по кнопке \"Войти в аккаунт\"")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return page(LoginPage.class);
    }

    @Step("Клик по вкладке \"Булки\"")
    public ConstructorPage clickBreadTab() {
        breadTab.click();
        return page(ConstructorPage.class);
    }

    @Step("Клик по вкладке \"Соусы\"")
    public ConstructorPage clickSousTab() {
        sousesTab.click();
        return page(ConstructorPage.class);
    }

    @Step("Клик по вкладке \"Начинки\"")
    public ConstructorPage clickFillingTab() {
        fillingsTab.click();
        return page(ConstructorPage.class);
    }

    @Step("Проверка, что пользователь находится в конструкторе")
    public ProfilePage checkUrl() {
        Assert.assertEquals("Пользователь не находится в конструкторе", APIHelper.BASE_URL + "/", url());
        return page(ProfilePage.class);
    }

    @Step("Проверка, что открыт раздел \"Булки\"")
    public ConstructorPage checkBreadTabSelected() {
        Assert.assertEquals("Не выбран раздел \"Булки\"", "Булки", selectedTab.getText());
        return page(ConstructorPage.class);
    }

    @Step("Проверка, что открыт раздел \"Соусы\"")
    public ConstructorPage checkSousTabSelected() {
        Assert.assertEquals("Не выбран раздел \"Соусы\"", "Соусы", selectedTab.getText());
        return page(ConstructorPage.class);
    }

    @Step("Проверка, что открыт раздел \"Начинки\"")
    public ConstructorPage checkFillingTabSelected() {
        Assert.assertEquals("Не выбран раздел \"Начинки\"", "Начинки", selectedTab.getText());
        return page(ConstructorPage.class);
    }
}
