package pageobject_model.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.Calendar;

public class LandingPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://pudra.by/";

    @FindBy(xpath = "//a[@class='i-gift'][contains(text(), 'АКЦИИ')]")
    private WebElement linkToPromotions;

    @FindBy(xpath = "//a[@class='i-sale'][contains(text(), 'СКИДКИ')]")
    private WebElement linkToSales;

    @FindBy(xpath = "//a[@href='/discount'][contains(text(), 'Система скидок')]")
    private WebElement salesCategory;

    @FindBy(xpath = "//a[@href='/brand'][contains(text(), 'БРЕНДЫ')]")
    private WebElement BrandsLink;

    @FindBy(xpath = "//span[@class='catalog-brands-name'][contains(text(), 'AA')]")
    private WebElement aaBrand;


    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public LandingPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public LandingPage clickOnSales() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", linkToSales);
        return this;
    }

    public LandingPage clickOnBrands() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", BrandsLink);
        return this;
    }

    public WebElement getSalesPage() {
        return salesCategory;
    }

    public WebElement getAaBrand() {
        return aaBrand;
    }
}
