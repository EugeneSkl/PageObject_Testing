package pageobject_model.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject_model.page.LandingPage;

public class PudraByTest {
    private WebDriver driver;

    @BeforeTest (alwaysRun = true)
    public void browserSetup() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
    }

    @Test
    public void openSales() {
        WebElement keywordsMetaTag = new LandingPage(driver)
                .openPage()
                .clickOnSales()
                .getSalesPage();

        Assert.assertTrue(keywordsMetaTag.getAttribute("text").contains("Система скидок"));
    }

    @Test
    public void chooseBrand() {
        WebElement keywordsMetaTag = new LandingPage(driver)
                .openPage()
                .clickOnBrands()
                .getAaBrand();
        Assert.assertTrue(keywordsMetaTag.getAttribute("text").contains("AA"));
    }

    @AfterTest (alwaysRun = true)
    public void browserQuit() {
        driver.quit();
        driver = null;
    }
}
