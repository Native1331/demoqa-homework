import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class FakerExamples {
    public static void main(String[] args) {
        Faker faker = new Faker();

        System.out.println(faker.aquaTeenHungerForce());
        System.out.println(faker.backToTheFuture());
        System.out.println(faker.lebowski().character());
        System.out.println(faker.lebowski().quote());
        System.out.println(faker.lebowski().actor());
        System.out.println(faker.business().creditCardNumber());
        System.out.println(faker.address().fullAddress());

        Faker fakerDE = new Faker(new Locale("de"));
        System.out.println(fakerDE.address().fullAddress());

        Faker fakerJa = new Faker(new Locale("ja"));
        System.out.println(fakerJa.address().fullAddress());
        Faker fakerRu = new Faker(new Locale("ru"));
        System.out.println(fakerRu.address().fullAddress());

    }
}
