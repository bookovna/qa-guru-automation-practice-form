package com.bookovna.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParametrizedTest {

    static Stream<Arguments> nietzscheCheckTextParametrized() {
        return Stream.of(
                Arguments.of("First Essay", "FIRST ESSAY"),
                Arguments.of("Second Essay", "SECOND ESSAY"),
                Arguments.of("Third Essay", "THIRD ESSAY.")
        );
    }

    @MethodSource
    @ParameterizedTest
    void nietzscheCheckTextParametrized(String essay, String essayName) {
        open("https://en.wikisource.org/wiki/The_Genealogy_of_Morals");
        $(byText(essay)).click();

        $("div[style='line-height:1.4; font-size:120%;'] > p").should(Condition.text(essayName));
    }
}
