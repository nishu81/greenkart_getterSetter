package Page;

import Configs.OrderConfig_V1;
import io.cucumber.java.hu.Ha;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage_V1 {

    private WebDriver driver;


    public HomePage_V1(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCartButton(String prodName) {
        String vegName = "//h4[contains(text(),'" + prodName + "')]/..//button";
        WebElement vegNameLoc = driver.findElement(By.xpath(vegName));
        vegNameLoc.click();
    }

    public int getQuantity(String prodName) {
        String vegQty = "//h4[contains(text(),'" + prodName + "')]/..//input[@value]";
        WebElement vegQtyLoc = driver.findElement(By.xpath(vegQty));
        String qty = vegQtyLoc.getAttribute("value");

        System.out.println("Quantity is " + qty);

        return Integer.parseInt(qty);
    }

    public int increaseQuantity(String prodName, int item) {
        String vegQty = "//h4[contains(text(),'" + prodName + "')]/..//input[@value]";
        WebElement vegQtyLoc = driver.findElement(By.xpath(vegQty));
        String qty = vegQtyLoc.getAttribute("value");

        int vQty = 1;

        while (vQty < item) {
            String itemIncrement = " //h4[contains(text(),'" + prodName + "')]/..//a[@class='increment']";
            WebElement increment = driver.findElement(By.xpath(itemIncrement));
            increment.click();
            vQty = vQty + 1;
        }

        return Integer.parseInt(qty);
    }

    public int getPrice(String prodName) {
        String vegPrice = "//h4[contains(text(),'" + prodName + "')]/..//p";
        WebElement vegPriceLoc = driver.findElement(By.xpath(vegPrice));
        String price = vegPriceLoc.getText();

        System.out.println(" Item price " + price);

        return Integer.parseInt(price);
    }

    public int calculateItemizedPrice(String prodName,int qty){
        int itemPrice = 0;

        if (getQuantity(prodName) == 1) {
            itemPrice = getQuantity(prodName) * getPrice(prodName);
        } else if (getQuantity(prodName) > 1) {
            itemPrice = increaseQuantity(prodName, qty) * getPrice(prodName);
        }
        System.out.println("Calculated price for multi quantity " + itemPrice);

        return itemPrice;
    }


    public HomePage_V1 configureOrder(OrderConfig_V1 homePageOrderConfig){
        increaseQuantity(homePageOrderConfig.getVegName(),homePageOrderConfig.getVegQty());
        getQuantity(homePageOrderConfig.getVegName());
        calculateItemizedPrice(homePageOrderConfig.getVegName(),homePageOrderConfig.getVegQty());
        addToCartButton(homePageOrderConfig.getVegName());

        return this;
    }
}
