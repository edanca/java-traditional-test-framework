package search;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ResultsPage;

import static org.testng.Assert.*;

public class SearchTests extends BaseTest {

    ResultsPage resultsPage;

    @Test
    void testItemPriceHigherThanZero() {
        String productToSearch = "ssd";
        resultsPage = homePage.searchProduct(productToSearch);
        int itemPrice = resultsPage
                .goToPage(2)
                .selectResultImageInPosition(2)
                .getItemPrice();

        assertTrue(itemPrice > 0);
    }
}
