package Test;

import Browser.Browsers;
import Browser.LaunchBrowser;
import Configs.OrderConfiguration;
import Page.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBase {

    public WebDriver driver;
    private static OrderConfiguration beetrootOrder;
    private static OrderConfiguration cucumberOrder;

    @BeforeMethod
    public void setup() throws IOException {
        launchBrowser = new LaunchBrowser();
        driver = launchBrowser.getSite(Browsers.CHROME);
        driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/");
        beetrootOrder = OrderConfiguration.builder().vegName("Beetroot - 1 Kg").vegQty(2).build();
        cucumberOrder= OrderConfiguration.builder().vegName("Cucumber - 1 Kg").vegQty(3).build();

    }

    @Test
    public void addVegetable() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.configureOrder(beetrootOrder);
        homePage.configureOrder(cucumberOrder);
        Thread.sleep(10000);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
