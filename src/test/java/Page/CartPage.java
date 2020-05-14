package Page;

import Configs.OrderConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {

        this.driver = driver;
    }

    public HashMap<String, String> getCartPageNameQuantityData() {
        //ArrayList<OrderConfiguration> lst = new ArrayList<>();
        // ArrayList<OrderConfiguration> lst
        HashMap<String, String> cartData = new HashMap<String, String>();
        List<WebElement> vegNames = driver.findElements(By.xpath("//table//tr[position()>1]//td[position()>1]/p[@class='product-name']"));
        List<WebElement> vegQty = driver.findElements(By.xpath("//table//tr[position()>1]//td[position()>1]/p[@class='quantity']"));

        for (int i = 0, j = 0; i < vegNames.size() && j < vegQty.size(); i++, j++) {
            cartData.put(vegNames.get(i).getText(), vegQty.get(j).getText());
        }

        System.out.println();
        System.out.println("CART DATA  NAME: QUANTITY ");
        for (Map.Entry<String, String> mm : cartData.entrySet()) {
            System.out.println(mm.getKey() + " " + mm.getValue());
        }

        return cartData;
    }

}
