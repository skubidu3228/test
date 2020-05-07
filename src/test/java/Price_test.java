import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Liquor;
import pages.MainPage;
import pages.Product_and_Alcohol;
import pages.SearchResultPage;

public class Price_test extends BaseTest  {

    private MainPage mainPage;
    private pages.Product_and_Alcohol product_and_Alcohol;
    private Liquor liquor;
    private static final int min = 400;
    private static final int max = 800;
    @BeforeTest
    public void initializePage() {
        product_and_Alcohol = new Product_and_Alcohol(driver);
        mainPage = new MainPage(driver);
        liquor = new Liquor(driver);
    }
    @Test
    public void price_min_max (){
        mainPage.go_to_product_and_alcohol();
        product_and_Alcohol.go_to_liquor();
        liquor.min_max(Integer.toString(min),Integer.toString(max));
        liquor.newPrice(Integer.toString(min),Integer.toString(max));
    }

}
