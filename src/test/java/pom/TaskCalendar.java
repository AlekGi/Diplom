package pom;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Календарь задач
 */
public class TaskCalendar {

    // Открытие календаря задач на рабочем столе
    private final SelenideElement taskCalendarOpen = $("#calendar-tasks-shortcut");
    // Кнопка добавления новой задачи
    private final SelenideElement addTaskButton =$(".x-btn-text.add");
    // Ввод названия новой задачи
    private final SelenideElement taskInputField =$("[name='name']");
    // Ввод исполнителя по задаче
    private final SelenideElement whoInputChoose =$("x-form-text.x-form-field");
    // Сохранение изменений
    private final SelenideElement saveNewTask =$(".save");
    // Завершение текущей задачи
    private final SelenideElement finishTaskCheck =$(".x-grid3-check-col");
    // Подтверждение следующего этапа выполнения проекта (новая задача)
    private final SelenideElement confirmNextTuskButton =$(".check");
    // Удаление задачи
    private final SelenideElement deleteTaskCheck =$(".delete");
    // Подтверждение удаления
    private final SelenideElement confirmDeleteTask =$(byText("Да"));
    // Редактирование задачи
    private final SelenideElement editTask =$(".x-action-col-1.edit");

    public void openTaskCalendar() {
        taskCalendarOpen.click();
        Selenide.sleep(5000);
    }

    public void clickAddTaskButton()
    {
        addTaskButton.shouldBe(visible).click();
    }

    public void setNameOfNewTask(String taskName)
    {
        taskInputField.shouldBe(visible).sendKeys(taskName);
    }

    public void setWhoOfNewTask(String who)
    {
        whoInputChoose.shouldBe(visible).sendKeys(who);
        Selenide.sleep(2000);
    }

    public void clickSaveNewTask()
    {
        saveNewTask.shouldBe(visible).click();
    }

    public void clickFinishTaskCheck()
    {
        finishTaskCheck.shouldBe(visible).click();
        Selenide.sleep(5000);
    }

    public void clickConfirmNextTuskButton()
    {
        confirmNextTuskButton.shouldBe(visible).click();
    }

    public void clickDeleteTaskCheck()
    {
        deleteTaskCheck.shouldBe(visible).click();
        Selenide.sleep(3000);
    }

    public void clickConfirmDeleteTask()
    {
        confirmDeleteTask.shouldBe(visible).click();
    }

    public void editTask(){
        editTask.shouldBe(visible).click();
        Selenide.sleep(3000);
    }

}
