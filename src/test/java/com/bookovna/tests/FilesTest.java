package com.bookovna.tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @DisplayName("Скачанный txt файл содержит ожидаемый текст")
    void downloadedTextFileContainsCorrectText() throws IOException {
        open("https://filesamples.com/formats/txt");
        File file = $("a[class='btn btn-primary pull-right']").download();
        String fileContent = IOUtils.toString(new FileReader(file));

        assertTrue(fileContent.contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit"));
    }

    @Test
    @DisplayName("Скачанный xls файл содержит в определенной ячейке ожидаемый текст")
    void downloadedXlsFile() throws IOException {
        open("https://filesamples.com/formats/xls");
        File file = $("a[class='btn btn-primary pull-right']").download();
        XLS parsedXls = new XLS(file);
        boolean checkPassed = parsedXls.excel
                .getSheetAt(0)
                .getRow(2)
                .getCell(1)
                .getStringCellValue()
                .equals("February");

        assertTrue(checkPassed);
    }

    @Test
    @DisplayName("CSV файл имеет ожидаемое количество строк")
    void parseCsvFile() throws IOException, CsvException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream("cats.csv");
             Reader reader = new InputStreamReader(is)) {
            CSVReader csvReader = new CSVReader(reader);

            List<String[]> strings = csvReader.readAll();
            assertEquals(4, strings.size());
        }
    }

    @Test
    @DisplayName("ZIP содержит файл с ожидаемым названием")
    void parseZipFileTest() throws IOException, CsvException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream("test.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println(entry.getName());
                assertThat(zis.getNextEntry().getName().contains("baisy.JPG"));
            }
        }
    }
}
