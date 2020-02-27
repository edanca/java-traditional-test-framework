package offer;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ResultsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OfferTests extends BaseTests {

    String menuText = "Ofertas";

    @Test
    void testSelectCategoriesFromOffers() {
        String categoryName = "Computación";
        int itemPrice = homePage
                .clickOnNavMenu(menuText)
                .clickOnCategory(categoryName)
                .clickOnPromotionItem(5)
                .getItemPrice();

        assertTrue(itemPrice > 0);
    }

    @Test
    void testValidateOfferText() {
        String expected_offerText = "OFERTA DEL DÍA";
        String offerText = homePage
                .clickOnNavMenu(menuText)
                .getPromotionItemOfferText(2);

        assertEquals(offerText, expected_offerText);
    }
}
