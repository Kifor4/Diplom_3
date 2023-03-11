package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePage extends BasePage{
    @FindBy(xpath = ".//input")
    private List<SelenideElement> fields;

    @Step("Проверка данных пользователя")
    public ProfilePage checkUserData(String name, String email) {
        Assert.assertEquals("Имя пользователя не совпадает с введенным при регистрации", name, fields.get(0).getValue());
        Assert.assertEquals("Email пользователя не совпадает с введенным при регистрации", email, fields.get(1).getValue());
        return page(ProfilePage.class);
    }
}
