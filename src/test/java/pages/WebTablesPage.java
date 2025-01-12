package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class WebTablesPage {
    WebDriver driver;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebTablesPage() {
        driver.get("https://demoqa.com/webtables");
    }

    public int countOfFilledRows() {
        List<WebElement> listOfRaws = driver.findElements(By.xpath("//div[@class='rt-td'][text()]"));
        return (listOfRaws.size()) / 6;
    }

    public int countOfEmptyRows() {
        List<WebElement> listOfRaws = driver.findElements(By.xpath("//div/span[parent::div[@class='rt-td']]"));
        return (listOfRaws.size()) / 7;
    }

    public void deleteRow(int numberOfRow) {
        ++numberOfRow; //увеличиваем на один т.к. числа в id в локаторах на один больше чем номер строки (например у строки номер 1, id="delete-record-2"
        driver.findElement(By.xpath(String.format("//span[@id='delete-record-%s']", numberOfRow))).click();
    }

    public void changeQuantityOfRows(int quantityOfRows) {
        driver.findElement(By.xpath(String.format("//option[@value=%s]", quantityOfRows))).click();
    }
}