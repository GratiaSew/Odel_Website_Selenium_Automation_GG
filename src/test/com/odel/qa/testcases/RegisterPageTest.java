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


public class RegisterPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    CategoryPage categoryPage;

    public RegisterPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        categoryPage = new CategoryPage();
        homePage.clickRegister();
    }

    @Test(priority = 1)
    public void registerPageTitleCheck() {
        String title = registerPage.getPageTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Register | Odel.lk");
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}
