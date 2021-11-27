package com.bookovna.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;

public class RegistrationWithPageObjectTest extends TestBase {

    @Test
    void firstTest() {
        Faker faker = new Faker();
        String
                firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                mobileNumber = faker.number().digits(10),
                currentAddress = faker.address().streetAddress();

        int genderOther = 3,
                yearOfBirth = 1990,
                monthOfBirth = 7,
                dayOfBirth = 24;

        String monthOfBirthText = "July",
                hobbyReading = "Reading",
                state = "Uttar Pradesh",
                city = "Merrut";
        File userPic = new File("src/main/resources/userpic.jpg");

        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .chooseGender(genderOther)
                .setMobileNumber(mobileNumber)
                .setDateOfBirth(yearOfBirth, monthOfBirth, dayOfBirth)
                .fillSubjectsWithMath()
                .chooseHobbies(hobbyReading)
                .uploadFile(userPic)
                .setAddress(currentAddress, state, city)
                .submitForm();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", "Other")
                .checkResult("Mobile", mobileNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirthText + "," + yearOfBirth)
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", hobbyReading)
                .checkResult("Picture", "userpic.jpg")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }
}
