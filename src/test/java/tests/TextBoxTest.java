package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TextBoxTest extends BaseTest {

    @Test
    //Проверка заполнения всех полей
    public void validateAllFieldsSubmission() {
        String userName = "Tsarev Vladimir";
        String email = "qwerty@gmail.com";
        String currentAddress = "Some current address";
        String permanentAddress = "Some permanent address";

        textBoxPage.TextBoxPageTransition();
        textBoxPage.enterDetails(userName, email, currentAddress, permanentAddress);
        textBoxPage.submitButton();

        String[] outputDataArray = textBoxPage.getOutputValues();
        String[] expectedOutputDataArray = textBoxPage.prepareExpectedOutput(userName, email, currentAddress, permanentAddress);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outputDataArray[0], expectedOutputDataArray[0], "Full Name output mismatch.");
        softAssert.assertEquals(outputDataArray[1], expectedOutputDataArray[1], "Email output mismatch.");
        softAssert.assertEquals(outputDataArray[2], expectedOutputDataArray[2], "Current Address output mismatch.");
        softAssert.assertEquals(outputDataArray[3], expectedOutputDataArray[3], "Permanent Address output mismatch.");
        softAssert.assertAll();
    }

    @Test
    //Проверка заполнения Части полей
    public void validatePartialFieldsSubmission() {
        String fullName = "Tsarev Vladimir";
        String email = "";
        String currentAddress = "Some current address";
        String permanentAddress = "";

        textBoxPage.TextBoxPageTransition();
        textBoxPage.enterDetails(fullName, email, currentAddress, permanentAddress);
        textBoxPage.submitButton();

        String[] outputDataArray = textBoxPage.getOutputValues();
        String[] expectedOutputDataArray = textBoxPage.prepareExpectedOutput(fullName, email, currentAddress, permanentAddress);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(outputDataArray[0], expectedOutputDataArray[0], "Full Name output mismatch.");
        softAssert.assertEquals(outputDataArray[1], expectedOutputDataArray[1], "Email output mismatch.");
        softAssert.assertEquals(outputDataArray[2], expectedOutputDataArray[2], "Current Address output mismatch.");
        softAssert.assertEquals(outputDataArray[3], expectedOutputDataArray[3], "Permanent Address output mismatch.");
        softAssert.assertAll();
    }
}