package pom;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Стартовая страница входа в систему МЭЛТОР
 */
public class LoginPage {

    // поле логина
    private final SelenideElement usernameField =$("[name='username']");
    // поле пароля
    private final SelenideElement passwordField =$("[name='password']");
    // кнопка Вход
    private final SelenideElement loginButton =$("#ext-gen41");
    // Сообщение об ошибке авторизации
    private final SelenideElement errorMessage = $(byText("Логин или пароль введены неправильно!"));
    private final SelenideElement errorField = $(".x-form-invalid");


    public void login(String meltor_login, String meltor_password) {
        typeUsernameInField(meltor_login);
        typePasswordInField(meltor_password);
    }

    public void typeUsernameInField(String username) {
        usernameField.shouldBe(visible).sendKeys(username);
    }

    public void typePasswordInField(String password) {
        passwordField.shouldBe(visible).sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.shouldBe(visible).click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean getErrorField() {
        errorField.shouldBe(visible);
        return errorField.isDisplayed();
    }
}
