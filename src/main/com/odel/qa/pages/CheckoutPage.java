package com.odel.qa.pages;

import com.odel.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.event.WindowEvent;

public class CheckoutPage extends TestBase {

    @FindBy(id = "inputEmail1")
    WebElement email;

    @FindBy(id = "SubmitDeliveryAddress")
    WebElement submitEmailButton;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "address")
    WebElement address;

    @FindBy(id = "mb1")
    WebElement mobileNumber;

    @FindBy(id = "specialInstructions")
    WebElement specialInstructions;

    @FindBy(id = "SubmitDeliveryAddress")
    WebElement submitDeliveryAddressButton;

    @FindBy(xpath = "//*[@id=\"deliveryOptionsList\"]/div/div/div/div[3]/div/label")
    WebElement deliveryOption1;

    @FindBy(xpath = "//*[@id=\"paymentOptionsList\"]/div/div/div[1]/label")
    WebElement frimi;

    @FindBy(xpath = "//*[@id=\"paymentOptionsList\"]/div/div/div[2]/label")
    WebElement visa;

    @FindBy(xpath = "//*[@id=\"paymentOptionsList\"]/div/div/div[3]/label")
    WebElement amex;

    @FindBy(xpath = "//*[@id=\"paymentOptionsList\"]/div/div/div[4]/label")
    WebElement voucher;

    @FindBy(xpath = "//*[@id=\"checkout_details_container\"]/div/div[2]/button")
    WebElement placeOrder;

    @FindBy(xpath = "//*[@id=\"order_items_list\"]/div/li/div[1]/div")
    WebElement removeItemButton;

    public CheckoutPage() {
        PageFactory.initElements(webDriver, this);
    }

    //Actions
    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public void confirmEmail() {
        email.sendKeys("gratiasew1234@gmail.com");
        submitEmailButton.click();
    }

    public void confirmDeliveryAddress() throws InterruptedException {
        Thread.sleep(1000);
        firstName.sendKeys("Test");
        Thread.sleep(1000);
        lastName.sendKeys("Test");
        Thread.sleep(1000);
        address.sendKeys("Test");
        Thread.sleep(1000);
        Select dropCountry = new Select(webDriver.findElement(By.id("country")));
        Thread.sleep(1000);
        dropCountry.selectByVisibleText("Sri Lanka");
        Thread.sleep(1000);
        Select dropCity = new Select(webDriver.findElement(By.id("city")));
        Thread.sleep(1000);
        dropCity.selectByVisibleText("Colombo 01: Colombo Fort");
        Thread.sleep(1000);
        mobileNumber.sendKeys("0768327047");
        Thread.sleep(1000);
        specialInstructions.sendKeys("This is a test instruction");
        Thread.sleep(1000);
        submitDeliveryAddressButton.click();
    }

    public void confirmDeliveryOption() {
        deliveryOption1.click();
    }

    public void selectPaymentMethod() {
        if (frimi.isDisplayed()) {
            frimi.click();
            System.out.println("Frimi option is selected");
        } else if (visa.isDisplayed()) {
            visa.click();
            System.out.println("Visa option is selected");
        } else if (amex.isDisplayed()) {
            amex.click();
            System.out.println("Amex option is selected");
        } else if (voucher.isDisplayed()) {
            voucher.click();
            System.out.println("Voucher option is selected");
        } else {
            System.out.println("Payment methods are not available");
        }
    }

    public void confirmCheckout() {
        placeOrder.click();
        System.out.println("Confirm Checkout button is clicked");
    }

    public void removeCartItem() {
        removeItemButton.click();
        System.out.println("Cart item is removed");
    }


}
