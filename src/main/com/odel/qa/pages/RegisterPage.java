package com.odel.qa.pages;

import com.odel.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends TestBase {

    //Page Factory
    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "mobile-number")
    WebElement mobileNumber;

    @FindBy(id = "new_pswrd")
    WebElement password;

    @FindBy(xpath = "/html/body/div[2]/div/div[5]/form/div[5]/a")
    WebElement forgotPassButton;

    @FindBy(xpath = "/html/body/div[2]/div/div[5]/form/div[7]/div/span/a")
    WebElement login;

    @FindBy(id = "save_btn")
    WebElement signUp;

    public RegisterPage() {
        PageFactory.initElements(webDriver, this);
    }

    //Actions
    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public RegisterPage register() {
        signUp.click();
        return new RegisterPage();
    }

}
