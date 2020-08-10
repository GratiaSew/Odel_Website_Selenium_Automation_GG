package com.odel.qa.pages;

import com.odel.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.awt.windows.ThemeReader;

import java.util.List;
import java.util.Random;

public class HomePage extends TestBase {

    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    //Page Factory
    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[1]/div/nav/div[2]/div/i")
    WebElement searchIcon;

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[1]/div/nav/div[2]/a[1]/i")
    WebElement cartIcon;

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[1]/div/nav/div[2]/a[2]/i")
    WebElement wishlist;

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[1]/div/nav/div[3]/ul/li/a/i")
    WebElement accountCircle;

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[1]/div/nav/div[3]/ul/li/ul/a[1]")
    WebElement login;

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[1]/div/nav/div[3]/ul/li/ul/a[2]")
    WebElement register;

    @FindBy(linkText = "Women")
    WebElement womenCategory;

    @FindBy(linkText = "Men")
    WebElement menCategory;

    @FindBy(linkText = "Kids")
    WebElement kidCategory;

    @FindBy(linkText = "Odel Sports")
    WebElement odelSportCategory;

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[4]/div/form/input")
    WebElement textbox;

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[1]/div/nav/div[1]/ul/li[1]/a")
    WebElement allCategories;

    @FindBy(linkText = "My Account")
    WebElement myAccount;

    Random rand = new Random();


    public HomePage() {
        PageFactory.initElements(webDriver, this);
    }

    //Actions
    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public LoginPage clickLogin() {
        Actions action = new Actions(webDriver);
        action.moveToElement(accountCircle).perform();
        login.click();
        return new LoginPage();
    }

    public void clickMyAccount() {
        Actions action = new Actions(webDriver);
        action.moveToElement(accountCircle).perform();
        myAccount.click();
    }

    public RegisterPage clickRegister() {
        Actions action = new Actions(webDriver);
        action.moveToElement(accountCircle).perform();
        register.click();
        return new RegisterPage();
    }

    public void clickWishList() {
        WebElement visibleWishlist = wait.until(ExpectedConditions.visibilityOf(wishlist));
        visibleWishlist.click();
    }

    public void selectCategory() {

        int randomNumber = rand.nextInt(4);
        int div = randomNumber;
        switch (div) {
            case 0:
                WebElement element1 = wait.until(ExpectedConditions.visibilityOf(womenCategory));
                element1.click();
                System.out.println("clicked women category");
                break;
            case 1:
                WebElement element2 = wait.until(ExpectedConditions.visibilityOf(menCategory));
                element2.click();
                System.out.println("clicked men category");
                break;
            case 2:
                WebElement element3 = wait.until(ExpectedConditions.visibilityOf(kidCategory));
                element3.click();
                System.out.println("clicked kid category");
                break;
            case 3:
                WebElement element4 = wait.until(ExpectedConditions.visibilityOf(odelSportCategory));
                element4.click();
                System.out.println("click sports category");
                break;
        }
    }

    public void selectAllCategory() throws InterruptedException {
        Thread.sleep(3000);
        allCategories.click();
        WebElement html_list = webDriver.findElement(By.className("sub-menu"));
        List <WebElement> items = html_list.findElements(By.tagName("li"));
        int size = items.size();
        int randomCategory = rand.nextInt(size);
        items.get(randomCategory).click();
        Thread.sleep(3000);
    }

    public void searchItem() {
        searchIcon.click();
        textbox.sendKeys("Dress");
        textbox.submit();
    }


}
