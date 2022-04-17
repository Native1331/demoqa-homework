package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.awt.SystemColor.WINDOW;
import static java.awt.SystemColor.text;
import static java.lang.String.format;
import static org.openqa.selenium.devtools.v85.page.Page.close;
import static org.openqa.selenium.devtools.v85.page.Page.javascriptDialogClosed;


public class RegistrationFormTests {
    RegistrationFormPageObjects registrationFormPageObjects = new RegistrationFormPageObjects();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration. baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1900x1080";
    }
    @AfterAll
    public static void closeTheWindow() {
        closeWindow();
    }

    @AfterEach
    public void statusOfTests(){
        System.out.println("Tests passed");
    }
    @Test
    void fillFormTest() {
        registrationFormPageObjects.openPage()
                .setFirstName("Barak")
                .setLastName("Obama")
                .setEmail("Barak@Obama.com")
                .setGender("Male")
                .setUserNumber("8911111111")
                .setBirthDate("13", "June", "1955")
                .setSubjects("Maths")
                .setHobbies("Reading")
                .setUploadPicture("1.jpg")
                .setCurrentAddress("190000, Russia, Saint-Petersburg, " +
                        "Perfect Street, 1")
                .changeSize(0.8)
                .setState("NCR")
                .setCity("Delhi")
                .submitform.click();
        registrationFormPageObjects .checkResult("Student Name", "Barak Obama")
                 .checkResult("Student Email", "Barak@Obama.com")
                 .checkResult("Gender", "Male")
                .checkResult("Mobile","Mobile 8911111111")
                 .checkResult("Date of Birth", "Date of Birth 13 June,1955")
                 .checkResult("Subjects", "Math")
                 .checkResult("Hobbies", "Reading")
                 .checkResult("Picture", "1.jpg")
                 .checkResult("Address", "190000, Russia, Saint-Petersburg, " +
                           "Perfect Street, 1")
                 .checkResult("State and City", "NCR Delhi");

        }
    }


