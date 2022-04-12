import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {

        @BeforeAll
        static void setUp() {
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.browserSize = "1900x1080";
        }

        @Test
        void fillFormTest() {
            String name=("Alex Egorov");
            open("/automation-practice-form");
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#fixedban').remove()");
            $("#firstName").setValue("Barak");
            $("#lastName").setValue("Obama");
            $("#userEmail").setValue("Barak@Obama.com");
            $("#genterWrapper").$(byText("Male")).click();
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
            $(".table-responsive").shouldHave(
                    text("Barak" +" "+ "Obama"),
                    text ("Barak@Obama.com"),
                    text("8931311123"),
                    text ("Male"),
                    text ("8931311123"),
                    text ("13 June,1955"),
                    text ("Reading"),
                    text ("1.jpg"),
                    text ("190000, Russia, Saint-Petersburg, Perfect Street, 1"),
                    text ("NCR" +" "+ "Delhi"));
        }
    }


