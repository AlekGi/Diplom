package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;
import pom.LoginPage;
import pom.MainPage;

import static com.codeborne.selenide.Selenide.*;

@Epic("Тестирование веб-приложения МЭЛТОР")
@DisplayName("Проверка авторизации")
public class LoginTest {

    // Инициализация классов по страницам (с их элементами)
    private static LoginPage loginPage;
    private static MainPage mainPage;
    // Определение статичных полей
    private static String USERNAME;
    private static String PASSWORD;

    /**
     * Настройка перед каждым тестом
     */
    @BeforeEach
    public void setupTest() {
        Selenide.open("https://alekrashgmail4.meltor.ru/");
        loginPage = Selenide.page(LoginPage.class);
    }

    /**
     * На всякий случай закрываем работу браузера
     */
    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @Order(1)
    @DisplayName("Проверка авторизации с пустыми полями логина и пароля.")
    @Test
    public void loginEmptyFieldsTest() {
        // Определяем переменные данных авторизации
        USERNAME = "";
        PASSWORD = "";
        // Вводим данные авторизации
        loginPage.login(USERNAME, PASSWORD);
        // Подтверждаем логин
        loginPage.clickLoginButton();
        // Убеждаемся, что мы НЕ вошли в систему
        Assertions.assertTrue(loginPage.getErrorField());


    }

    @Order(2)
    @DisplayName("Проверка авторизации с валидными полями")
    @Test
    public void loginValidTest() {
        // Определяем переменные данных авторизации
        USERNAME = "boss";
        PASSWORD = "boss";
        // Вводим данные авторизации
        loginPage.login(USERNAME, PASSWORD);
        // Небольшое ожидание, чтобы страница успела прогрузиться
        Selenide.sleep(1000);
        // Подтверждаем логин
        loginPage.clickLoginButton();
        // Небольшое ожидание, чтобы страница успела прогрузиться
        Selenide.sleep(1000);

    }

    @Order(3)
    @DisplayName("Проверка авторизации с валидным логином и пустым полем пароля.")
    @Test
    public void loginEmptyFieldUsernameTest() {
        // Определяем переменные данных авторизации
        USERNAME = "boss";
        PASSWORD = "";
        // Вводим данные авторизации
        loginPage.login(USERNAME, PASSWORD);
        // Небольшое ожидание, чтобы страница успела прогрузиться
        Selenide.sleep(1000);
        // Подтверждаем логин
        loginPage.clickLoginButton();
        // Небольшое ожидание, чтобы страница успела прогрузиться
        Selenide.sleep(1000);
        // Убеждаемся, что мы НЕ вошли в систему
        mainPage = Selenide.page(MainPage.class);
        Assertions.assertTrue(loginPage.getErrorField());
    }

    @Order(4)
    @DisplayName("Проверка авторизации с валидным паролем и пустым полем логина.")
    @Test
    public void loginEmptyFieldPasswordTest() {
        // Определяем переменные данных авторизации
        USERNAME = "";
        PASSWORD = "boss";
        // Вводим данные авторизации
        loginPage.login(USERNAME, PASSWORD);
        // Небольшое ожидание, чтобы страница успела прогрузиться
        Selenide.sleep(1000);
        // Подтверждаем логин
        loginPage.clickLoginButton();
        // Небольшое ожидание, чтобы страница успела прогрузиться
        Selenide.sleep(1000);
        // Убеждаемся, что мы НЕ вошли в систему
        Assertions.assertTrue(loginPage.getErrorField());
    }

    @Order(5)
    @DisplayName("Проверка авторизации с невалидным логином (!@#$) и валидным паролем.")
    @Test
    public void loginInvalidFieldUsernameTest() {
        // Определяем переменные данных авторизации
        USERNAME = "!@#$";
        PASSWORD = "boss";
        // Вводим данные авторизации
        loginPage.login(USERNAME, PASSWORD);
        // Небольшое ожидание, чтобы страница успела прогрузиться
        Selenide.sleep(1000);
        // Подтверждаем логин
        loginPage.clickLoginButton();
        // Небольшое ожидание, чтобы страница успела прогрузиться
        Selenide.sleep(1000);
        // Убеждаемся, что мы НЕ вошли в систему
        Assertions.assertEquals("Логин или пароль введены неправильно!", loginPage.getErrorMessage());
    }

    @Order(6)
    @DisplayName("Проверка авторизации с невалидным паролем (!@#$) и валидным логином.")
    @Test
    public void loginInvalidFieldPasswordTest() {
        // Определяем переменные данных авторизации
        USERNAME = "boss";
        PASSWORD = "!@#$";
        // Вводим данные авторизации
        loginPage.login(USERNAME, PASSWORD);
        // Небольшое ожидание, чтобы страница успела прогрузиться
        Selenide.sleep(1000);
        // Подтверждаем логин
        loginPage.clickLoginButton();
        // Небольшое ожидание, чтобы страница успела прогрузиться
        Selenide.sleep(1000);
        // Убеждаемся, что мы НЕ вошли в систему
        Assertions.assertEquals("Логин или пароль введены неправильно!", loginPage.getErrorMessage());
    }
}
