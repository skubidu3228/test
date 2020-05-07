package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;

public class MainPage {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@class='search-text-input']")
    private WebElement inpSearch;

    @FindBy(how = How.XPATH, using = "//input[@type='submit']")
    private WebElement btnSearch;

    @FindBy(how = How.XPATH, using = "//*[@id=\"column-center\"]/section/div[1]/a")
    private WebElement btnProduct_Alcohol;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/header/div/div[1]/div[2]/div/a/span[2]")
    private WebElement btnChangeCity;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/header/div/div[1]/div[1]/div[2]/div/div[2]/ul/li[5]/a")
    private WebElement btnOdessa;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputSearchValue(String productName) {
        inpSearch.sendKeys(productName);
        btnSearch.click();
    }
    public void go_to_product_and_alcohol() {
        btnProduct_Alcohol.click();
    }
    public void change_City(){
        btnChangeCity.click();
    }
    public void city(){
        btnOdessa.click();
    }
    public void correct_City(String city){
        assert(btnChangeCity.getText().equals(city));
    }
}
