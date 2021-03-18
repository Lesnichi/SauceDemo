package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void checkAddedTwoProducts() {
        logInPage.open();
        logInPage.login("standard_user", "secret_sauce");
        productPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productPage.buyProduct("Sauce Labs Fleece Jacket");
        productPage.goToCart();
        Assert.assertEquals(cartPage.getCountOfProduct(), 2, "Не добавлено 2 продукта в корзину");
    }

    @Test
    public void backToProductsPage() {
        logInPage.open();
        logInPage.login("standard_user", "secret_sauce");
        productPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productPage.buyProduct("Sauce Labs Fleece Jacket");
        productPage.goToCart();
        cartPage.backToProductPage();
        Assert.assertEquals(productPage.getProductLabel(), "Products", "Переход на страницу продукты не удался");
    }

    @Test
    public void backToProductPage() {
        logInPage.open();
        logInPage.login(userNameOK, passwordOK);
        productPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productPage.buyProduct("Sauce Labs Fleece Jacket");
        productPage.goToCart();
        Assert.assertEquals(cartPage.getCountOfProduct(), 2, "Не добавлено 2 продукта в корзину");
    }

    @Test
    public void removeChecking() {
        logInPage.open();
        logInPage.login("standard_user", "secret_sauce");
        productPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productPage.buyProduct("Sauce Labs Fleece Jacket");
        productPage.buyProduct("Sauce Labs Backpack");
        productPage.goToCart();
        cartPage.removeProductFromCart("Sauce Labs Backpack");
        cartPage.removeProductFromCart("Sauce Labs Fleece Jacket");
        Assert.assertEquals(cartPage.getCountOfProduct(), 1, "Не удалены товары из карзины");
    }

    @Test (retryAnalyzer = Retry.class)
    public void checkoutButtonChecking() {
        logInPage.open();
        logInPage.login("standard_user", "secret_sauce");
        productPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productPage.goToCart();
        cartPage.goToCheckout();
        checkOutPage.isCheckOutPageOpened();
        Assert.assertEquals(checkOutPage.getCheckOutLabel(), "Checkout: Your Information", "Кнопка CHECKOUT не сработала");
    }
}
