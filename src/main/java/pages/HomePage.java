package pages;

import components.NavMenu;
import components.NavSearch;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

    private WebDriver driver;

    /**
     * Components
     */
    private NavSearch nav;
    private NavMenu navMenu;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
        this.driver = driver;
        nav = new NavSearch(driver);
        navMenu = new NavMenu(driver);
    }

    public ResultsPage searchProduct(String product) {
        nav.searchInput.sendKeys(product + Keys.ENTER);
        return new ResultsPage(driver);
    }

    public ResultsPage clickOnNavMenu(String linkMenu) {
        navMenu.clickOnNavMenu(linkMenu);
        return new ResultsPage(driver);
    }
}
