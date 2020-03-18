package components;

import base.Base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductOverview extends Base {

    private By byItemPrice = By.cssSelector("[itemprop='offers'] .price-tag-fraction");
    private By byItemPriceFromOffer = By.cssSelector(".item-price span span.price-tag-fraction");

    public ProductOverview(WebDriver driver) {
        super(driver);
    }

    private WebElement itemPrice() { return this.getWebElement(byItemPrice); }
    private WebElement itemPriceFromOffer() {
        List<WebElement> elements = this.getWebElements(byItemPriceFromOffer);
        return elements.get(1);
    }

    public String getItemPrice() { return this.itemPrice().getText(); }
    public String getItemPriceFromOffer() { return this.itemPriceFromOffer().getText(); }
}
