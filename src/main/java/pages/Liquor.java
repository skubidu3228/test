package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.StringContains.containsString;

public class Liquor {
    String listOfTitles2;
    private WebDriver driver;
    int convert_min, convertResult, convert_max;
    @FindBy(how = How.XPATH, using = "//*[@id=\"price-min\"]")
    private WebElement min_price;

    @FindBy(how = How.XPATH, using = "//*[@id=\"price-max\"]")
    private WebElement max_price;

    @FindBy(how = How.XPATH, using = "//*[@id=\"buttonPrice\"]/span")
    private WebElement btnOK;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-center\"]/section/div/article/div/a/span/strong")
    private List<WebElement> newPrice;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-center\"]/section/div[3]/article/div[2]/div[1]/a")
    private List<WebElement> lstSearchResultTitles;

    public Liquor (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void min_max (String price_min, String price_max) {
        min_price.sendKeys(price_min);
        max_price.sendKeys(price_max);
        btnOK.click();
    }

    public void newPrice (String price_min, String price_max) {
        List<String> currentResult = new ArrayList<>();
        List<WebElement> price_after_change = newPrice;
        convert_min = Integer.parseInt(price_min);
        convert_max = Integer.parseInt(price_max);
        for (WebElement listOfTitles : price_after_change) {
            listOfTitles2 = listOfTitles.getText().replaceAll("[a-zA-Zа-яА-Я]*", "");
            listOfTitles2 = listOfTitles2.replaceAll(" ", "");
            convertResult = Integer.parseInt(listOfTitles2);
            assert(convertResult >= convert_min);
            assert(convertResult <= convert_max + 100);
        }
    }
    public void onlyNumeral (String price_min, String price_max) {
        min_price.sendKeys(price_min);
        max_price.sendKeys(price_max);
        btnOK.click();
    }
    public List<String> verifySearchResultBeforeTest() {
       0

        List<WebElement> actualResult = lstSearchResultTitles;
        for (WebElement listOfTitles : actualResult) {
            currentResult.add(listOfTitles.getText());
        }
        return currentResult;
    }
    public List<String> verifySearchResultAfterTest() {
        List<String> currentResult = new ArrayList<>();
        List<WebElement> actualResult = lstSearchResultTitles;
        for (WebElement listOfTitles : actualResult) {
            currentResult.add(listOfTitles.getText());
        }
        return currentResult;
    }

}
