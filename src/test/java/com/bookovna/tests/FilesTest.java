package com.bookovna.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FilesTest {

    @Test
    @DisplayName("Загрузка файла по относительному пути")
    void filenameShouldDisplayedAfterUploadActionFromClasspathTest() {
        open("https://ps.uci.edu/~franklin/doc/file_upload.html");
        $("input[type='file']").uploadFromClasspath("file.txt");
//        $("input[type='submit']").click();
        $("input[type='file']").shouldHave(text("file.txt"));
    }
}
