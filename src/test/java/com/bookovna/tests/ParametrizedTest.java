package com.bookovna.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class ParametrizedTest {

    @Test
    void nietzscheCheckText() {
        open("https://en.wikisource.org/wiki/The_Genealogy_of_Morals");
        $(byText("First Essay")).click();

        assertThat($(byCssSelector("div[style='line-height:1.4; font-size:120%;']")).lastChild().getText().contains("I."));
    }

    static Stream<Arguments> nietzscheCheckTextParametrized() {
        return Stream.of(
                Arguments.of("First Essay", "I."),
                Arguments.of("Second Essay", "II."),
                Arguments.of("Third Essay", "III.")
        );
    }

    @MethodSource
    @ParameterizedTest
    void nietzscheCheckTextParametrized(String essay, String essayNumber) {
        open("https://en.wikisource.org/wiki/The_Genealogy_of_Morals");
        $(byText("First Essay")).click();

        assertThat($(byCssSelector("div[style='line-height:1.4; font-size:120%;']")).lastChild().getText().contains("I."));
    }
}
