import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class SelenideGitHubTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        System.out.println("Конфигурация теста установлена");
    }

    @DisplayName("Проверка документации Selenide на сайте Github.com")
    @Test
    public void gitHubTest() {

        //Открываем страницу Selenide на ГитХабе
        Selenide.open("/selenide/selenide");

        //Открываем раздел Wiki
        $("#wiki-tab").click();

        //Раскрываем список страниц (Pages) полностью, чтобы были видны все страницы
        $(".wiki-rightbar").$$("li").last().$("button").click();

        //Проверяем, что в разделе Pages есть страница SoftAssertions, открываем ее
        $(".wiki-rightbar").$(byText("SoftAssertions")).click();

        //проверяем, что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
