package com.bookovna.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
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
            pictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress.form-control"),
            submitButton = $("#submit"),
            resultsTable = $(".table-responsive");

    private ElementsCollection
            hobbiesCheckboxes = $$("label[for^=hobbies-checkbox]"),
            stateAndCityMenu = $$(".css-1wa3eu0-placeholder"),
            stateAndCityOptions = $$(".css-yt9ioa-option");

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

    public RegistrationPage chooseHobbies(String value) {
        hobbiesCheckboxes.find(text(value)).scrollIntoView(true).click();
        return this;
    }

    public RegistrationPage uploadFile(File file) {
        pictureInput.uploadFile(file);
        return this;
    }

    public RegistrationPage setAddress(String currentAddress, String state, String city) {
        currentAddressInput.setValue(currentAddress);

        stateAndCityMenu.find(text("Select State")).scrollIntoView(true).click();
        stateAndCityOptions.find(text(state)).click();

        stateAndCityMenu.find(text("Select City")).click();
        stateAndCityOptions.find(text(city)).click();
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.scrollIntoView(true).click();
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }
}
