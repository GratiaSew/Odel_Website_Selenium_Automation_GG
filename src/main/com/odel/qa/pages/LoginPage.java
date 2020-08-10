package com.odel.qa.pages;

import com.odel.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends TestBase {

    //Page Factory
    @FindBy(name = "_username")
    WebElement username;

    @FindBy(name = "_password")
    WebElement password;

    @FindBy(xpath = "/html/body/div[2]/div/div[5]/form/div[2]/button")
    WebElement signInButton;

    @FindBy(xpath = "/html/body/div[2]/div/div[5]/form/div[1]/a")
    WebElement forgotPassButton;

    @FindBy(xpath = "/html/body/div[2]/div/div[5]/form/div[3]/div/span/a")
    WebElement signUpButton;
    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    public LoginPage() {
        PageFactory.initElements(webDriver, this);
    }

    //Actions
    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public HomePage login(String un, String pwd) {
        WebElement visibleUsername = wait.until(ExpectedConditions.visibilityOf(username));
        visibleUsername.sendKeys(un);
        WebElement visiblePassword = wait.until(ExpectedConditions.visibilityOf(password));
        visiblePassword.sendKeys(pwd);
        WebElement visibleSignInButton = wait.until(ExpectedConditions.visibilityOf(signInButton));
        visibleSignInButton.click();
        return new HomePage();
    }

    public RegisterPage signUp() {
        signUpButton.click();
        return new RegisterPage();
    }

    public ForgetPasswordPage forgetPassword() {
        forgotPassButton.click();
        return new ForgetPasswordPage();
    }

}
