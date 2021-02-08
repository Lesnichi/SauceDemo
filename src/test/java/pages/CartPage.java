package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public static final By CONTINUE_SHOPPING_BUTTON_ = By.cssSelector(".cart_footer .btn_secondary");
    public static final By CHECKOUT_BUTTON_ = By.cssSelector(".btn_action.checkout_button");
    public static final By MENU_BUTTON = By.cssSelector(".bm-burger-button");
    public static final By COUNTER_PRODUCT = By.cssSelector(".shopping_cart_badge");
    public static final String REMOVE_BUTTON = "//*[contains(text(),'%s')]/ancestor::div[@class='cart_item_label']//button";

    public void removeProductFromCart(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
    }

    public int getCountOfProduct() {
        if (driver.findElement(COUNTER_PRODUCT) != null) {
            return Integer.parseInt(driver.findElement(COUNTER_PRODUCT).getText());
        } else return 0;
    }

    public void backToProductPage() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON_).click();
    }

    public void goToCheckout() {
        driver.findElement(CHECKOUT_BUTTON_).click();
    }

    public void openMenuBar() {
        driver.findElement(MENU_BUTTON).click();
    }
}
