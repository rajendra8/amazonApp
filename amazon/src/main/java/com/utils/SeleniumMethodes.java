package com.utils;

import com.Base.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class SeleniumMethodes {


    public void performSleep(int noOfSeconds) {
        try
        {
            System.out.println("Performing a sleep for "+noOfSeconds+" seconds");
            Thread.sleep(1000 * noOfSeconds);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void waitForElement(AppiumDriver<MobileElement> driver, By byCriteria) {
        boolean blnStatus = true;
        int count = 0;
        while(blnStatus)
        {
            try
            {
                count++;
                driver.findElement(byCriteria);
                blnStatus = false;
            }
            catch(Exception e)
            {
                System.out.print("*");
                count++;
                try {
                    Thread.sleep(2000);
                    if(count >= 20)
                    {
                        System.out.println("Unable to find element even after waiting for 40 seconds.");
                        break;
                    }
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

        }

    }
    public void isElementExistWithFluentWait(WebDriver driver, final By byCriteria) {

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(byCriteria));
    }

    public void isElementNotExistWithFluentWait(WebDriver driver, final By byCriteria) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(byCriteria));
    }

}
