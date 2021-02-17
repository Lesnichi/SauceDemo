package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    LogInPage logInPage;
    LogInPageFactory logInPageFactory;
    LogInPageFluent logInPageFluent;
    ProductPage productPage;
    CartPage cartPage;
    CheckOutPage checkOutPage;

    @BeforeMethod
    public void setup(ITestResult testResult) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        testResult.getTestContext().setAttribute("driver", driver);
        logInPage = new LogInPage(driver);
        logInPageFactory = new LogInPageFactory(driver);
        logInPageFluent = new LogInPageFluent(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkOutPage = new CheckOutPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDow() {
        if (driver != null) {
            driver.quit();
        }
    }
}