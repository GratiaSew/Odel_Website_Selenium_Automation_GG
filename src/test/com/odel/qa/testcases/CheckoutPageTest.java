package com.odel.qa.testcases;

import com.odel.qa.base.TestBase;
import com.odel.qa.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    CategoryPage categoryPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    public CheckoutPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        homePage = new HomePage();
        productPage = new ProductPage();
        registerPage = new RegisterPage();
        categoryPage = new CategoryPage();
        loginPage = new LoginPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        Thread.sleep(3000);
        homePage.selectCategory();
        Thread.sleep(3000);
        categoryPage.selectProduct();
        Thread.sleep(3000);
        productPage.selectSizes();
        Thread.sleep(3000);
        productPage.selectOther();
        Thread.sleep(3000);
        productPage.addToCart();
        Thread.sleep(3000);
        cartPage.continueCheckout();
        Thread.sleep(3000);
    }


    @Test(priority = 1)
    public void completeCheckout() throws Exception {
        if (productPage.outOfStock.equals("")) {
            checkoutPage.confirmEmail();
            Thread.sleep(3000);
            checkoutPage.confirmDeliveryAddress();
            Thread.sleep(3000);
            checkoutPage.confirmDeliveryOption();
            Thread.sleep(3000);
            checkoutPage.selectPaymentMethod();
            Thread.sleep(3000);
            checkoutPage.confirmCheckout();
            Thread.sleep(3000);
        } else {
            System.out.println(productPage.outOfStock);
            productPage.directToHome();
        }
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }

}
