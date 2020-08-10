package com.odel.qa.pages;

import com.odel.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class MyAccountPage extends TestBase {

    @FindBy(id = "v-myaccount")
    WebElement myAccount;

    @FindBy(id = "v-myorders")
    WebElement myOrders;

    @FindBy(id = "v-refund")
    WebElement returnAndRefund;

    @FindBy(id = "v-wishlist")
    WebElement myWishlist;

    @FindBy(id = "v-evouchers")
    WebElement eVouchers;

    @FindBy(id = "v-loyalty")
    WebElement loyalty;

    @FindBy(xpath = "//*[@id=\"v-editprofile\"]/div/span")
    WebElement editPersonalData;

    @FindBy(id = "edit_title")
    WebElement editTitle;

    @FindBy(id = "edit_first_name")
    WebElement editFirstName;

    @FindBy(id = "edit_last_name")
    WebElement editLastName;

    @FindBy(id = "edit_email_name")
    WebElement editEmail;

    @FindBy(id = "edit_dob_name")
    WebElement editDataOfBirth;

    @FindBy(id = "edit_postal_code")
    WebElement editPostalCode;

    @FindBy(id = "edit_address")
    WebElement editAddress;

    @FindBy(id = "edit_country")
    WebElement editCountry;

    @FindBy(id = "edit_city")
    WebElement editCity;

    @FindBy(id = "edit_primary_tel")
    WebElement primaryPhone;

    @FindBy(id = "edit_secondary_tel")
    WebElement secondaryPhone;

    @FindBy(xpath = "//div[@id='save_edit_profile']/div/span")
    WebElement saveChanges;

    @FindBy(xpath = "//*[@id=\"cancel_edit_profile\"]/div/span")
    WebElement cancelChanges;

    @FindBy(xpath = "//div[@id='v-pills-profile']/div/a/div[2]/div/div[2]/div[2]")
    WebElement selectOrder;

    @FindBy(xpath = "//*[@id=\"v-pills-messages\"]/div/div/div[3]/div[2]/div/a")
    WebElement favoriteItem;

    @FindBy(id = "order_number_input")
    WebElement orderNumber;

    @FindBy(id = "verify_order_button")
    WebElement verifyOrder;

    @FindBy(xpath = "//*[@id=\"v-pills-evouchers\"]/div[1]/div[1]")
    WebElement availableEVouchers;

    @FindBy(xpath = "//*[@id=\"v-pills-evouchers\"]/div[2]/div[1]")
    WebElement usedEVouchers;

    @FindBy(xpath = "//*[@id=\"v-pills-evouchers\"]/div[3]/div[1]")
    WebElement sharedEVouchers;

    @FindBy(xpath = "//*[@id=\"v-pills-loyalty\"]/div[2]/div[1]\n")
    WebElement pointsBalance;

    @FindBy(xpath = "//*[@id=\"v-pills-loyalty\"]/div[3]/div[1]")
    WebElement onlineRedeemHistory;

    Random random = new Random();

    public MyAccountPage() {
        PageFactory.initElements(webDriver, this);
    }

    //Actions
    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public void changeAccountDetails() throws InterruptedException {
        Thread.sleep(3000);
        myAccount.click();
        Thread.sleep(3000);
        editPersonalData.click();
        Thread.sleep(3000);
//        select title
        List <WebElement> items = editTitle.findElements(By.tagName("option"));
        int size = items.size();
        System.out.println("title count: " + size);
        int randomNumber = random.nextInt(size);
        items.get(randomNumber).click();
        editFirstName.clear();
        editFirstName.sendKeys("Test 1");
        editLastName.clear();
        editLastName.sendKeys("Test 1");
//        editDataOfBirth.click();
//        editDataOfBirth.sendKeys("1996-02-13");
        editPostalCode.clear();
        editPostalCode.sendKeys("24600");
        editAddress.clear();
        editAddress.sendKeys("Test Address");
//        select country
        Select dropCountry = new Select(editCountry);
        dropCountry.selectByVisibleText("Sri Lanka");
//        select city
        Select dropCity = new Select(editCity);
        dropCity.selectByVisibleText("Colombo 01: Colombo Fort");
//        change phone number
        secondaryPhone.clear();
        secondaryPhone.sendKeys("0762564125");
//        WebElement visibleSaveChanges = wait.until(ExpectedConditions.visibilityOf(saveChanges));
//        visibleSaveChanges.click();

    }

    public void saveChanges() {
        saveChanges.click();
    }

    public void cancelChanges() {
        cancelChanges.click();
    }

    public void myOrderList() throws InterruptedException {
        myOrders.click();
        Thread.sleep(3000);
        selectOrder.click();
    }

    public void returnAndRefund() throws InterruptedException {
        returnAndRefund.click();
        Thread.sleep(3000);
        orderNumber.click();
        verifyOrder.click();
    }

    public void wishlist() throws InterruptedException {
        myWishlist.click();
        Thread.sleep(3000);
        favoriteItem.click();
    }

    public void myVouchers() throws InterruptedException {
        eVouchers.click();
        Thread.sleep(3000);
        availableEVouchers.click();
        usedEVouchers.click();
        sharedEVouchers.click();
    }

    public void myLoyalty() throws InterruptedException {
        loyalty.click();
        Thread.sleep(3000);
        pointsBalance.click();
        onlineRedeemHistory.click();
    }

}
