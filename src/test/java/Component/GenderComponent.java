package Component;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GenderComponent {
      public void setGender(String gender) {
          $("#genterWrapper").$(byText("Male")).click();
        }
    }

