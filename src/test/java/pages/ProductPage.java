package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public static final String ADD_TO_CART = "//*[contains(text(),'%s')]/ancestor::div[contains(@class,'inventory_item')]//button";
    public static final By CART_BUTTON = By.id("shopping_cart_container");
    public static final By PRODUCT_LABEL = By.cssSelector(".product_label");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void buyProduct(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART, productName))).click();
    }

    public void goToCart() {
        driver.findElement(CART_BUTTON).click();
    }

    public String getProductLabel() {
       return driver.findElement(PRODUCT_LABEL).getText();
    }
}