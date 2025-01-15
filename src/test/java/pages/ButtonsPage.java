package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage {
    WebDriver driver;
    Actions actions;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void ButtonsPageTransition() {
        driver.get("https://demoqa.com/buttons");
    }

    public void clickButton(String nameButton, String actionType) {
        WebElement button = driver.findElement(By.xpath(String.format("//button[text()='%s']", nameButton)));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Восстановление статуса прерывания
        }

        switch (actionType.toLowerCase()) {
            case "left click":
                actions.click(button).perform();
                break;
            case "right click":
                actions.contextClick(button).perform();
                break;
            case "double click":
                actions.doubleClick(button).perform();
                break;
            default:
                throw new IllegalArgumentException("Unsupported click type: " + actionType);
        }
    }

    public boolean isClickOutputDisplayed(String nameButton) {
        String xpath;
        switch (nameButton) {
            case "Click Me":
                xpath = "//p[@id='dynamicClickMessage' and text()='You have done a dynamic click']";
                break;
            case "Right Click Me":
                xpath = "//p[@id='rightClickMessage' and text()='You have done a right click']";
                break;
            case "Double Click Me":
                xpath = "//p[@id='doubleClickMessage' and text()='You have done a double click']";
                break;
            default:
                throw new IllegalArgumentException("Invalid button name: " + nameButton);
        }
        try {
            return driver.findElement(By.xpath(xpath)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}