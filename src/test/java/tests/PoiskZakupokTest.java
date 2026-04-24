package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;
import pom.LoginPage;
import pom.MainPage;
import pom.PoiskZakupok;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Epic("Тестирование веб-приложения МЭЛТОР")
@DisplayName("Проверка добавления проекта из поиска закупок")
public class PoiskZakupokTest {

    // Инициализируем страницы, с которыми будем работать
    private static LoginPage loginPage;
    private static MainPage mainPage;
    private static PoiskZakupok poiskZakupok;
    // Определяем данные для входа
    private static String USERNAME = "boss";
    private static String PASSWORD = "boss";

    /**
     * Настройка перед каждым тестом
     */
    @BeforeEach
    public void setupTest() {
        Selenide.open("https://alekrashgmail4.meltor.ru/");
        loginPage = Selenide.page(LoginPage.class);
        loginPage.login(USERNAME, PASSWORD);
        loginPage.clickLoginButton();
        mainPage = Selenide.page(MainPage.class);
        mainPage.clickCloseAnnoyingWindowButton();
        mainPage.clickWarningNoVideoSetNo();
        poiskZakupok = Selenide.page(PoiskZakupok.class);
    }

    /**
     * На всякий случай закрываем работу браузера
     */
    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @Order(1)
    @DisplayName("Проверка добавления проекта из поиска закупок без добавления фильтров.")
    @Test
    void addProjectFromPoiskZakupokEmptyKeys() {
        // Открываем модуль поиска закупок
        poiskZakupok.openPoiskZakupok();
        Selenide.sleep(1000);
        // Клик на кнопку поиска
        poiskZakupok.clickSearchButton();
        Selenide.sleep(1000);
        // Клик на кнопку добавления проекта (подтверждение добавления зашито в метод)
        poiskZakupok.clickAddButton();
        Selenide.sleep(5000);

    }

    @Order(2)
    @DisplayName("Проверка добавления проекта из поиска закупок с добавлением поиска по ключу «Строительство».")
    @Test
    void addProjectFromPoiskZakupokWithSearchKey() {
        // Открываем модуль поиска закупок
        poiskZakupok.openPoiskZakupok();
        Selenide.sleep(1000);
        // Вводим ключ для поиска
        poiskZakupok.typeSearchKey("Строительство");
        Selenide.sleep(1000);
        // Клик на кнопку поиска
        poiskZakupok.clickSearchButton();
        Selenide.sleep(1000);
        // Клик на кнопку добавления проекта (подтверждение добавления зашито в метод)
        poiskZakupok.clickAddButton();
        Selenide.sleep(5000);
    }

    @Order(3)
    @DisplayName("Проверка добавления проекта из поиска закупок с добавлением поиска по Региону (городу) «Центральный ФО».")
    @Test
    void addProjectFromPoiskZakupokWithCity() {
        // Открываем модуль поиска закупок
        poiskZakupok.openPoiskZakupok();
        Selenide.sleep(1000);
        // Вводим ключ для поиска
        poiskZakupok.typeRegionKey("Центральный ФО");
        Selenide.sleep(1000);
        // Клик на кнопку поиска
        poiskZakupok.clickSearchButton();
        Selenide.sleep(1000);
        // Клик на кнопку добавления проекта (подтверждение добавления зашито в метод)
        poiskZakupok.clickAddButton();
        Selenide.sleep(5000);
    }

    @Order(4)
    @DisplayName("Проверка добавления проекта из поиска закупок с добавлением поиска по Региону (городу) «Центральный ФО».")
    @Test
    void addProjectFromPoiskZakupokWithKeyAndCity() {
        // Открываем модуль поиска закупок
        poiskZakupok.openPoiskZakupok();
        Selenide.sleep(1000);
        // Вводим ключ для поиска
        poiskZakupok.typeSearchKey("Строительство");
        Selenide.sleep(1000);
        // Вводим ключ для поиска
        poiskZakupok.typeRegionKey("Центральный ФО");
        Selenide.sleep(1000);
        // Клик на кнопку поиска
        poiskZakupok.clickSearchButton();
        Selenide.sleep(1000);
        // Клик на кнопку добавления проекта (подтверждение добавления зашито в метод)
        poiskZakupok.clickAddButton();
        Selenide.sleep(5000);
    }
}
