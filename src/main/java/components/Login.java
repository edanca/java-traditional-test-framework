package components;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends Base {

    private By byIamNewButton = By.cssSelector("#registration-link span");

    public Login(WebDriver driver) {
        super(driver);
    }

    private WebElement iamNew() { return this.getWebElement(byIamNewButton); }

    public String getIamNewText() {
        return iamNew().getText();
    }
}
