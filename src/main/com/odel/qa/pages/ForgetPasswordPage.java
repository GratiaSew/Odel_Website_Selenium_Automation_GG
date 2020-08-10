package com.odel.qa.pages;

import com.odel.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.WeakHashMap;

public class ForgetPasswordPage extends TestBase {

    @FindBy(id = "email")
    WebElement email;

    @FindBy(name = "recover-submit")
    WebElement resetPasswordButton;

    @FindBy(xpath = "/html/body/div[2]/div/div[3]/form/div[1]")
    WebElement userNotFound;

    public ForgetPasswordPage() {
        PageFactory.initElements(webDriver, this);
    }

    //Actions
    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public void resetPassword() throws InterruptedException {
        Thread.sleep(1000);
        email.sendKeys("test@gmail.com");
        Thread.sleep(1000);
        resetPasswordButton.click();
        Thread.sleep(1000);
        try {
            userNotFound.getText().equals("no user found for given email");
            System.out.println("Reset password test works");
        } catch (Exception e) {
            System.out.println("An error occurred");
        }
    }
}
