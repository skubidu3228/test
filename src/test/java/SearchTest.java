import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchResultPage;

public class SearchTest extends BaseTest {
    private MainPage mainPage;
    private SearchResultPage searchResultPage;
    private static final String productName = "iPhone 11";

    @BeforeTest
    public void initializePage() {
        mainPage = new MainPage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @Test
    public void verifySearchResult() {
        mainPage.inputSearchValue(productName);
        searchResultPage.verifySearchResult(productName);
    }
}
