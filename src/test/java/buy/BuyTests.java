package buy;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BuyTests extends BaseTests {

    @Test
    void testCantBuyWithoutLogin() {
        String expected_iamNewText = "Soy nuevo";
        String iamNewText = homePage
                .searchProduct("iphone")
                .selectResultDisclaimerInPosition(3)
                .clickBuyInBuyBox()
                .getIamNewText();

        assertEquals(iamNewText, expected_iamNewText);
    }
}
