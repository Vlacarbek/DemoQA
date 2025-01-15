package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage {

    WebDriver driver;

    By TextBoxFullName = By.xpath("//input[@id='userName']");
    By TextBoxEmail = By.xpath("//input[@id='userEmail']");
    By TextBoxCurrentAddress = By.xpath("//textarea[@id='currentAddress']");
    By TextBoxPermanentAddress = By.xpath("//textarea[@id='permanentAddress']");
    By TextBoxSubmit = By.cssSelector("[id=submit]");
    By fullNameOutput = By.xpath("//p[@id='name']");
    By emailOutput = By.xpath("//p[@id='email']");
    By currentAddressOutput = By.xpath("//p[@id='currentAddress']");
    By permanentAddressOutput = By.xpath("//p[@id='permanentAddress']");

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void TextBoxPageTransition() {
        driver.get("https://demoqa.com/text-box");
    }

    public void enterDetails(String userName, String email, String current, String permanent) {
        driver.findElement(TextBoxFullName).sendKeys(userName);
        driver.findElement(TextBoxEmail).sendKeys(email);
        driver.findElement(TextBoxCurrentAddress).sendKeys(current);
        driver.findElement(TextBoxPermanentAddress).sendKeys(permanent);
    }

    public void submitButton() {
        driver.findElement(TextBoxSubmit).click();
    }

    //Метод получения массива выведенных строк
    public String[] getOutputValues() {
        String[] output = new String[4];
        output[0] = driver.findElement(fullNameOutput).getText();
        output[1] = driver.findElement(emailOutput).getText();
        output[2] = driver.findElement(currentAddressOutput).getText();
        output[3] = driver.findElement(permanentAddressOutput).getText();
        return output;
    }

    //Метод получения массива с ожидаемыми строками в выводе
    public String[] prepareExpectedOutput(String userName, String email, String current, String permanent) {
        return new String[] {
                "Name:" + userName,
                "Email:" + email,
                "Current Address :" + current,
                "Permanent Address :" + permanent
        };
    }
}