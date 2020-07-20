package com.StepDefination;

import com.Base.*;
import com.utils.ActionsClass;
import com.utils.JsonParsers;
import com.utils.SeleniumMethodes;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Login extends Base {
    @Given("^I start the automation$")
    public void iStartTheAutomation() throws Throwable {
        System.out.println("I start the automation");
    }

    @Then("^I executing the hookclass$")
    public void iExecutingTheHookclass() throws Throwable {
        System.out.println("I executing the at the hook level");
    }

    @When("^I come to login page$")
    public void iComeToLoginPage() throws Throwable {
        System.out.println("I come to login page");

    }

    @And("^I check login page$")
    public void iCheckLoginPage() throws Throwable {
        System.out.println("I check login page");
    }

    @And("^I lauch the safari browser$")
    public void iLauchTheSafariBrowser() throws Throwable {
//       InitializeTheSafari.testAppiumProSite_iOS();
    }

    @And("^I open amazon$")
    public void iOpenAmazon() throws Throwable {
        Set<String> set = new HashSet<String>();
//        Base.driver.findElement(By.id("URL")).sendKeys("https://www.amazon.in/");
//        ActionsClass.click("Go");
//        Base.driver.get("https://www.amazon.in/");
        Base.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Base.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        String context = driver.getContext();
        System.out.println("contex" + context);

//
//        Base.driver.findElement(By.id("nav-logobar-greeting")).click();
        Base.driver.findElement(By.xpath("//a[@id='nav-logobar-greeting']")).click();
        Base.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Base.driver.findElement(By.id("nav-search-keywords")).sendKeys("23 Inch TV");
        Base.driver.findElement(By.id("register_accordion_header")).click();


//        set= Base.driver.getWindowHandles();

//        driver.context(contexts[1]);
//        System.out.println(Base.driver.getWindowHandles());
//        for(String winHandle : Base.driver.getWindowHandles()){
//            System.out.println(winHandle);
//            driver.switchTo().window(winHandle);
//        }
////       Base.driver.context("webviews");
//        System.out.println("switchin to webview");
////        Base.driver.context(Base.driver.getContext());
//
//        set= Base.driver.getContextHandles();
//        System.out.println(set.toString());

//        System.out.println("Page Source:"+ driver.getPageSource());

//        Base.driver.findElement(By.id("URL")).sendKeys("https://www.amazon.in/");
//        Base.driver.findElement(By.id("Go")).click();
    }

    @And("^I Send SMS to \"([^\"]*)\"$")
    public void iSendSMSTo(String arg0) throws Throwable {
        //   driver.sendSMS("555-555-5555", "Your message here!");
    }


}
