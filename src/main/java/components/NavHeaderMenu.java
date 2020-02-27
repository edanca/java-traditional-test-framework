package components;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class NavHeaderMenu extends Base {

    @FindBy(linkText = "Creá tu cuenta") private WebElement createAccount;
    @FindBy(linkText = "Ingresá") private WebElement login;
    @FindBy(linkText = "Mis compras") private WebElement myPurchase;
    @FindBy(id = "nav-cart") private WebElement cart;

    public NavHeaderMenu(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    public Login clickCreateAccount() {
        createAccount.click();
        return new Login(driver);
    }

    public Login clickLogin() {
        login.click();
        return new Login(driver);
    }

    public Login clickMyPurchase() {
        myPurchase.click();
        return new Login(driver);
    }

    public Login clickCart() {
        cart.click();
        return new Login(driver);
    }
}
