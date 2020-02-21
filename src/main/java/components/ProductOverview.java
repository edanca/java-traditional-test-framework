package components;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductOverview extends Base {

    private By byItemPrice = By.cssSelector(".item-price span span.price-tag-fraction");

    public ProductOverview(WebDriver driver) {
        super(driver);
    }

    public WebElement itemPrice() { return this.getWebElement(byItemPrice); }
}
