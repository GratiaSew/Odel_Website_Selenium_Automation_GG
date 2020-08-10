package com.odel.qa.pages;

import com.odel.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class MainCategoryPage extends TestBase {

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/a/div/div/img")
    WebElement categoryItem1;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div/div[2]/a/div/div/img")
    WebElement categoryItem2;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div/div[3]/a/div/div/img")
    WebElement categoryItem3;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div/div[4]/a/div/div/img")
    WebElement categoryItem4;

    @FindBy(className = "category-collapse-button active collapsed")
    WebElement categoryPanel;

    @FindBy(xpath = "//div[@class='sub-category-block collapse show']/div[@class='card card-body']/a")
    WebElement subCategoryPanel;

    Random random = new Random();

    public MainCategoryPage() {
        PageFactory.initElements(webDriver, this);
    }

    //Actions
    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public void selectCategoryItem() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(3);
        int div = randomNumber;
        System.out.println(div);
        switch (div) {
            case 0:
                categoryItem1.click();
                break;
            case 1:
                categoryItem2.click();
                break;
            case 2:
                categoryItem3.click();
                break;
            case 3:
                categoryItem4.click();
                break;
        }
    }

    public void numberOfCategoryPanel() throws InterruptedException {
//        selecting category
        Thread.sleep(3000);
        List <WebElement> category = webDriver.findElements(By.className("category-collapse-button"));
        int categorySize = category.size();
        int selectedCategory = random.nextInt(categorySize);
        category.get(selectedCategory).click();
        Thread.sleep(3000);
//        selecting sub-category
        List <WebElement> subcategory = webDriver.findElements(By.xpath("//div[@class='sub-category-block collapse show']/div[@class='card card-body']/a"));
        int subcategorySize = subcategory.size();
        int selectedSubcategory = random.nextInt(subcategorySize);
        subcategory.get(selectedSubcategory).click();
        Thread.sleep(3000);

    }

}
