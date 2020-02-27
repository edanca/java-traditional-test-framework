package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.Normalizer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class Base {

    protected WebDriver driver;
    private WebDriverWait wait;

    public Base(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public WebElement getWebElement(By bySelector) {
        WebElement elem = wait.until(
                ExpectedConditions.visibilityOfElementLocated(bySelector)
        );
        return elem;
    }

    public List<WebElement> getWebElements(By bySelector) {
        List<WebElement> elems = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(bySelector)
        );
        return elems;
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

    protected String unaccent(String src) {
        return Normalizer
                .normalize(src, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }
}
