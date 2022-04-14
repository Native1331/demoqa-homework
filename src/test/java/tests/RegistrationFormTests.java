package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class RegistrationFormTests {
    RegistrationFormPageObjects registrationFormPageObjects=new RegistrationFormPageObjects();


        @BeforeAll
        static void setUp() {
            Configuration.holdBrowserOpen = true;
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.browserSize = "1900x1080";
        }

        @Test
        void fillFormTest() {

             registrationFormPageObjects.openPage()
                         .setFirstName("Barak")
                         .setLastName("Obama")
                         .setEmail("Barak@Obama.com")
                         .setGender("Other");

            $("#userNumber").setValue("8931311123");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("June");
            $(".react-datepicker__year-select").selectOption("1955");
            $(".react-datepicker__day--013").click();
            $("#subjectsInput").val("Math").pressEnter();
            $("#hobbiesWrapper").$(byText("Reading")).click();
            $("#uploadPicture").uploadFromClasspath("1.jpg");
            $("#currentAddress").setValue("190000, Russia, Saint-Petersburg, Perfect Street, 1");
            zoom(0.8);
            $("#state").scrollIntoView(true).click();
            $(byTagAndText("div", "NCR")).click();
            $("#city").click();
            $(byTagAndText("div","Delhi")).click();
            $("#submit").click();

            //Asserts
            $(".#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting "));
           .checkResult("Student Name", "Obama Barak");
           .checkResult("Student Email", "Barak@Obama.com");
            .checkResult("Gender", "Other");

        }

