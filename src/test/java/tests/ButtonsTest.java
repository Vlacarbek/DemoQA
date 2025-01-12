package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    @Test
    // Проверка DoubleClick
    public void checkButtonsDoubleClickMe() {
        buttonsPage.ButtonsPageTransition();
        buttonsPage.clickButton("Double Click Me", "Double click");
        Assert.assertTrue(buttonsPage.isClickOutputDisplayed("Double Click Me"), "Double click output not displayed");
    }

    @Test
    // Проверка RightClick
    public void checkButtonsRightClickMe() {
        buttonsPage.ButtonsPageTransition();
        buttonsPage.clickButton("Right Click Me", "Right click");
        Assert.assertTrue(buttonsPage.isClickOutputDisplayed("Right Click Me"), "Right click output not displayed");
    }

    @Test
    // Проверка Click
    public void checkButtonsClickMeTest() {
        buttonsPage.ButtonsPageTransition();
        buttonsPage.clickButton("Click Me", "Left click");
        Assert.assertTrue(buttonsPage.isClickOutputDisplayed("Click Me"), "Left click output not displayed");
    }
}