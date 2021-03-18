package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogInTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Enter wrong password")
    public void wrongPassword() {
        logInPage.open();
        logInPage.login(userNameOK, "123");
        productPage.isPageOpened3();
        assertEquals(logInPage.getErrorMassage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error massage is not correct");
    }

    @Test(retryAnalyzer = Retry.class)
    public void emptyUserName() {
        logInPage.open();
        logInPage.login("", "");
        assertEquals(logInPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "Error massage is not correct");
    }
}