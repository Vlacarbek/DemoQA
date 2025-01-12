package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTablesTest extends BaseTest {

    @Test
    // Проверка удаления и количество оставшихся
    public void deleteSomeRowsAndCheckCountOfFilledRows() {
        webTablesPage.openWebTablesPage();
        for (int i = 1; i <= 2; i++) { //удаление строк с 1 по 2
            webTablesPage.deleteRow(i);
        }
        Assert.assertEquals(webTablesPage.countOfFilledRows(), 1);
    }

    @Test
    // Проверка отображения строк и переключение их количества
    public void changeQuantityOfRowsAndCheckCountOfRows() {
        int quantityOfRows = 25; //Допустимые значения - 5, 10, 20, 25, 50, 100
        webTablesPage.openWebTablesPage();
        webTablesPage.changeQuantityOfRows(quantityOfRows);
        Assert.assertEquals(webTablesPage.countOfFilledRows() + webTablesPage.countOfEmptyRows(), quantityOfRows);
    }
}