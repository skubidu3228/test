import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;;
import org.openqa.selenium.Keys;
import static org.junit.Assert.assertEquals;


public class first {
    @Test
    public void FirstTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("SoftServe");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/h3"));
        if(element.getText().contains("SoftServe: Home")){
            System.out.println("First link - SoftServe, it's True");
        }
        else{
            System.out.println("First link - not SoftServe, it's False");
        }
        driver.quit();
    }
}
