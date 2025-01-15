package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage {
    WebDriver driver;

    By outputLocator = By.xpath("//p/span");

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    public void RadioButtonPageTransition() {
        driver.get("https://demoqa.com/radio-button");
    }

    public void selectRadioButton(String buttonName) {
        buttonName = buttonName.toLowerCase();
        driver.findElement(By.xpath(String.format("//input[@id='%sRadio']/parent::div/label", buttonName))).click();
    }

    public boolean isOutputVisible() {
        return !driver.findElements(outputLocator).isEmpty();
    }

    public String getOutputMessage() {
        return (driver.findElement(outputLocator).getText());
    }
}