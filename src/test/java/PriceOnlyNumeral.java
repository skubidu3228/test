import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Liquor;
import pages.MainPage;
import pages.Product_and_Alcohol;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class PriceOnlyNumeral  extends BaseTest {

    private MainPage mainPage;
    private pages.Product_and_Alcohol product_and_Alcohol;
    private Liquor liquor;
    List<String> result1 = new ArrayList<>();
    List<String> result2 = new ArrayList<>();
    private static final String min = "qwertyuiop []asdfghjkl;'zxcvbnm,./QWERTYUIOP{}ASDFGHJKL:@ZXCVBNM<>?¬!\"£$&*+=-`()";
    private static final String max = "qwertyuiop []asdfghjkl;'zxcvbnm,./QWERTYUIOP{}ASDFGHJKL:@ZXCVBNM<>?¬!\"£$&*+=-`()";
    @BeforeTest
    public void initializePage() {
        product_and_Alcohol = new Product_and_Alcohol(driver);
        mainPage = new MainPage(driver);
        liquor = new Liquor(driver);
    }
    @Test
    public void price_Only_Numeral (){
        mainPage.go_to_product_and_alcohol();
        product_and_Alcohol.go_to_liquor();
        result1 = liquor.verifySearchResultBeforeTest();
        liquor.onlyNumeral(min,max);
        result2 = liquor.verifySearchResultAfterTest();
        assert (result1.equals(result2));
    }
}
