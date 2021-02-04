import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PurchaseTest {

    @Test
    public void purchasingShouldBeSuccessful() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("https://www.saucedemo.com/");
        WebElement inputElementUsername = browser.findElement(By.id("user-name"));
        inputElementUsername.sendKeys("standard_user");
        WebElement inputElementPassword = browser.findElement(By.id("password"));
        inputElementPassword.sendKeys("secret_sauce");
        WebElement buttonLogin = browser.findElement(By.id("login-button"));
        buttonLogin.click();
        WebElement buttonAddToCart1 = browser.findElement(By.xpath("" +
                "//*[contains(text(),'Sauce Labs Backpack')]/ancestor::div[contains(@class,'inventory_item')]//button"));
        WebElement buttonAddToCart2 = browser.findElement(By.xpath("" +
                "//*[contains(text(),'Sauce Labs Bike Light')]/ancestor::div[contains(@class,'inventory_item')]//button"));
        buttonAddToCart1.click();
        buttonAddToCart2.click();
        WebElement buttonContainer = browser.findElement(By.id("shopping_cart_container"));
        buttonContainer.click();
        WebElement priceElement1 = browser.findElement(By.xpath("//*[text()='29.99']"));
        WebElement priceElement2 = browser.findElement(By.xpath("//*[text()='9.99']"));
        Double first = Double.parseDouble(priceElement1.getText());
        Double second = Double.parseDouble(priceElement2.getText());
        Assert.assertEquals((first + second), (29.99 + 9.99), "Нет товаров в корзине");
        browser.quit();
    }
}

