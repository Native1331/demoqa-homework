package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWindow;
import static java.lang.String.format;


public class TestwithFaker {
    RegistrationFormPageObjects registrationFormPageObjects = new RegistrationFormPageObjects();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            Email = faker.internet().emailAddress(),
            currentAddress = faker.address().streetAddressNumber();
    String expectedFullname = format("%s %s",firstName,lastName);

    @BeforeAll
     static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1900x1080";
    }

    @AfterAll
    public static void closeTheWindow() {
        closeWindow();
    }

    @AfterEach
    void statusOfTests() {
        System.out.println("Tests passed");
    }

    @Test
    void fillFormTest() {
        registrationFormPageObjects.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(Email)
                .setGender("Male")
                .setUserNumber("8911111111")
                .setBirthDate("13", "June", "1955")
                .setSubjects("Maths")
                .setHobbies("Reading")
                .setUploadPicture("1.jpg")
                .setCurrentAddress(currentAddress)
                .changeSize(0.8)
                .setState("NCR")
                .setCity("Delhi")
                .submitform.click();
        registrationFormPageObjects.checkResult("Student Name", expectedFullname)
                .checkResult("Student Email", Email)
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "Mobile 8911111111")
                .checkResult("Date of Birth", "Date of Birth 13 June,1955")
                .checkResult("Subjects", "Math")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "1.jpg")
                .checkResult("Address",currentAddress)
                .checkResult("State and City", "NCR Delhi");

    }
}


