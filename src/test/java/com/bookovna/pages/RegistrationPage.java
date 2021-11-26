package com.bookovna.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    // locators & elements
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            mobileNumberInput = $("#userNumber"),
            datePicker = $(".react-datepicker__input-container"),
            datePickerYear = $(".react-datepicker__year-select"),
            datePickerMonth = $(".react-datepicker__month-select"),
            subjectsInput = $("#subjectsInput"),

            resultsTable = $(".table-responsive");


    // actions
    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage chooseGender(int genderType) {
        $("label[for='gender-radio-" + genderType + "']").click();
        return this;
    }

    public RegistrationPage setMobileNumber(String value) {
        mobileNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(int year, int month, int day) {
        datePicker.click();
        datePickerYear.click();
        $("option[value='" + year + "']").click();
        datePickerMonth.click();
        $("option[value='" + (month - 1) + "']").click();
        $(".react-datepicker__day--0" + day).click();
        return this;
    }

    public RegistrationPage fillSubjectsWithMath() {
        subjectsInput.sendKeys("m");
        $(".subjects-auto-complete__menu-list #react-select-2-option-0").click();
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }
}
