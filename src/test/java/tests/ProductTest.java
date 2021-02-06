package tests;

import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test
    public void productShouldBeAvailableInCart() {
        logInPage.open();
        logInPage.login("standard_user", "secret_sauce");
        productPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productPage.buyProduct("Sauce Labs Fleece Jacket");
    }
}