package com.odel.qa.testcases;

import com.odel.qa.base.TestBase;
import com.odel.qa.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    CategoryPage categoryPage;
    ProductPage productPage;
    CartPage cartPage;
    MyAccountPage myAccountPage;

    public MyAccountPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        categoryPage = new CategoryPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        myAccountPage = new MyAccountPage();
        Thread.sleep(4000);
        homePage.clickLogin();
        Thread.sleep(4000);
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(4000);
        homePage.clickMyAccount();
        Thread.sleep(4000);
    }

    @Test(priority = 1)
    public void saveChangedDetails() throws InterruptedException {
        myAccountPage.changeAccountDetails();
        Thread.sleep(3000);
        myAccountPage.saveChanges();
    }

    @Test(priority = 2)
    public void cancelChangedDetails() throws InterruptedException {
        myAccountPage.changeAccountDetails();
        myAccountPage.cancelChanges();
    }

    @Test(priority = 3)
    public void selectOrder() throws InterruptedException {
        Thread.sleep(4000);
        myAccountPage.myOrderList();
        Thread.sleep(4000);
    }

    @Test(priority = 4)
    public void returnAndRefund() throws InterruptedException {
        Thread.sleep(4000);
        myAccountPage.returnAndRefund();
        Thread.sleep(4000);
    }

    @Test(priority = 5)
    public void myWishlist() throws InterruptedException {
        Thread.sleep(4000);
        myAccountPage.wishlist();
        Thread.sleep(4000);
        productPage.selectSizes();
        Thread.sleep(3000);
        productPage.selectOther();
        Thread.sleep(3000);
        productPage.addToCart();
        Thread.sleep(3000);
        cartPage.continueCheckout();
        Thread.sleep(3000);
    }

    @Test(priority = 6)
    public void vouchers() throws InterruptedException {
        Thread.sleep(4000);
        myAccountPage.myVouchers();
        Thread.sleep(4000);
    }

    @Test(priority = 7)
    public void myLoyalty() throws InterruptedException {
        Thread.sleep(4000);
        myAccountPage.myLoyalty();
        Thread.sleep(4000);
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }

}
