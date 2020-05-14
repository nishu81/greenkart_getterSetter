package Test;

import Browser.Browsers;
import Browser.LaunchBrowser;
import Configs.OrderConfiguration;
import org.openqa.selenium.WebDriver;

public class TestHelpers extends TestBase {

    private WebDriver driver;
    private static OrderConfiguration beetrootOrder;

//    public TestHelpers(WebDriver driver){
//        this.driver = driver;
//    }

    public WebDriver launchSite(){
        launchBrowser = new LaunchBrowser();
        driver = launchBrowser.getSite(Browsers.CHROME);
        driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/");
        return driver;
    }

    public OrderConfiguration configureSingleItemOrder(WebDriver driver){
       return  OrderConfiguration.builder().vegName("Beetroot - 1 Kg").vegQty(2).build();
    }


}
