package com.bookovna;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideRepo {

    @Test
    void shouldFindSelenideRepoInGitHub() {
        open("https://github.com/");

        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $$(".repo-list li").first().$("a").click();

        $("[data-content=Wiki]").click();
        $(".f6.js-wiki-more-pages-link").click();

        $(".Box.Box--condensed").$("[href=\"/selenide/selenide/wiki/SoftAssertions\"]").click();

        $$(".markdown-body ol")
                .shouldHave(CollectionCondition.containExactTextsCaseSensitive("Using JUnit5 extend test class:"));
    }
}
