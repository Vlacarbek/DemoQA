package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    pages.TextBoxPage textBoxPage;
    pages.CheckBoxPage checkBoxPage;
    pages.RadioButtonPage radioButtonPage;
    pages.ButtonsPage buttonsPage;
    pages.WebTablesPage webTablesPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("srart-maximized");
        options.setCapability("pageLoadStrategy", "eager"); // Не ждать загрузку
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        textBoxPage = new pages.TextBoxPage(driver);
        checkBoxPage = new pages.CheckBoxPage(driver);
        radioButtonPage = new pages.RadioButtonPage(driver);
        buttonsPage = new pages.ButtonsPage(driver);
        webTablesPage = new pages.WebTablesPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}