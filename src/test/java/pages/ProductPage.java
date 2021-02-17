package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductPage extends BasePage {

    public static final String ADD_TO_CART = "//*[contains(text(),'%s')]/ancestor::div[contains(@class,'inventory_item')]//button";
    public static final By CART_BUTTON = By.id("shopping_cart_container");
    public static final By PRODUCT_LABEL = By.cssSelector(".product_label");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage open() {
        return null;
    }

    public ProductPage buyProduct(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART, productName))).click();
        return new ProductPage(driver);
    }

    public void goToCart() {
        driver.findElement(CART_BUTTON).click();
    }

    public String getProductLabel() {
        return driver.findElement(PRODUCT_LABEL).getText();
    }

    public void isPageOpened1() {
        try {
            driver.findElement(PRODUCT_LABEL);
        } catch (NoSuchElementException exception) {
            Assert.fail("Страница продукта не была загружена");
        }
    }

    public boolean isPageOpened2() {
        boolean isOpened;
        try {
            driver.findElement(PRODUCT_LABEL);
            isOpened = true;
        } catch (NoSuchElementException exception) {
            isOpened = false;
            Assert.fail("Страница продукта не была загружена");
        }
        return isOpened;
    }

    public void isPageOpened3() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PRODUCT_LABEL));
        } catch (TimeoutException exception) {
            Assert.fail("Страница продукта не была загружена");
        }
    }
}