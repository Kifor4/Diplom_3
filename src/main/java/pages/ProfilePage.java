package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ProfilePage extends BasePage {
    @FindBy(xpath = ".//input")
    private List<SelenideElement> fields;
    @FindBy(xpath = ".//button[text() = 'Выход']")
    private SelenideElement exitButton;

    @Step("Клик по кнопке \"Выйти\"")
    public LoginPage clickExitButton(){
        exitButton.click();
        return page(LoginPage.class);
    }

    @Step("Проверка данных пользователя")
    public ProfilePage checkUserData(String name, String email) {
        Assert.assertEquals("Имя пользователя не совпадает с введенным при регистрации", name, fields.get(0).getValue());
        Assert.assertEquals("Email пользователя не совпадает с введенным при регистрации", email, fields.get(1).getValue());
        return page(ProfilePage.class);
    }

    @Step("Проверка, что пользователь находится в личном кабинете")
    public ProfilePage checkUrl() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue("Пользователь не находится в личном кабинете", url().endsWith("/account/profile"));
        return page(ProfilePage.class);
    }
}
