package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class TestPracticeForm {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1900x1080";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Barak");
        $("#lastName").setValue("Obama");
        $("#userEmail").setValue("barakobama.com");
        $("[class=custom-control-label]").click();
        $("#userNumber").setValue("8931311123");
        $("#dateOfBirthInput").setValue("01.01.1970");
        $(".react-datepicker__day--selected").click();
        $("[id=subjectsContainer]").setValue("Politics");

        $("[class=custom-control-label]").click();
        //       $("#userNumber").setValue();
        //       $("#userNumber").setValue();
        //Asserts
    }

}
