package components;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BuyBox extends Base {

    private By byBuyButtons = By.cssSelector(".ui-pdp-buybox button[formaction*='/buy']");

    public BuyBox(WebDriver driver) {
        super(driver);
    }

    private WebElement buyButton() {
        List<WebElement> buyButtons = this.getWebElements(byBuyButtons);
        return buyButtons.get(0);
    }

    public BuyBox clickBuyButton() {
        buyButton().click();
        return this;
    }
}
