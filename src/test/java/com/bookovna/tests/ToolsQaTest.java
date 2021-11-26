package com.bookovna.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ToolsQaTest extends TestBase {

    @AfterAll
    static void afterAll() {
        System.out.println("This is the after all method");
    }

    @BeforeEach
    void openPracticeForm() {
        open("https://demoqa.com/automation-practice-form");
    }

    @AfterEach
    void closeWebDriver() {
        Selenide.closeWebDriver();
    }

    @Test
    void firstTest() {

        String firstName = "Jane";
        String lastName = "Smith";
        String email = "example@email.com";
        String mobileNumber = "1234567890";
        File userPic = new File("src/main/resources/userpic.jpg");
        String currentAddress = "Street street, building 13";
        String state = "Uttar Pradesh";
        String city = "Merrut";


        $("input[id='firstName']").setValue(firstName);
        $("input[id='lastName']").setValue(lastName);
        $("input[id='userEmail']").setValue(email);
        $("label[for='gender-radio-3']").click();
        $("input[id='userNumber']").setValue(mobileNumber);

        $(".react-datepicker__input-container").click();
        $(".react-datepicker__year-select").click();
        $("option[value='1990']").click();
        $(".react-datepicker__month-select").click();
        $("option[value='6']").click();
        $(".react-datepicker__day--024").click();


        $("#subjectsInput").sendKeys("m");
        $(".subjects-auto-complete__menu-list #react-select-2-option-0").click();


        $$("label[for^=hobbies-checkbox]").find(text("Reading")).scrollIntoView(true).click();
        $("input[id='uploadPicture']").uploadFile(userPic);

        $("#currentAddress.form-control").setValue(currentAddress);

        $$(".css-1wa3eu0-placeholder").find(text("Select State")).scrollIntoView(true).click();
        $$(".css-yt9ioa-option").find(text(state)).click();

        $$(".css-1wa3eu0-placeholder").find(text("Select City")).click();
        $$(".css-yt9ioa-option").find(text(city)).click();


        $("#submit").scrollIntoView(true).click();

        $(".table tr", 1).shouldHave(text("Student Name"), text(firstName + " " + lastName));
        $(".table tr", 2).shouldHave(text("Student Email"), text(email));
        $(".table tr", 3).shouldHave(text("Gender"), text("Other"));
        $(".table tr", 4).shouldHave(text("Mobile"), text(mobileNumber));
        $(".table tr", 5).shouldHave(text("Date of Birth"), text("24 July,1990"));
        $(".table tr", 6).shouldHave(text("Subjects"), text("Maths"));
        $(".table tr", 7).shouldHave(text("Hobbies"), text("Reading"));
        $(".table tr", 8).shouldHave(text("Picture"), text("userpic.jpg"));
        $(".table tr", 9).shouldHave(text("Address"), text(currentAddress));
        $(".table tr", 10).shouldHave(text("State and City"), text(state + " " + city));

    }

}
