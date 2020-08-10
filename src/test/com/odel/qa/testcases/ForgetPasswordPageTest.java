package com.odel.qa.testcases;

import com.odel.qa.base.TestBase;
import com.odel.qa.pages.ForgetPasswordPage;
import com.odel.qa.pages.HomePage;
import com.odel.qa.pages.LoginPage;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgetPasswordPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    ForgetPasswordPage forgetPasswordPage;

    public ForgetPasswordPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        forgetPasswordPage = new ForgetPasswordPage();
        Thread.sleep(3000);
        homePage.clickLogin();
        Thread.sleep(3000);
        loginPage.forgetPassword();
        Thread.sleep(3000);

    }

    @Test(priority = 1)
    public void forgetPasswordTest() throws Exception {
        forgetPasswordPage.resetPassword();
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}
