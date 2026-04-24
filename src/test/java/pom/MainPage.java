package pom;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Главная страница (рабочий стол)
 */
public class MainPage {

    // закрыть всплывающую подсказку с обучающим видео
    private final SelenideElement closeAnnoyingWindowButton =$("#ext-gen206");
    // подтвердить, что хотим показывать обучающие видео в следующий раз
    private final SelenideElement warningNoVideoSetNo =$("#ext-comp-1133");


    public void clickCloseAnnoyingWindowButton() {
        closeAnnoyingWindowButton.shouldBe(visible).click();
    }

    public void clickWarningNoVideoSetNo() {
        warningNoVideoSetNo.shouldBe(visible).click();
    }
}
