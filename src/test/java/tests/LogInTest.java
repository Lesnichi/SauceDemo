package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogInTest extends BaseTest {

    @Test
    public void wrongPassword() {
        logInPage.open();
        logInPage.login("standard_user", "123");
        assertEquals(logInPage.getErrorMassage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error massage is not correct");
    }

    @Test
    public void emptyUserName() {
        logInPage.open();
        logInPage.login("", "");
        assertEquals(logInPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "Error massage is not correct");
    }
}