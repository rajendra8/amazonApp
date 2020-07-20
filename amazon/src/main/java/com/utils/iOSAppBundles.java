package com.utils;

import com.Base.Base;
import com.google.common.collect.ImmutableMap;
import cucumber.api.java.en.Then;

public class iOSAppBundles extends Base {
    @Then("^I press (volumeup|volumedown|home|sidebutton) on the device$")
    public void iLockTheDevice(String arg1) throws Throwable {
        switch (arg1) {
            case "volumeup":
                driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "volumeUp"));
                break;
            case "volumedown":
                driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "volumeDown"));
                break;
            case "home":
                driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "home"));
                break;
        }
    }
    //https://emm.how/t/ios-12-list-of-default-apps-and-bundle-id-s/790
    @Then("^I launch the (Appstore|AppleWatch|Calculator|Calendar|Maps|Files|safari)$")
    public void iLaunchTheAppstore(String arg1) throws Throwable {
        switch (arg1) {
            case "Appstore":
                driver.activateApp("com.apple.AppStore");
                break;
            case "AppleWatch":
                driver.activateApp("com.apple.Bridge");
                break;
            case "Calculator":
                driver.activateApp("com.apple.calculator");
                break;
            case "Calendar":
                driver.activateApp("com.apple.mobilecal");
                break;
            case "Maps":
                driver.activateApp("com.apple.Maps");
                break;
            case "safari":
                driver.activateApp("com.apple.mobilesafari");
                break;
            //com.apple.mobilesafari
            case "Files":
                // RunCukesTest.driver.execute("RUN_APP_IN_BACKGROUND");
                driver.activateApp("com.apple.DocumentsApp");
                break;
            case "Photo":
                driver.activateApp("com.apple.mobileslideshow");
                break;
        }
    }
}
