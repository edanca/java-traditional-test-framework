package components;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsSection extends Base {

    private By byLinkPages = By.cssSelector("div.pagination__container li a");
    private By byResultItemsImages = By.cssSelector("div.image-content a");
    private By byResultItemsDescription = By.cssSelector(".item__title .main-title");

    public ResultsSection(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> linkPages() { return this.getWebElements(byLinkPages); }
    public List<WebElement> resultElements() { return this.getWebElements(byResultItemsImages); }
    public List<WebElement> resultItemsDescription() { return this.getWebElements(byResultItemsDescription); }
}
