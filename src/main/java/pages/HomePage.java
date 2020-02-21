package pages;

import components.Navigation;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

    private WebDriver driver;

    /**
     * Components
     */
    private Navigation nav;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
        this.driver = driver;
        nav = new Navigation(driver);
    }

    public ResultsPage searchProduct(String product) {
        nav.searchInput.sendKeys(product + Keys.ENTER);
        return new ResultsPage(driver);
    }
}
