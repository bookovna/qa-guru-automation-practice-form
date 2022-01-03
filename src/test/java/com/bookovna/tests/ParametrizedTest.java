package com.bookovna.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParametrizedTest {

    SelenideElement essayNamePlace = $("div[style='line-height:1.4; font-size:120%;'] > p");
    String bookLink = "https://en.wikisource.org/wiki/The_Genealogy_of_Morals";

    static Stream<Arguments> nietzscheCheckTextStream() {
        return Stream.of(
                Arguments.of("First Essay", "FIRST ESSAY"),
                Arguments.of("Second Essay", "SECOND ESSAY"),
                Arguments.of("Third Essay", "THIRD ESSAY")
        );
    }

    @Tag("medium")
    @DisplayName("Заголовок на странице эссе соответствует названию эссе в оглавлении, MethodSource")
    @MethodSource
    @ParameterizedTest
    void nietzscheCheckTextStream(String essay, String essayName) {
        open(bookLink);
        $(byText(essay)).click();
        essayNamePlace.should(Condition.text(essayName));
    }

    @CsvSource({
            "First Essay, FIRST ESSAY",
            "Second Essay, SECOND ESSAY",
            "Third Essay, THIRD ESSAY"
    })
    @Tag("medium")
    @DisplayName("Заголовок на странице эссе соответствует названию эссе в оглавлении, CsvSource")
    @ParameterizedTest
    void nietzscheCheckTextCSVSource(String essay, String essayName) {
        open(bookLink);
        $(byText(essay)).click();
        essayNamePlace.should(Condition.text(essayName));
    }

    @CsvFileSource(resources = "/nietzsche.csv")
    @Tag("medium")
    @DisplayName("Заголовок на странице эссе соответствует названию эссе в оглавлении, Csv file source")
    @ParameterizedTest
    void nietzscheCheckTextCSVFileSource(String essay, String essayName) {
        open(bookLink);
        $(byText(essay)).click();
        essayNamePlace.should(Condition.text(essayName));
    }

    @CsvSource(value = {
            "First Essay | FIRST ESSAY",
            "Second Essay | SECOND ESSAY",
            "Third Essay | THIRD ESSAY"
    },
    delimiter = '|')
    @Tag("medium")
    @DisplayName("Заголовок на странице эссе соответствует названию эссе в оглавлении, CsvSource with delimiter")
    @ParameterizedTest
    void nietzscheCheckTextCSVSourceUsingDelimiter(String essay, String essayName) {
        open(bookLink);
        $(byText(essay)).click();
        essayNamePlace.should(Condition.text(essayName));
    }

    @EnumSource(SearchQuery.class)
    @Tag("medium")
    @DisplayName("Заголовок на странице эссе соответствует названию эссе в оглавлении, Enum Source")
    @ParameterizedTest
    void nietzscheCheckTextEnumSource(SearchQuery number) {
        open(bookLink);
        String essayNumber = StringUtils.capitalize(number.toString().toLowerCase()) + " Essay";
        $(byText(essayNumber)).click();
        essayNamePlace.should(Condition.text(essayNumber));
    }

    @ValueSource(strings = {
            "First Essay",
            "Second Essay",
            "Third Essay"
    })
    @Tag("medium")
    @DisplayName("Заголовок на странице {0} соответствует названию эссе в оглавлении, ValueSource")
    @ParameterizedTest
    void nietzscheCheckTextValueSource(String essay) {
        open(bookLink);
        $(byText(essay)).click();
        essayNamePlace.should(Condition.text(essay));
    }
}
