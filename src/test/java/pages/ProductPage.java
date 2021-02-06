package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public static final String ADD_TO_CART = "//*[contains(text(),'%s')]/ancestor::div[contains(@class,'inventory_item')]//button";

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void buyProduct(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART, productName))).click();
    }
}