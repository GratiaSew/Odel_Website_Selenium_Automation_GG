package com.odel.qa.pages;

import com.odel.qa.base.TestBase;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends TestBase {

    ProductPage productPage;

    @FindBy(xpath = "//*[@id=\"dynamic_cart\"]/div[2]/div[2]/div/i")
    WebElement cartCloseButton;

    @FindBy(xpath = "//*[@id=\"dynamic_cart\"]/div[2]/div[3]/ul")
    WebElement cartList;

    @FindBy(xpath = "//*[@id=\"dynamic_cart\"]/div[2]/div[3]/ul/li/div[2]/div/div[2]/div/div[1]/button")
    WebElement quantityIncreaseButton;

    @FindBy(xpath = "//*[@id=\"dynamic_cart\"]/div[2]/div[3]/ul/li/div[2]/div/div[2]/div/div[3]/button")
    WebElement quantityDecreaseButton;

    @FindBy(xpath = "//*[@id=\"dynamic_cart\"]/div[2]/div[3]/ul/li/div[1]/div")
    WebElement removeItemButton;

    @FindBy(id = "dynamic_cart_deliver_btn")
    WebElement getDeliveredButton;

    public CartPage() {
        PageFactory.initElements(webDriver, this);
    }

    //Actions
    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public void closeCart() {
        cartCloseButton.click();
        System.out.println("Cart slider is closed");
    }

    public void changeQuantity() {
        quantityIncreaseButton.click();
        System.out.println("Quantity has been increased");
        quantityDecreaseButton.click();
        System.out.println("Quantity has been decreased");
    }

    public void removeItemFromCart() {
        removeItemButton.click();
        System.out.println("Item has been removed from the cart");
    }

    public void continueCheckout() {
        productPage = new ProductPage();
        System.out.println(productPage.outOfStock);
        if (productPage.outOfStock.equals("")) {
            getDeliveredButton.click();
            System.out.println("Clicked Get Delivered button");
        } else {
            System.out.println(productPage.outOfStock);
        }
    }


}
