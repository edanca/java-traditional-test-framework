package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class Base {

    protected WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getWebElement(By bySelector) {
        return driver.findElement(bySelector);
    }

    public List<WebElement> getWebElements(By bySelector) {
        return driver.findElements(bySelector);
    }

    protected Number convertStringToNumber(String text) {
        text = text.replace(".", ",");
        Number number = 0;
        try {
            NumberFormat format = NumberFormat.getInstance(Locale.US);
            number = format.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result = number.intValue();
        return result;
    }
}
