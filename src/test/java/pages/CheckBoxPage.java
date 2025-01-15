package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxPage {
    WebDriver driver;
    By expandAllButton = By.xpath("//button[@title='Expand all']");
    By collapseAllButton = By.xpath("//button[@title='Collapse all']");

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void CheckBoxPageTransition() {
        driver.get("https://demoqa.com/checkbox");
    }

    public void clickExpandAll() {
        driver.findElement(expandAllButton).click();
    }

    public void clickCollapseAll() {
        driver.findElement(collapseAllButton).click();
    }

    public void selectCheckBoxes(String[] checkBoxes) {
        for (String checkBox : checkBoxes) {
            driver.findElement(By.xpath(String.format("//span[contains(text(), '%s')]", checkBox))).click();
        }
    }

    public boolean areCheckBoxesVisible(String[] checkBoxes) {
        for (String checkBox : checkBoxes) {
            if (driver.findElements(By.xpath(String.format("//span[contains(text(), '%s')]", checkBox))).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public int getCountOfCheckedOutputs() {
        List<WebElement> elements = driver.findElements(By.xpath("//span[@class='text-success']"));
        return elements.size();
    }
}