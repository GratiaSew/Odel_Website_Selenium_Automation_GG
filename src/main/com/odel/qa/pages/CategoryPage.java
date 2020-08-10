package com.odel.qa.pages;

import com.odel.qa.base.TestBase;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.Timer;

public class CategoryPage extends TestBase {

    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    @FindBy(xpath = "//div[@id='search_result']/div[5]/div/div/a/img")
    WebElement product1;

    @FindBy(xpath = "//div[@id='search_result']/div[2]/div/div/a/img")
    WebElement product2;

    @FindBy(xpath = "//div[@id='search_result']/div[7]/div/div/a/img")
    WebElement product3;

    @FindBy(xpath = "//div[@id='search_result']/div[8]/div/div/a/img")
    WebElement product4;

    @FindBy(xpath = "//div[@id='search_result']/div[12]/div/div/a/img")
    WebElement product5;

    @FindBy(xpath = "//div[@id='search_result']/div[20]/div/div/a/img")
    WebElement product6;

    @FindBy(xpath = "//div[@id='search_result']/div[17]/div/div/a/img")
    WebElement product7;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div/div/div[3]/div/div[1]")
    WebElement productName;

    Random rand = new Random();

    public CategoryPage() {
        PageFactory.initElements(webDriver, this);
    }

    //Actions
    public String getPageTitle() {
        return webDriver.getTitle();
    }


    public void selectProduct() {
        int randomNumber = rand.nextInt(7);
        int div = randomNumber;
        System.out.println(div);
        switch (div) {
            case 0:
                WebElement element1 = wait.until(ExpectedConditions.visibilityOf(product1));
                element1.click();
                System.out.println(" product1 click");
                break;
            case 1:
                WebElement element2 = wait.until(ExpectedConditions.visibilityOf(product2));
                element2.click();
                System.out.println(" product2 click");
                break;
            case 2:
                WebElement element3 = wait.until(ExpectedConditions.visibilityOf(product3));
                element3.click();
                System.out.println(" product3 click");
                break;
            case 3:
                WebElement element4 = wait.until(ExpectedConditions.visibilityOf(product4));
                element4.click();
                System.out.println(" product4 click");
                break;
            case 4:
                WebElement element5 = wait.until(ExpectedConditions.visibilityOf(product5));
                element5.click();
                System.out.println(" product5 click");
                break;
            case 5:
                WebElement element6 = wait.until(ExpectedConditions.visibilityOf(product6));
                element6.click();
                System.out.println(" product6 click");
                break;
            case 6:
                WebElement element7 = wait.until(ExpectedConditions.visibilityOf(product7));
                element7.click();
                System.out.println(" product7 click");
                break;
        }

    }
}
