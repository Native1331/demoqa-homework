package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class RegistrationFormPageObjects {
    //locators
SelenideElement firstNameInput=$("#firstName");

    //actions

    public void openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPageObjects setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPageObjects setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public RegistrationFormPageObjects setEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public RegistrationFormPageObjects setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPageObjects checkResult(String key, String value) {
        $(".table-responsive").$(byText(key).
                parent().shouldHave(text(value)));
        return this;
    }
   //we dont use it, only for example
    public RegistrationFormPageObjects clearFirstName(String value) {
        firstNameInput.clear();
        return this;
    }


}
