package com.odel.qa.testcases;

import com.odel.qa.base.TestBase;
import com.odel.qa.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;

public class CategoryPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    CategoryPage categoryPage;
    ProductPage productPage;
    CartPage cartPage;

    public CategoryPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        homePage = new HomePage();
        registerPage = new RegisterPage();
        categoryPage = new CategoryPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        homePage.selectCategory();
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void CategoryPageTitleTest() {
        String title = categoryPage.getPageTitle();
        System.out.println(title);
    }

    @Test(priority = 2)
    public void addProductToCart() throws InterruptedException {
        categoryPage.selectProduct();
        Thread.sleep(3000);
        productPage.selectSizes();
        productPage.selectOther();
        productPage.addToCart();
        Thread.sleep(3000);
        cartPage.continueCheckout();
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }

}
