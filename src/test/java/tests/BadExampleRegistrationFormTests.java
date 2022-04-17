package tests;

import static com.codeborne.selenide.Selenide.*;

public class BadExampleRegistrationFormTests {
    RegistrationFormPageObjects registrationFormPageObjects = new RegistrationFormPageObjects();


    //locators
    String firstNameInput = "#firstName";

    //actions


    public BadExampleRegistrationFormTests setFirstName(String value) {
        $(firstNameInput).setValue(value);
        return this;
    }
}




