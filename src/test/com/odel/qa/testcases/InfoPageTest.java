package com.odel.qa.testcases;

import com.odel.qa.base.TestBase;
import com.odel.qa.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InfoPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    CategoryPage categoryPage;
    InfoPage infoPage;

    public InfoPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        registerPage = new RegisterPage();
        categoryPage = new CategoryPage();
        loginPage = new LoginPage();
        infoPage = new InfoPage();
    }

    @Test(priority = 1)
    public void contactUsTest() throws InterruptedException {
        infoPage.contactUs();
    }

    @Test(priority = 2)
    public void servicePaymentTest() throws InterruptedException {
        infoPage.servicePayment();
    }

    @Test(priority = 3)
    public void storeLocatorTest() throws InterruptedException {
        infoPage.storeLocator();
    }

    @Test(priority = 4)
    public void aboutUsTest() throws InterruptedException {
        infoPage.aboutUs();
    }

    @Test(priority = 5)
    public void odelMagazineTest() throws InterruptedException {
        infoPage.odelMagazine();
    }

    @Test(priority = 6)
    public void visitMysoftlogicTest() throws InterruptedException {
        infoPage.visitMysoftlogic();
    }

    @Test(priority = 7)
    public void visitGlomarkTest() throws InterruptedException {
        infoPage.visitGlomark();
    }

    @Test(priority = 8)
    public void termsOfUseTest() throws InterruptedException {
        infoPage.termsOfUse();
    }

    @Test(priority = 9)
    public void privacyPolicyTest() throws InterruptedException {
        infoPage.privacyPolicy();
    }

    @Test(priority = 10)
    public void faqTest() throws InterruptedException {
        infoPage.faq();
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}
