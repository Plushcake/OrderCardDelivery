import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class OrderCardDeliveryTest {

    @Test
    public void orderCardTest() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $x("//input[@placeholder='Город']").setValue("Казань");
        $("[placeholder=\"Дата встречи\"]").click();
        $("[placeholder=\"Дата встречи\"]").setValue("05.08.2022");
        $x("//input[@name='name']").setValue("Пушкин Александр");
        $("[name=\"phone\"]").setValue("+79002223344");
        $("[data-test-id='agreement']").click();
        $("[class=\"button button_view_extra button_size_m button_theme_alfa-on-white\"]").click();
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));

    }
}
