package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;
import pom.LoginPage;
import pom.MainPage;
import pom.PoiskZakupok;
import pom.TaskCalendar;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Epic("Тестирование веб-приложения МЭЛТОР")
@DisplayName("Проверка работы календаря задач")
public class TaskCalendarTest {

    private static LoginPage loginPage;
    private static MainPage mainPage;
    private static TaskCalendar taskCalendar;
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
        taskCalendar = Selenide.page(TaskCalendar.class);
    }

    /**
     * На всякий случай закрываем работу браузера
     */
    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @Order(1)
    @DisplayName("Завершение текущей задачи и постановка следующей задачи из цепочки.")
    @Test
    public void finishTask() {
        // Открываем Календарь задач
        taskCalendar.openTaskCalendar();
        // Клик на кнопку завершения задачи (открывается форма постановки другой задачи)
        taskCalendar.clickFinishTaskCheck();
        // Подтверждаем постановку новой задачи
        taskCalendar.clickConfirmNextTuskButton();
        Selenide.sleep(5000);
    }

    @Order(2)
    @DisplayName("Добавление новой задачи к проекту.")
    @Test
    public void addNewTask() {
        // Открываем Календарь задач
        taskCalendar.openTaskCalendar();
        // Клик на кнопку добавления задачи
        taskCalendar.clickAddTaskButton();
        // В открывшемся окне вводим название задачи
        taskCalendar.setNameOfNewTask("Test");
        // В открывшемся окне вводим ответственного
        taskCalendar.setWhoOfNewTask("Test");
        // Клик на кнопку Сохранить
        taskCalendar.clickSaveNewTask();
        Selenide.sleep(5000);
    }

    @Order(3)
    @DisplayName("Редактирование текущей задачи.")
    @Test
    public void updateTask() {
        // Открываем Календарь задач
        taskCalendar.openTaskCalendar();
        // Клик на кнопку редактирования задачи
        taskCalendar.editTask();
        // В открывшемся окне вводим новое название задачи
        taskCalendar.setNameOfNewTask("Test123");
        // Клик на кнопку Сохранить
        taskCalendar.clickSaveNewTask();
        Selenide.sleep(5000);
    }

    @Order(4)
    @DisplayName("Удаление задачи.")
    @Test
    public void deleteTask() {
        // Открываем Календарь задач
        taskCalendar.openTaskCalendar();
        // Клик на кнопку удаления задачи
        taskCalendar.clickDeleteTaskCheck();
        // Подтверждаем удаление
        taskCalendar.clickConfirmDeleteTask();
        Selenide.sleep(5000);
    }
}
