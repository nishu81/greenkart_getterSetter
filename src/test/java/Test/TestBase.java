package Test;

import Browser.Browsers;
import Browser.LaunchBrowser;
import Configs.OrderConfiguration;
import Page.CartPage;
import Page.HomePage;

public class TestBase {

    protected HomePage homePage;
    protected Browsers browsers;
    protected LaunchBrowser launchBrowser;
    protected OrderConfiguration orderConfiguration;
    protected CartPage cartPage;
    protected TestHelpers testHelpers;
}
