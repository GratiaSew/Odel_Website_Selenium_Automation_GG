package com.odel.qa.pages;

import com.odel.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class InfoPage extends TestBase {

    @FindBy(xpath = "/html/body/div[1]/div[2]/footer/div/div/div[1]/div/ul[1]/li[2]/a")
    WebElement contactUs;
    @FindBy(xpath = "/html/body/div[1]/div[2]/footer/div/div/div[1]/div/ul[1]/li[3]/a")
    WebElement servicePayment;
    @FindBy(xpath = "/html/body/div[1]/div[2]/footer/div/div/div[1]/div/ul[1]/li[4]/a")
    WebElement storeLocator;
    @FindBy(xpath = "/html/body/div[1]/div[2]/footer/div/div/div[2]/div/ul[1]/li/a")
    WebElement aboutUs;
    @FindBy(xpath = "/html/body/div[1]/div[2]/footer/div/div/div[2]/div/ul[2]/li/a")
    WebElement odelMagazine;
    @FindBy(xpath = "/html/body/div[1]/div[2]/footer/div/div/div[2]/div/ul[3]/li[1]/a")
    WebElement visitMysoftlogic;
    @FindBy(xpath = "/html/body/div[1]/div[2]/footer/div/div/div[2]/div/ul[3]/li[2]/a")
    WebElement visitGlomark;
    @FindBy(xpath = "/html/body/div[1]/div[2]/footer/div/div/div[3]/div/ul/li[3]/a")
    WebElement termsOfUse;
    @FindBy(xpath = "/html/body/div[1]/div[2]/footer/div/div/div[3]/div/ul/li[4]/a")
    WebElement privacyPloicy;
    @FindBy(xpath = "/html/body/div[1]/div[2]/footer/div/div/div[3]/div/ul/li[5]/a")
    WebElement faq;
    @FindBy(id = "contact_form_name")
    WebElement name;
    @FindBy(id = "contact_form_email")
    WebElement email;
    @FindBy(id = "contact_form_phone")
    WebElement phone;
    @FindBy(id = "contact_form_message")
    WebElement message;
    @FindBy(xpath = "//button[text()=\"Send Message\"]")
    WebElement submitButton;
    @FindBy(id = "exampleInputEmail1")
    WebElement servicePaymentEmail;
    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "LastName")
    WebElement lastName;
    @FindBy(id = "category")
    WebElement categoryDropdown;
    @FindBy(id = "amount")
    WebElement amount;
    @FindBy(id = "address")
    WebElement comments;
    @FindBy(id = "mb1")
    WebElement primaryPhoneNumber;
    @FindBy(xpath = "//label/span")
    WebElement mastercard;
    @FindBy(xpath = "//div[2]/label/span")
    WebElement americanExpress;
    @FindBy(xpath = "//div[3]/label/span")
    WebElement freemi;
    @FindBy(id = "service_payment_btn")
    WebElement servicePaymentButton;

    public InfoPage() {
        PageFactory.initElements(webDriver, this);
    }

    public void contactUs() throws InterruptedException {
        Thread.sleep(4000);
        contactUs.click();
        Thread.sleep(3000);
        String title = webDriver.getTitle();
        System.out.println("Title: " + title);
        name.sendKeys("Test Test");
        email.sendKeys("gratiasew1234@gmail.com");
        phone.sendKeys("0768327047");
        message.sendKeys("This is a test message");
        submitButton.click();
        System.out.println("Your message is sent to the authorities");
    }

    public void selectPaymentMethod() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(2);
        int div = randomNumber;
        System.out.println(div);

        switch (div) {
            case 0:
                mastercard.click();
                System.out.println(" mastercard click");
                break;
            case 1:
                americanExpress.click();
                System.out.println(" americanExpress click");
                break;
            case 2:
                freemi.click();
                System.out.println(" freemi click");
                break;
        }
    }

    public void servicePayment() throws InterruptedException {
        Thread.sleep(3000);
        servicePayment.click();
        Thread.sleep(2000);
        String title = webDriver.getTitle();
        System.out.println("Title: " + title);
        servicePaymentEmail.sendKeys("gratiasew1234@gmail.com");
        Thread.sleep(1000);
        firstName.sendKeys("test");
        Thread.sleep(1000);
        lastName.sendKeys("test");
        Thread.sleep(1000);
        Select dropdown = new Select(categoryDropdown);

        String[] options = new String[]{"Office Automation Related Payments", "Softlogic Retail Pvt Ltd", "Other",
                "AC Service", "Samsung Galaxy S20 Pre-Order", "Glomark Order Payments", "Odel Delight Hamper Payments",
                "Nike Payment", "Odel Voucher Payments- Additional Payments", "Softlogic Product/Order Related Payments",
                "SCB Staff offer for Mobile Phones", "ODEL Product/Order Related Payments"};

        int numberOfOptions = options.length;
        Random random = new Random();
        int randomNumber = random.nextInt(numberOfOptions);
        dropdown.selectByVisibleText(options[randomNumber]);

        Thread.sleep(1000);
        amount.sendKeys("50000");
        Thread.sleep(1000);
        comments.sendKeys("This is a test comment");
        Thread.sleep(1000);
        primaryPhoneNumber.sendKeys("768327047");
        Thread.sleep(1000);
        selectPaymentMethod();
        Thread.sleep(3000);
        servicePaymentButton.click();
        Thread.sleep(3000);
    }

    public void storeLocator() throws InterruptedException {
        Thread.sleep(3000);
        storeLocator.click();
        String title = webDriver.getTitle();
        System.out.println("Title: " + title);
    }

    public void aboutUs() throws InterruptedException {
        Thread.sleep(3000);
        aboutUs.click();
        String title = webDriver.getTitle();
        System.out.println("Title: " + title);
    }

    public void odelMagazine() throws InterruptedException {
        Thread.sleep(3000);
        odelMagazine.click();
        String title = webDriver.getTitle();
        System.out.println("Title: " + title);
    }

    public void visitMysoftlogic() throws InterruptedException {
        Thread.sleep(3000);
        visitMysoftlogic.click();
        String title = webDriver.getTitle();
        System.out.println("Title: " + title);
    }

    public void visitGlomark() throws InterruptedException {
        Thread.sleep(3000);
        visitGlomark.click();
        String title = webDriver.getTitle();
        System.out.println("Title: " + title);
    }

    public void termsOfUse() throws InterruptedException {
        Thread.sleep(3000);
        termsOfUse.click();
        String title = webDriver.getTitle();
        System.out.println("Title: " + title);
    }

    public void privacyPolicy() throws InterruptedException {
        Thread.sleep(3000);
        privacyPloicy.click();
        String title = webDriver.getTitle();
        System.out.println("Title: " + title);
    }

    public void faq() throws InterruptedException {
        Thread.sleep(3000);
        faq.click();
        String title = webDriver.getTitle();
        System.out.println("Title: " + title);
    }

}
