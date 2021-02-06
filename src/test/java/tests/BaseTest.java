package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LogInPage;
import pages.ProductPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    LogInPage logInPage;
    ProductPage productPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        logInPage = new LogInPage(driver);
        productPage = new ProductPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDow() {
        if (driver != null) {
            driver.quit();
        }
    }
}