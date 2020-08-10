package com.odel.qa.base;

import com.odel.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver webDriver;
    public static WebDriverWait webDriverWait;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("E:/Test Automation/OdelTestAutomation/src/main/com/odel/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
            webDriver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "C:/bin/geckodriver.exe");
            webDriver = new FirefoxDriver();
        } else {
            System.out.println("exception");
        }

        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();

//        webDriver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        webDriver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        webDriver.get(prop.getProperty("url"));

    }

}
