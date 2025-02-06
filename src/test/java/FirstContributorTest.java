import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstContributorTest {
    @BeforeAll
    static void BeforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void AndreiIsFirstContributorTest() {

        open("https://github.com/selenide/selenide");
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

        $("ul.list-style-none.flex-wrap.mb-n2").$("li").hover();
        $("[aria-label='User login and name']").shouldHave(text("Andrei Solntsev"));
    }
}
