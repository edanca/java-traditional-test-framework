package components;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class PromotionsBox extends Base {

    @FindBy(css = ".promotion-item a") private List<WebElement> promotionsItems;
    @FindBy(className = "promotion-item__today-offer-text") private List<WebElement> promotionTexts;

    public PromotionsBox(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    private WebElement getElementFromPromotionsList(int position) {
        return promotionsItems.get(position - 1);
    }

    public PromotionsBox clickOnPromotionElementFromList(int position) {
        getElementFromPromotionsList(position).click();
        return this;
    }

    public String getPromotionText(int position) {
        return promotionTexts.get(position).getText();
    }
}
