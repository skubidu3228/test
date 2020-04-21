import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class second {
    private final By btnSearch = By.xpath("//a[contains(@class, 'search')]");
    private final By inpSearchBox = By.xpath("//input[@type='text']");
    private final By searchResult = By.xpath("//div[@class='search-page__list']//h3");
    private final String url = "https://www.softserveinc.com/uk-ua";
    private final String query = "academy";
    private final String expectedResult = "IT Академія";
    static WebDriver driver;
    @Test public void FirstTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(btnSearch).click();
        webDriverWait.until(d -> driver.findElement(inpSearchBox).isDisplayed());
        driver.findElement(inpSearchBox).sendKeys(query);
        driver.findElement(inpSearchBox).sendKeys(Keys.ENTER);
        assertEquals(driver.findElements(searchResult).get(0).getText(), expectedResult);
        Assert.assertTrue(driver.getCurrentUrl().contains("softserve"));
//        driver.manage().window().maximize();
//        driver.get("https://www.google.com/");
//        driver.findElement(By.name("q")).sendKeys("SoftServe");
//        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//        WebElement element = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/h3"));
//        if(element.getText().contains("SoftServe: Home")){
//            System.out.println("First link - SoftServe, it's True");
//        }
//        else{
//            System.out.println("First link - not SoftServe, it's False");
//        }
        driver.quit();

    }
    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        if (!result.isSuccess()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File source = screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, new File("Screenshots\\"
                        + result.getName() + "[" + LocalDate.now() + "][" + System.currentTimeMillis() + "].png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}