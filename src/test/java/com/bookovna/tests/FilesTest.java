package com.bookovna.tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilesTest {

    @Test
    @DisplayName("После загрузки JPG файла на сайте отображается название файла")
    void fileNameIsDisplayedAfterUploadAction() {
        open("https://www.west-wind.com/wconnect/wcscripts/fileupload.wwd");
        $("input[type='file']").uploadFromClasspath("photo_qa_guru_test.jpg");
        $("div[id='filename']").shouldHave(text("photo_qa_guru_test.jpg"));
    }

    @Test
    @DisplayName("Скачанный PDF файл имеет ожидаемое количество страниц")
    void downloadedPdfFileHasCorrectAmountOfPages() throws IOException {
        open("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
        File pdfFile = $(byText("Download sample pdf file")).download();
        PDF parsedPdf = new PDF(pdfFile);

        assertEquals(4, parsedPdf.numberOfPages);
    }

    @Test
    @DisplayName("Скачанный docx файл")
    void downloadedDocxFile() {
        open("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");

    }
}
