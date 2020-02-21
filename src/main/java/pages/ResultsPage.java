package pages;

import base.Base;
import components.ResultsSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage extends Base {

    private ResultsSection resultsSection;

    public ResultsPage(WebDriver driver) {
        super(driver);
        resultsSection = new ResultsSection(driver);
    }

    public ResultsPage goToPage(int pageNumber) {
        resultsSection.linkPages().get(pageNumber - 1).click();
        return this;
    }

    public DetailsPage selectResultImageInPosition(int resultPosition) {
        resultsSection.resultElements().get(resultPosition - 1).click();
        return new DetailsPage(driver);
    }

    public DetailsPage selectResultDisclaimerInPosition(int resultPosition) {
        resultsSection.resultItemsDisclaimer().get(resultPosition - 1).click();
        return new DetailsPage(driver);
    }
}
