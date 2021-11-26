package com.bookovna.tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationWithPageObjectTest extends TestBase {

    @Test
    void firstTest() {

        String firstName = "Jane";
        String lastName = "Smith";
        String email = "example@email.com";
        int genderOther = 3;
        String mobileNumber = "1234567890";
        int yearOfBirth = 1990;
        int monthOfBirth = 7;
        int dayOfBirth = 24;
        String hobby = "Reading";
        File userPic = new File("src/main/resources/userpic.jpg");
        String currentAddress = "Street street, building 13";
        String state = "Uttar Pradesh";
        String city = "Merrut";

        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .chooseGender(genderOther)
                .setMobileNumber(mobileNumber)
                .setDateOfBirth(yearOfBirth, monthOfBirth, dayOfBirth)
                .fillSubjectsWithMath();

        $$("label[for^=hobbies-checkbox]").find(text("Reading")).scrollIntoView(true).click();
        $("input[id='uploadPicture']").uploadFile(userPic);

        $("#currentAddress.form-control").setValue(currentAddress);

        $$(".css-1wa3eu0-placeholder").find(text("Select State")).scrollIntoView(true).click();
        $$(".css-yt9ioa-option").find(text(state)).click();

        $$(".css-1wa3eu0-placeholder").find(text("Select City")).click();
        $$(".css-yt9ioa-option").find(text(city)).click();


        $("#submit").scrollIntoView(true).click();
        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", "Other")
                .checkResult("Mobile", mobileNumber)
                .checkResult("Date of Birth", dayOfBirth + " July," + yearOfBirth)
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", "userpic.jpg")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }
}
