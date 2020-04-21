import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class GoogleTest {
    static WebDriver driver;
    private final String url = "https://google.com";
    private final By btnSearch = By.xpath("/html/body/div/div[4]/form/div[2]/div[1]/div[1]/div/div[2]/input");
    private final String query = "softserve";
    private final By nextbtn = By.xpath("/html/body/div[7]/div[3]/div[8]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div[1]/a/h3");
    @Test
    public void FirstTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.findElement(btnSearch).click();
        driver.findElement(btnSearch).sendKeys(query);
        driver.findElement(btnSearch).sendKeys(Keys.ENTER);
        driver.findElement(nextbtn).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(query));
    }
    @Test
    public void SecondTest() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.findElement(btnSearch).click();
        driver.findElement(btnSearch).sendKeys(query);
        driver.findElement(btnSearch).sendKeys(Keys.ENTER);
        driver.findElement(nextbtn).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(query));
    }
    @Test
    public void ThirdTest() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.findElement(btnSearch).click();
        driver.findElement(btnSearch).sendKeys(query);
        driver.findElement(btnSearch).sendKeys(Keys.ENTER);
        driver.findElement(nextbtn).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(query));
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
