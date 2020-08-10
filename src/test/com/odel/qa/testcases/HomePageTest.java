package com.odel.qa.testcases;

import com.odel.qa.base.TestBase;
import com.odel.qa.pages.CategoryPage;
import com.odel.qa.pages.HomePage;
import com.odel.qa.pages.LoginPage;
import com.odel.qa.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    CategoryPage categoryPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        registerPage = new RegisterPage();
        categoryPage = new CategoryPage();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void homePageTitleTest() throws InterruptedException {
        Thread.sleep(4000);
        String title = homePage.getPageTitle();
        Assert.assertEquals(title, "Home | Odel.lk");
    }

    @Test(priority = 2)
    public void clickLoginTest() throws InterruptedException {
        Thread.sleep(4000);
        loginPage = homePage.clickLogin();
        System.out.println("Login button is clicked");
        String title = loginPage.getPageTitle();
        Assert.assertEquals(title, "Login | Odel.lk");
    }

    @Test(priority = 3)
    public void clickRegisterTest() throws InterruptedException {
        Thread.sleep(4000);
        registerPage = homePage.clickRegister();
        System.out.println("Register button is clicked");
        String title = registerPage.getPageTitle();
        Assert.assertEquals(title, "Register | Odel.lk");
    }

    @Test(priority = 4)
    public void clickWishListTest() throws InterruptedException {
        homePage.clickWishList();
        Thread.sleep(4000);
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(4000);
        homePage.clickWishList();
        Thread.sleep(4000);
        System.out.println(webDriver.getTitle());
        String title = webDriver.getTitle();
        System.out.println(title);
        System.out.println("User wish-list is loaded");
    }

    @Test(priority = 5)
    public void selectCategory() throws InterruptedException {
        Thread.sleep(4000);
        homePage.selectCategory();
        System.out.println("Category is selected");
        System.out.println(webDriver.getTitle());
    }

    @Test(priority = 6)
    public void selectProduct() throws InterruptedException {
        Thread.sleep(4000);
        homePage.selectCategory();
        categoryPage.selectProduct();
        System.out.println("Product is selected");
    }

    @Test(priority = 7)
    public void searchItem() throws InterruptedException {
        Thread.sleep(4000);
        homePage.searchItem();
        System.out.println("Searched for an item");
    }

    @Test(priority = 8)
    public void selectCategoryFromAllCategory() throws Exception {
        Thread.sleep(4000);
        homePage.selectAllCategory();
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }

}
