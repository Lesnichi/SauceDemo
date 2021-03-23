package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPageFactory extends BasePage {
    @FindBy(id = "user-name")
    WebElement loginInput;
    @FindBy(id = "password")
    WebElement passwordIntup;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(css = "[data-test=error]")
    WebElement errorMessage;

    public LogInPageFactory(WebDriver driver) {
        super(driver);
    }

    public LogInPageFactory open() {
        driver.get("https://www.saucedemo.com/");
        PageFactory.initElements(driver, this);
        return this;
    }

    public void login(String userName, String password) {
        loginInput.sendKeys(userName);
        passwordIntup.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMassage() {
        return errorMessage.getText();
    }
}