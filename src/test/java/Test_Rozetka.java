import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import java.util.Properties;

public class Test_Rozetka {
    private static WebDriver driver;

    String RU, UA,Search;
    private final By btnRU = By.xpath("/html/body/app-root/div/div[1]/app-rz-header/header/div/div[1]/ul[2]/li[1]/a");
    private final By btnUA = By.xpath("/html/body/app-root/div/div[1]/app-rz-header/header/div/div[1]/ul[2]/li[2]/span");
    private final By btnSearch = By.xpath("/html/body/app-root/div/div[1]/app-rz-header/header/div/div[2]/div[2]/form/button");

    @AfterMethod
    public static void cleanUp(){
        driver.quit();
    }
    @DataProvider(name = "data1")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"RU", "Найти"},
                {"UA", "Знайти"},
        };
    }
    @Test(dataProvider = "data1")
    public void testSum(String a, String b) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://rozetka.com.ua/");
        RU = driver.findElement(btnRU).getText();
        UA = driver.findElement(btnUA).getText();
        if (a.equals(RU)) {
            driver.findElement(btnRU).click();
            Search = driver.findElement(btnSearch).getText();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            assert (b.equals(Search));
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        }
        if (a.equals(UA)) {
            Search = driver.findElement(btnSearch).getText();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            assert (b.equals(Search));
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        }
    }
}



