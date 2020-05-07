import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_Before_After {
    private static WebDriver driver;
    private final By btnSearch = By.xpath("/html/body/app-root/div/div[1]/app-rz-header/header/div/div[2]/div[2]/form/button");
    private final By lineSearch = By.xpath("/html/body/app-root/div/div[1]/app-rz-header/header/div/div[2]/div[2]/form/div/div/input");
    @AfterMethod
    public static void afterMethod(){
        driver.quit();
    }
    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://rozetka.com.ua/");
    }

    @DataProvider(name = "data1")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"ноутбук"},
                {"мяч"},
                {"чайник"}
        };
    }
    @Test(dataProvider = "data1")
    public void test(String search){
        driver.findElement(lineSearch).sendKeys(search);
        driver.findElement(btnSearch).click();
    }
}
