package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    @Test
    // Проверка Yes
    public void verifyYesRadioButtonSelection() {
        String buttonName = "Yes";
        radioButtonPage.RadioButtonPageTransition();
        radioButtonPage.selectRadioButton(buttonName);
        Assert.assertEquals(radioButtonPage.getOutputMessage(), "You have selected " + buttonName, "Incorrect output for 'Yes' radio button.");
    }

    @Test
    // Проверка Impressive
    public void verifyImpressiveRadioButtonSelection() {
        String buttonName = "Impressive";
        radioButtonPage.RadioButtonPageTransition();
        radioButtonPage.selectRadioButton(buttonName);
        Assert.assertEquals(radioButtonPage.getOutputMessage(), "You have selected " + buttonName, "Incorrect output for 'Impressive' radio button.");
    }

    @Test
    // Проверка No
    public void verifyNoRadioButtonSelection() {
        String buttonName = "No";
        radioButtonPage.RadioButtonPageTransition();
        radioButtonPage.selectRadioButton(buttonName);
        Assert.assertFalse(radioButtonPage.isOutputVisible(), "Output is displayed for 'No' radio button.");
    }
}