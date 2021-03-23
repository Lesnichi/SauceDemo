package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogInTestDataProvider extends BaseTest {

    @DataProvider(name = "Input for login")
    public Object[][] inputForLogin() {
        return new Object[][]{
                {userNameOK, "123", "Epic sadface: Username and password do not match any user in this service"},
                {"", "", "Epic sadface: Username is required"},
        };
    }

    @Test(dataProvider = "Input for login", description = "login test with DataProvider")
    public void login(String user, String password, String errorMessage) {
        logInPage.open();
        logInPage.login(user, password);
        assertEquals(logInPage.getErrorMassage(),
                errorMessage,
                "Error massage is not correct");
    }


}