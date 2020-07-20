package com.StepDefination;

import com.Base.Base;
import com.utils.ActionsClass;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class createAccount {


    @Given("^I click on \"([^\"]*)\"$")
    public void iClicksigin(String arg1) throws Throwable {
       ActionsClass.click(arg1);
    }
}
