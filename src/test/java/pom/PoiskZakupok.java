package pom;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Модуль поиска закупок
 */
public class PoiskZakupok {

    // Открытие модуля на рабочем столе
    private final SelenideElement poiskZakupokOpen = $("#elasticsearch-shortcut");
    // Поле поиска по ключу
    private final SelenideElement searchField = $("[name='filterSearch']");
    // Поле поиска по региону
    private final SelenideElement regionField = $("[name='filterRegions']");
    // Кнопка поиска
    private final SelenideElement searchButton = $(".search24");
    // Кнопка Добавления найденной закупки в проекты
    private final SelenideElement addButton = $(".x-action-col-7");
    // Подтверждение добавления закупки в проекты
    private final SelenideElement acceptingButton = $("#ext-gen270");

    public void openPoiskZakupok() {
        poiskZakupokOpen.shouldBe(visible).click();
    }

    public void typeSearchKey(String searchKey) {
        searchField.shouldBe(visible).sendKeys(searchKey);
        searchField.shouldBe(visible).pressEnter();
    }

    public void typeRegionKey(String regionKey) {
        regionField.shouldBe(visible).sendKeys(regionKey);
        Selenide.sleep(1000);
        regionField.shouldBe(visible).pressEnter();
    }

    public void clickSearchButton() {
        searchButton.shouldBe(visible).click();
    }

    public void clickAddButton() {
        addButton.shouldBe(visible).click();
        Selenide.sleep(500);
        acceptingButton.shouldBe(visible).click();
        Selenide.sleep(1000);
        acceptingButton.shouldBe(visible).click();
    }
}
