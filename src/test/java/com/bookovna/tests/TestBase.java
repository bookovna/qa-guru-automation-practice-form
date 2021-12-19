package com.bookovna.tests;

import com.bookovna.pages.RegistrationPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @AfterEach
    void closeWebDriver() {
        Selenide.closeWebDriver();
    }
}
