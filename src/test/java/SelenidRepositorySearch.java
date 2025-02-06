import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenidRepositorySearch {

    @BeforeAll
    static void BeforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void SearchSelenidRepositoryTest() {

        open("https://github.com");
        $("#hero-section-brand-heading").shouldHave(text("Build and ship software on a single, collaborative platform"));

        $(byText("Search or jump to...")).click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
//        $("[data-testid='results-list']").$(".search-title").click();
        $("[data-testid='results-list'] h3").$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }
}