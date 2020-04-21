import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class third {
    private final By btnSearch = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[2]/div/div/div/div[2]/div[3]/div[1]/div[4]/div/div[2]/div[1]/div/a/div[1]/div/div[1]");
    private final By inpSearchBox = By.xpath("//*[@id=\"header-search-bar\"]");
    private final By searchResult = By.xpath("//div[@class='search-page__list']//h3");
    private final String url = "https://www.reddit.com/";
    private final String query = "DotA2";
    private final String expectedResult = "DotA2";
    static WebDriver driver;
    @Test
    public void FirstTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.navigate().to(url);
        driver.findElement(inpSearchBox).sendKeys(query);
        driver.findElement(inpSearchBox).sendKeys(Keys.ENTER);
        driver.findElement(btnSearch).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedResult));
        driver.quit();
    }
//    @AfterMethod
//    public void takeScreenshot(ITestResult result) {
//        if (!result.isSuccess()) {
//            try {
//                TakesScreenshot screenshot = (TakesScreenshot) driver;
//                File source = screenshot.getScreenshotAs(OutputType.FILE);
//                FileUtils.copyFile(source, new File("Screenshots\\"
//                        + result.getName() + "[" + LocalDate.now() + "][" + System.currentTimeMillis() + "].png"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
