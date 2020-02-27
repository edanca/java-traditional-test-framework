package components;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class AsideBar extends Base {

    @FindBy(css = "aside h1") private WebElement asideTitle;
    @FindBy(css = ".list li a") private List<WebElement> categoriesLinks;

    public AsideBar(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    private WebElement getLinkFromCategories(String linkText) {
        String linkTextUnaccented = this.unaccent(linkText);
        for (WebElement link : categoriesLinks) {
            String linkFromPage = this.unaccent(link.getText()).toLowerCase();
            if (linkFromPage.equals(linkTextUnaccented.toLowerCase())) {
                return link;
            }
        }
        return null;
    }

    public String getAsideTitle() {
        return asideTitle.getText();
    }

    public AsideBar clickOnCategoryLink(String linkText) {
        getLinkFromCategories(linkText).click();
        return this;
    }

}
