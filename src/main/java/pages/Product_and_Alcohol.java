package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static com.google.common.collect.Iterables.size;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.StringContains.containsString;

public class Product_and_Alcohol {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-center\"]/div/ul/li/a/small")
    private List<WebElement> lstSearchResultTitles;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-center\"]/section/div[1]/article[1]/div/ul/li[4]/a")
    private WebElement btnLiquor;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-center\"]/section/div/article/div/div/a")
    private List<WebElement> Allproduct;

    public Product_and_Alcohol(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void go_to_liquor() {
        btnLiquor.click();
    }

    public void verifyAllProduct () {
        List<WebElement> actualResult = Allproduct;
        int quantityProduct = size(actualResult);
        int index = 0;
        String[] realProduct = new String[]{"Алкогольные напитки", "Напитки",
                "Мясные продукты", "Молочные продукты", "Снеки", "Консервация",
                "Бакалея", "Крупы", "Кондитерские изделия", "Суперфуды"};
        String[] currentResult = new String[quantityProduct];
        for (WebElement listOfTitles : actualResult) {
            currentResult[index] = listOfTitles.getText();
            assert(currentResult[index].equals(realProduct[index]));
            index = index +1;
        }

    }
}
