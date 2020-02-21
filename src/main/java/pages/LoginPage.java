package pages;

import base.Base;
import components.Login;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base {

    Login login;

    public LoginPage(WebDriver driver) {
        super(driver);
        login = new Login(driver);
    }

    public String getIamNewText() {
        return login.getIamNewText();
    }
}
