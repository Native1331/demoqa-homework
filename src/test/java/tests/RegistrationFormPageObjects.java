package tests;

import Component.CalendarComponent;
import Component.GenderComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class RegistrationFormPageObjects {
    CalendarComponent calendar = new CalendarComponent();
    GenderComponent gender = new GenderComponent();

    //locators
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement setGenderInput =  $("#genterWrapper");
    SelenideElement setBirthDate = $("#dateOfBirthInput");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement hobbiesWrapperInput = $("#hobbiesWrapper");
    SelenideElement currentAddressInput = $("#currentAddress");
    SelenideElement uploadPicture = $("#uploadPicture");
    SelenideElement submitform = $("#submit");
    SelenideElement tableResponsive = $(".table-responsive");
    SelenideElement chooseState = $("#state");
    SelenideElement stateInput = $("#stateCity-wrapper");
    SelenideElement chooseCity=$("#city");
    SelenideElement cityInput = $("#stateCity-wrapper");


    //actions

    public RegistrationFormPageObjects openPage() {
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
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPageObjects setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationFormPageObjects setGender(String value) {
        setGenderInput.click();
        gender.setGender(value);
        return this;
    }

    public RegistrationFormPageObjects setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationFormPageObjects setBirthDate(String day, String month, String year) {
        setBirthDate.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPageObjects setSubjects(String value) {
        subjectsInput.val("Maths").pressEnter();;
        return this;
    }

    public RegistrationFormPageObjects setHobbies(String value) {
        hobbiesWrapperInput.$(byText("Reading")).click();
        return this;
    }

    public RegistrationFormPageObjects setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath("1.jpg");
        return this;
    }

    public RegistrationFormPageObjects setCurrentAddress(String value) {
        currentAddressInput.setValue(value).pressEnter();
        return this;
    }



    public RegistrationFormPageObjects setState(String value) {
        chooseState.click();
        $(byText(value)).click();

        return this;
    }
    public RegistrationFormPageObjects setCity (String value) {
        chooseCity.click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationFormPageObjects submit(String value) {
        submitform.click();
        return this;

    }
    public RegistrationFormPageObjects changeSize(Double value) {
          zoom(0.8);
            return this;}


    //Asserts id="example-modal-sizes-title-lg"
     public RegistrationFormPageObjects checkResult(String key, String value) {
        tableResponsive.$(byText(key)).parent().shouldHave(text(value));
        return this;}


        //we dont use it, only for example
        /**  public RegistrationFormPageObjects clearFirstName(String value) {
         firstNameInput.clear();
         return this;
         }**/

    }


