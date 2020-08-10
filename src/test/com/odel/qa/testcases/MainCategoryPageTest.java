package com.odel.qa.testcases;

import com.odel.qa.base.TestBase;
import com.odel.qa.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainCategoryPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    CategoryPage categoryPage;
    ProductPage productPage;
    CartPage cartPage;
    MainCategoryPage mainCategoryPage;

    public MainCategoryPageTest() {
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
        loginPage = new LoginPage();
        mainCategoryPage = new MainCategoryPage();
        Thread.sleep(4000);
        homePage.clickLogin();
        Thread.sleep(4000);
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(4000);
        homePage.selectAllCategory();
        Thread.sleep(4000);
    }

    @Test(priority = 1)
    public void selectMainCategory() throws InterruptedException {
        mainCategoryPage.selectCategoryItem();
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

    @Test(priority = 2)
    public void mainCategoryPageTitleTest() {
        String title = mainCategoryPage.getPageTitle();
        System.out.println(title);
    }

    @Test(priority = 3)
    public void takeDropdownCount() throws InterruptedException {
        mainCategoryPage.numberOfCategoryPanel();
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}
