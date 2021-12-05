package com.bookovna.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepLambdaTest {

    private static final String ALLURE_REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 68;

    private SelenideElement searchInput = $(".header-search-input");

    @Test
    public void testGithub() {
        step("Открываем главную страницу гита", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + ALLURE_REPOSITORY, () -> {
            searchInput.click();
            searchInput.sendKeys(ALLURE_REPOSITORY);
            searchInput.submit();
        });

        step("Переходим в репозиторий " + ALLURE_REPOSITORY, () -> {
            $(linkText(ALLURE_REPOSITORY)).click();
        });

        step("Открываем таб Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Проверяем, что существует Issue с номером " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
        });
    }
}
