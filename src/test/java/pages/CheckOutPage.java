package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public static final By CHECKOUT_LABEL = By.cssSelector(".subheader");

    public String getCheckOutLabel() {
        return driver.findElement(CHECKOUT_LABEL).getText();
    }
}
