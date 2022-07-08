import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SelenideDrugAndDropTest {

    @DisplayName("Поменять квадраты местами,используя actions()")
    @Test
    @Disabled
    public void dragAndDropTestwithActions() {

        Selenide.open("https://the-internet.herokuapp.com/drag_and_drop");

        //перетаскиваем левый квадрат А на место правого квадрата B
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b"))
                 .release().perform();

        //проверяем, что квадраты поменялись (по тексту внутри фигуры)
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @DisplayName("Поменять квадраты местами через перетаскивание")
    @Test
    public void dragAndDropTest() {

        Selenide.open("https://the-internet.herokuapp.com/drag_and_drop");

        //перетаскиваем левый квадрат А на место правого квадрата B
        $("#column-a").dragAndDropTo($("#column-b"));

        //проверяем, что квадраты поменялись (по тексту внутри фигуры)
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
