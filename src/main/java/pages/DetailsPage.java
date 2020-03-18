package pages;

import base.Base;
import components.BuyBox;
import components.ProductOverview;
import org.openqa.selenium.WebDriver;

public class DetailsPage extends Base {

    ProductOverview productOverview;
    BuyBox buyBox;

    public DetailsPage(WebDriver driver) {
        super(driver);
        productOverview = new ProductOverview(driver);
        buyBox = new BuyBox(driver);
    }

    public int getItemPrice() {
        String price = productOverview.getItemPrice();
        return (int) this.convertStringToNumber(price);
    }

    public int getItemPriceFromOffer() {
        String price = productOverview.getItemPriceFromOffer();
        return (int) this.convertStringToNumber(price);
    }

    public LoginPage clickBuyInBuyBox() {
        buyBox.clickBuyButton();
        return new LoginPage(driver);
    }
}
