package com.StepDefination;

import com.Base.Base;
import com.utils.ActionsClass;
import com.utils.EnumsClass;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import javafx.scene.input.KeyCode;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GeneralStep extends Base {

    @And("^I wait for (\\d+) seconds")
    public void iWaitForMinites(int time) throws Throwable {
       Base.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    @Then("^I enter \"([^\"]*)\" into \"([^\"]*)\"$")
    public void iEnterInto(String text, String element) throws Throwable {
       ActionsClass.enter(text,element);
    }

    @Then("^I wait until \"([^\"]*)\" (appears|disappears)$")
    public void i_wait_until(String arg1, String arg2) throws Throwable {
        switch (arg2) {
            case "appears":
                seleniumMethods.isElementExistWithFluentWait(driver, ActionsClass.getLocator(ActionsClass.getObjectDetails(arg1)));
                seleniumMethods.performSleep(5);
                Assert.assertTrue(true);
                break;
            case "disappears":
                Base.seleniumMethods.performSleep(2);
                seleniumMethods.isElementNotExistWithFluentWait(driver, ActionsClass.getLocator(ActionsClass.getObjectDetails(arg1)));
                //obj_SeleniumMethods.isElementExistWithFluentWait(driver, Actions.getLocator(Actions.getObjectDetails(arg1)));
                seleniumMethods.performSleep(5);
                Assert.assertTrue(true);
                break;
        }
    }

    @Then("^I scroll till \"([^\"]*)\"$")
    public void iScrollTill(String text) throws Throwable {
//     ActionsClass.scrollToText(text);
     ActionsClass.scrollToTextAndClick(text);

    }

    @Then("^I click on Enter on Keyboard$")
    public void iClickOnEnterOnKeyboard(String strTextToScroll) throws Throwable {
    }
}
