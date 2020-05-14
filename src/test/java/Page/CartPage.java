package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public HashMap<String, String> getCartPageData() {

        HashMap<String, String> cartData = new HashMap<String, String>();
        List<WebElement> colHeader = driver.findElements(By.xpath("//table//td[position()>1]"));
        List<WebElement> colValues = driver.findElements(By.xpath("//table//td[position()>1]/p"));

        for (int i = 0, j = 0; i < colHeader.size() && j < colValues.size(); i++, j++) {
            cartData.put(colHeader.get(i).getText(), colValues.get(j).getText());
        }
        System.out.println();
        System.out.println("CART DATA ");
        for (Map.Entry<String, String> mm : cartData.entrySet()) {
            System.out.println(mm.getKey()+ " "+ mm.getValue());
        }

        return cartData;
    }

}
