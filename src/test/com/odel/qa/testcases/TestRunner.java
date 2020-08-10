package com.odel.qa.testcases;

import com.odel.qa.pages.MyAccountPage;
import org.testng.TestNG;

public class TestRunner {

    static TestNG testNG;

    public static void main(String[] args) {

        testNG = new TestNG();
        testNG.setTestClasses(new Class[]{RegisterPageTest.class});
//        testNG.setTestClasses(new Class[]{HomePageTest.class,LoginPageTest.class,RegisterPageTest.class,
//                ForgetPasswordPageTest.class,CheckoutPageTest.class,CategoryPageTest.class,MyAccountPageTest.class});
        testNG.run();

    }

}
