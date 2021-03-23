package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPageFluent extends BasePage {
    public static final By LOGIN_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MASSAGE = By.cssSelector("[data-test=error]");

    public LogInPageFluent(WebDriver driver) {
        super(driver);
    }

    public LogInPageFluent open() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    public ProductPage login(String userName, String password) {
        driver.findElement(LOGIN_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductPage(driver);
    }

    public String getErrorMassage() {
        return driver.findElement(ERROR_MASSAGE).getText();
    }
}