package components;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class NavMenu extends Base {

    @FindBy(css = ".nav-menu-list .nav-menu-item a")
    private List<WebElement> navLinkList;

    public NavMenu(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    private WebElement getLinkFromLinkList(String linkText) {
        for (WebElement link : navLinkList) {
            String[] parts = this.unaccent(link.getText()).toLowerCase().split("\n");
            String linkFromNav = parts[0];

            if (linkFromNav.equals(linkText.toLowerCase())) {
                return link;
            }
        }
        return null;
    }

    public NavMenu clickOnNavMenu(String menuText) {
        getLinkFromLinkList(menuText).click();
        return this;
    }
}
