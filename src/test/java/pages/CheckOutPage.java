package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckOutPage extends BasePage {

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckOutPage open() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        return this;
    }

    public static final By CHECKOUT_LABEL = By.cssSelector(".subheader");

    public String getCheckOutLabel() {
        return driver.findElement(CHECKOUT_LABEL).getText();
    }

    public void isCheckOutPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CHECKOUT_LABEL));
        } catch (TimeoutException exception) {
            Assert.fail("Страница CheckOUT не была загружена");
        }
    }
}
