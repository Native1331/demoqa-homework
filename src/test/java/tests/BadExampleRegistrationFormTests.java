package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BadExampleRegistrationFormTests {
    RegistrationFormPageObjects registrationFormPageObjects=new RegistrationFormPageObjects();


    //locators
   String firstNameInput = "#firstName";

    //actions



    public RegistrationFormPageObjects setFirstName(String value) {
        $(firstNameInput).setValue(value);
        return this;
    }

   
    }
    //we dont use it, only for example
    public RegistrationFormPageObjects clearFirstName(String value) {
        firstNameInput.clear();
        return this;
    }


}