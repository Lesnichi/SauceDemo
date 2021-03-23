package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogInTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Enter correct password")
    public void correctPassword() {
        logInPage.open();
        logInPage.login(userNameOK, passwordOK);
        Assert.assertTrue(productPage.isPageOpened2());
    }

    @Test(retryAnalyzer = Retry.class, description = "Enter wrong password")
    public void wrongPassword() {
        logInPage.open();
        logInPage.login(userNameOK, "123");
        assertEquals(logInPage.getErrorMassage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error massage is not correct");
    }

    @Test(retryAnalyzer = Retry.class, description = "Enter empty form")
    public void emptyUserName() {
        logInPage.open();
        logInPage.login("", "");
        assertEquals(logInPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "Error massage is not correct");
    }
}