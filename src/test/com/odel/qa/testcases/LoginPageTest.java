package com.odel.qa.testcases;

import com.odel.qa.base.TestBase;
import com.odel.qa.pages.HomePage;
import com.odel.qa.pages.LoginPage;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        Thread.sleep(3000);
        homePage.clickLogin();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() throws InterruptedException {
        Thread.sleep(3000);
        String title = loginPage.getPageTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Login | Odel.lk");
    }

    @Test(priority = 2)
    public void loginTest() throws InterruptedException {
        Thread.sleep(3000);
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }


}
