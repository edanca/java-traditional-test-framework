package pages;

import base.Base;
import components.BuyBox;
import components.ProductOverview;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailsPage extends Base {

    ProductOverview productOverview;
    BuyBox buyBox;

    public DetailsPage(WebDriver driver) {
        super(driver);
        productOverview = new ProductOverview(driver);
        buyBox = new BuyBox(driver);
    }

    public int getItemPrice() {
        String price = productOverview.itemPrice().getText();
        return (int) this.convertStringToNumber(price);
    }

    public LoginPage clickBuyInBuyBox() {
        buyBox.clickBuyButton();
        return new LoginPage(driver);
    }
}