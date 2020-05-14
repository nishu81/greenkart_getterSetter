package Test;

import Browser.Browsers;
import Browser.LaunchBrowser;
import Configs.OrderConfiguration;
import Page.CartPage;
import Page.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class CartPageTest extends TestBase {

    public WebDriver driver;
    private static OrderConfiguration beetrootOrder;


    @BeforeMethod
    public void setup() throws IOException {
       /* launchBrowser = new LaunchBrowser();
        driver = launchBrowser.getSite(Browsers.CHROME);
        driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/");
        beetrootOrder = OrderConfiguration.builder().vegName("Beetroot - 1 Kg").vegQty(2).build();*/
       testHelpers = new TestHelpers();
       driver = testHelpers.launchSite();
        beetrootOrder = testHelpers.configureSingleItemOrder(driver);

    }

    @Test
    public void cartPageTest() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.configureOrder(beetrootOrder);
        homePage.proceedToCheckOut();
        Thread.sleep(10000);
        cartPage = new CartPage(driver);
        cartPage.getCartPageData();
        //Set<String> keySets =  cartPage.getCartPageData().keySet();
        String cartQuantity= cartPage.getCartPageData().get("Quantiry");
        beetrootOrder.getVegQty();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
