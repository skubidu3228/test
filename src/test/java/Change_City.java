import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Liquor;
import pages.MainPage;
import pages.Product_and_Alcohol;

public class Change_City  extends BaseTest {
    private MainPage mainPage;
    @BeforeTest
    public void initializePage() {
        mainPage = new MainPage(driver);
    }
    @Test
    public void verifyChaneCityResult() {
        mainPage.change_City();
        mainPage.city();
        mainPage.correct_City("Одесса");
    }
}
