package com.odel.qa.pages;

import com.odel.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Random;

public class ProductPage extends TestBase {

    public static String outOfStock;
    CategoryPage categoryPage = new CategoryPage();
    CartPage cartPage = new CartPage();
    HomePage homePage = new HomePage();
    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    @FindBy(className = "product_name")
    WebElement productName;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div/div/div[3]/div/div[5]/form/div[1]/div[2]/div[2]/div/div/span/span[1]/span")
    WebElement sizeDropdown;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div/div/div[3]/div/div[5]/form/div[1]/div[2]/div[3]/div/div/span/span[1]/span")
    WebElement otherDropdown;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div/div/div[3]/div/div[5]/form/div[4]/div[1]")
    WebElement sizeGuide;

    @FindBy(id = "product_add_to_cart")
    WebElement addToCartButton;

    @FindBy(id = "//div[4]/div[2]/i")
    WebElement addToWishlist;

    @FindBy(id = "home-tab")
    WebElement descriptionTab;

    @FindBy(linkText = "Reviews")
    WebElement reviewsTab;

    @FindBy(linkText = "Delivery Info")
    WebElement deliveryInfoTab;

    @FindBy(className = "select2-results__options")
    WebElement dropdown;

    @FindBy(id = "err-msg")
    WebElement outOfStockText;

    @FindBy(xpath = "(//img[@alt='IMG-LOGO'])[2]")
    WebElement directToHome;

    public ProductPage() {
        PageFactory.initElements(webDriver, this);
    }

    //Actions
    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public void selectSizes() throws InterruptedException {
        try {
            sizeDropdown.isDisplayed();
            WebElement element = wait.until(ExpectedConditions.visibilityOf(sizeDropdown));
            element.click();
            WebElement html_list = webDriver.findElement(By.className("select2-results__options"));
            List <WebElement> items = html_list.findElements(By.tagName("li"));
//        int size = items.size();
//        System.out.println("size before remove :"+size);
            items.remove(0);
            int sizeAfterRemove = items.size();
//        System.out.println("size after remove :"+sizeAfterRemove);
            Random random = new Random();
            int randomNumber = random.nextInt(sizeAfterRemove);
            items.get(randomNumber).click();
            Thread.sleep(3000);
        } catch (NoSuchElementException e) {
//            throw new RuntimeException("This is where you put the message");
            System.out.println("There are no sizes to be selected");
        }
    }

    public void selectOther() throws InterruptedException {
        try {
            otherDropdown.isDisplayed();
            WebElement element = wait.until(ExpectedConditions.visibilityOf(otherDropdown));
            element.click();
            WebElement html_list = webDriver.findElement(By.className("select2-results__options"));
            List <WebElement> items = html_list.findElements(By.tagName("li"));
            items.remove(0);
            int sizeAfterRemove = items.size();
            Random random = new Random();
            int randomNumber = random.nextInt(sizeAfterRemove);
            items.get(randomNumber).click();
            Thread.sleep(3000);
        } catch (NoSuchElementException e) {
            System.out.println("There are no other sections to be selected");
        }
    }

    public void addToCart() {
        outOfStock = outOfStockText.getText();
        System.out.println(outOfStock);
        if (outOfStock.equals("")) {
            addToCartButton.click();
        } else {
            System.out.println(outOfStock);
        }
    }

    public void directToHome() throws InterruptedException {
        System.out.println("Cannot checkout as the product is out of stock");
        Thread.sleep(3000);
        directToHome.click();
    }

}

