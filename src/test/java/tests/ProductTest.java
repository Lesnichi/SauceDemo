package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void productShouldBeAvailableInCart() {
        logInPage
                .open()
                .login(userNameOK, passwordOK);
        productPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productPage.buyProduct("Sauce Labs Fleece Jacket");
        Assert.assertEquals(cartPage.getCountOfProduct(), 2, "В корзине не 2 товара");
    }
}