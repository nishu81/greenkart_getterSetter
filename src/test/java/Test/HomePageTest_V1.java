package Test;

import Browser.Browsers;
import Browser.LaunchBrowser;
import Configs.OrderConfig_V1;
import Page.HomePage_V1;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest_V1 extends TestBase {

    public WebDriver driver;
    private static OrderConfig_V1 beetrootOrder;

    @BeforeMethod
    public void setup() throws IOException {
        launchBrowser = new LaunchBrowser();
        driver = launchBrowser.getSite(Browsers.CHROME);
        driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/");
        beetrootOrder = OrderConfig_V1.builder().vegName("Beetroot - 1 Kg").vegQty(2).build();

    }

    @Test
    public void addVegetable() throws InterruptedException {
        homePage = new HomePage_V1(driver);
        homePage.configureOrder(beetrootOrder);
        Thread.sleep(10000);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
