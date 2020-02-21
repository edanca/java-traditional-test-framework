package buy;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BuyTests extends BaseTest {

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
