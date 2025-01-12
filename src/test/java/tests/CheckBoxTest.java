package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckBoxTest extends BaseTest {

    @Test
    // Проверка на открытие-раскрытие чекбоксов
    public void testExpandAndCollapseAll() {
        SoftAssert softAssert = new SoftAssert();

        checkBoxPage.CheckBoxPageTransition();
        checkBoxPage.clickExpandAll();

        String[] allCheckBoxes = {"Home", "Desktop", "Notes", "Commands", "Documents", "WorkSpace", "React", "Angular", "Veu", "Office", "Public", "Private", "Classified", "General", "Downloads", "Word File.doc", "Excel File.doc"};
        softAssert.assertTrue(checkBoxPage.areCheckBoxesVisible(allCheckBoxes), "Root checkbox is not visible after collapsing.");

        checkBoxPage.clickCollapseAll();
        String[] rootCheckBox = {"Home"};
        softAssert.assertTrue(checkBoxPage.areCheckBoxesVisible(rootCheckBox), "Root checkbox is not visible after collapsing.");

        softAssert.assertAll();
    }

    @Test
    // Проверка вывода после нажатия на Home
    public void testSelectHomeCheckBox() {
        String[] checkBoxesToSelect = {"Home"};
        String[] expectedOutput = {"home", "desktop", "notes", "commands", "documents", "workspace", "react", "angular", "veu", "office", "public", "private", "classified", "general", "downloads", "wordFile", "excelFile"};

        checkBoxPage.CheckBoxPageTransition();
        checkBoxPage.selectCheckBoxes(checkBoxesToSelect);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkBoxPage.areCheckBoxesVisible(expectedOutput), "Output does not match expected values.");
        softAssert.assertEquals(checkBoxPage.getCountOfCheckedOutputs(), expectedOutput.length, "The number of outputs does not match expected.");
        softAssert.assertAll();
    }
}