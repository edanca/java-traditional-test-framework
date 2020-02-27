package pages;

import base.Base;
import components.AsideBar;
import components.PromotionsBox;
import components.ResultsSection;
import org.openqa.selenium.WebDriver;

public class ResultsPage extends Base {

    private ResultsSection resultsSection;
    private AsideBar categories;
    private PromotionsBox promotionsBox;

    public ResultsPage(WebDriver driver) {
        super(driver);
        categories = new AsideBar(driver);
        promotionsBox = new PromotionsBox(driver);
        resultsSection = new ResultsSection(driver);
    }

    public ResultsPage clickOnCategory(String categoryText) {
        categories.clickOnCategoryLink(categoryText);
        return this;
    }

    public DetailsPage clickOnPromotionItem(int position) {
        promotionsBox.clickOnPromotionElementFromList(position);
        return new DetailsPage(driver);
    }

    public ResultsPage goToPage(int pageNumber) {
        resultsSection.linkPages().get(pageNumber - 1).click();
        return this;
    }

    public DetailsPage clickResultDescriptionInPosition(int resultPosition) {
        resultsSection.resultItemsDescription().get(resultPosition - 1).click();
        return new DetailsPage(driver);
    }

    public DetailsPage clickResultImageInPosition(int resultPosition) {
        resultsSection.resultElements().get(resultPosition - 1).click();
        return new DetailsPage(driver);
    }

    public String getPromotionItemOfferText(int position) {
        return promotionsBox.getPromotionText(position);
    }
}
