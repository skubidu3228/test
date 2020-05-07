import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.Product_and_Alcohol;

public class Product_Alcohol_Test extends BaseTest {
    private MainPage mainPage;
    private pages.Product_and_Alcohol product_and_Alcohol;

    @BeforeTest
    public void initializePage() {
        product_and_Alcohol = new Product_and_Alcohol(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    public void search_Alcohol() {
        mainPage.go_to_product_and_alcohol();
        product_and_Alcohol.verifyAllProduct();
    }
}
