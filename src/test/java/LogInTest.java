import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class LogInTest {

    @Test
    public void loginShouldBePassedSuccessful() {

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
        WebElement nextPage = browser.findElement(By.id("page_wrapper"));
        nextPage.findElement(By.id("menu_button_container"));
        browser.quit();
    }
}
