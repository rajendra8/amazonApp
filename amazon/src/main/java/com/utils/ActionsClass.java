package com.utils;

import com.Base.Base;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;


public class ActionsClass extends Base {

    public static String[] getObjectDetails(String str_Element) {
        String str_value = Base.map_OR.get(str_Element);
        System.out.println("Object details for " + str_Element + " are as follows:" + str_value);
        return str_value.split("###");
    }

    public static MobileElement fetchElementOfIos(String[] arry) {
        switch (arry[0]) {
            case "xpath":
                return Base.driver.findElement(MobileBy.xpath(arry[1]));
            case "className":
                return Base.driver.findElement(MobileBy.className(arry[1]));
            case "iOSNsPredicate":
                return Base.driver.findElement(MobileBy.iOSNsPredicateString(arry[1]));
            case "iOSClassChain":
                return Base.driver.findElement(MobileBy.iOSClassChain(arry[1]));
            default:
                return Base.driver.findElement(MobileBy.AccessibilityId(arry[1]));
        }
    }

    public static boolean click(String str_Element) {
        try {
            String[] str_Arr = getObjectDetails(str_Element);
            fetchElement(str_Arr).click();
            System.out.println("Clicked on " + str_Element);
            return true;
        } catch (Exception e) {
            isPresent(str_Element);
            System.out.println("Error while clicking on " + str_Element);
            System.out.println("The error message is:\n" + e.getMessage());
        }
        return false;
    }

    public static boolean enter(String str_Text,String str_Element) {
        try {
            String[] str_Arr = getObjectDetails(str_Element);
            fetchElement(str_Arr).clear();
            fetchElement(str_Arr).sendKeys(str_Text);
            System.out.println("send text " + str_Text);
            return true;
        } catch (Exception e) {
            isPresent(str_Element);
            System.out.println("Error while sending on " + str_Element);
            System.out.println("The error message is:\n" + e.getMessage());
        }
        return false;
    }

    public static boolean isPresent(String str_Element) {
        try {
            String[] str_Arr = getObjectDetails(str_Element);

            if (fetchElements(str_Arr).size() > 0) {
                if (fetchElement(str_Arr).isDisplayed() && fetchElement(str_Arr).isEnabled()) {
                    System.out.println(str_Element + " is present");
                    return true;
                } else {
                    System.out.println(str_Element + " is not present or disabled");
                }
            } else {
                System.out.println(str_Element + " is not present or disabled");
            }
        } catch (Exception e) {
            System.out.println("Error while checking presence of " + str_Element);
            System.out.println("The error message is:\n" + e.getMessage());
        }
        return false;
    }
    public static boolean isPresent(String arg1, By by) {
        try {

            if (Base.driver.findElement(by).isEnabled()) {
                System.out.println(arg1 + " is present");
                return true;
            } else {
                System.out.println(arg1 + " is not present");
            }
        } catch (Exception e) {
            System.out.println("Error while checking presence of " + arg1);
            System.out.println("The error message is:\n" + e.getMessage());
        }
        return false;
    }


    public static boolean isEnabled(String str_Element) {
        try {
            String[] str_Arr = getObjectDetails(str_Element);

            if (fetchElements(str_Arr).size() > 0) {
                if (fetchElement(str_Arr).isEnabled()) {
                    System.out.println(str_Element + " is Enabled");
                    return true;
                } else {
                    System.out.println(str_Element + " is not present or disabled");
                }
            } else {
                System.out.println(str_Element + " is not present or disabled");
            }
        } catch (Exception e) {
            System.out.println("Error while checking Enable of " + str_Element);
            System.out.println("The error message is:\n" + e.getMessage());
        }
        return false;
    }

    public static List<MobileElement> fetchElements(String[] arry) {
        switch (arry[0]) {
            case "xpath":
                return Base.driver.findElements(MobileBy.xpath(arry[1]));
            case "className":
                return Base.driver.findElements(MobileBy.className(arry[1]));
            case "iOSNsPredicate":
                return Base.driver.findElements(MobileBy.iOSNsPredicateString(arry[1]));
            case "iOSClassChain":
                return Base.driver.findElements(MobileBy.iOSClassChain(arry[1]));
            default:
                return Base.driver.findElements(MobileBy.AccessibilityId(arry[1]));
        }
    }

    public static By getLocator(String[] arry) {
        //System.out.println("we are inside getLocators method");
        switch (arry[0]) {
            case "xpath":
                return MobileBy.xpath(arry[1]);
            case "className":
                return MobileBy.className(arry[1]);
            case "iOSNsPredicate":
                return MobileBy.iOSNsPredicateString(arry[1]);
            case "iOSClassChain":
                return MobileBy.iOSClassChain(arry[1]);
            case "UIAutomatorSelector":
                return MobileBy.AndroidUIAutomator(arry[1]);
            case "id":
                return MobileBy.id(arry[1]);
            default:
                return MobileBy.AccessibilityId(arry[1]);


        }
    }

    public static MobileElement fetchElement(String[] arry) {
        switch (arry[0]) {
            case "xpath":
                return Base.driver.findElement(MobileBy.xpath(arry[1]));
            case "className":
                return Base.driver.findElement(MobileBy.className(arry[1]));
            case "iOSNsPredicate":
                return Base.driver.findElement(MobileBy.iOSNsPredicateString(arry[1]));
            case "iOSClassChain":
                return Base.driver.findElement(MobileBy.iOSClassChain(arry[1]));
            case "UIAutomatorSelector":
                return Base.driver.findElement(MobileBy.AndroidUIAutomator(arry[1]));
            case "id":
                return Base.driver.findElement(MobileBy.id(arry[1]));
            default:
                return Base.driver.findElement(MobileBy.AccessibilityId(arry[1]));
        }
    }

    public static boolean scrollToText(String strTextToScroll) {
        System.out.println("We will scroll to text:" + strTextToScroll);
        String strCriteria = "";
//        By byCriteria = null;
//        ActionsClass.getLocator(ActionsClass.getObjectDetails(arg2)
        strCriteria = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + "new UiSelector().textContains(\"" + strTextToScroll + "\")" + ");";

       By byCriteria = MobileBy.AndroidUIAutomator(strCriteria);
        try {
            List lstUsers = ((AndroidDriver) Base.driver).findElementsByAndroidUIAutomator(strCriteria);
            if (lstUsers.size() != 0 || lstUsers.size() == 0) {
                //Scrolling to text
                ((AndroidDriver) Base.driver).findElementByAndroidUIAutomator(strCriteria);
                Assert.assertTrue(ActionsClass.isPresent(strTextToScroll, byCriteria));
                seleniumMethods.performSleep(5);
                return true;
            } else {
                //Text is not present
                System.out.println("The text:" + strTextToScroll + ", is not present in the screen");
                seleniumMethods.performSleep(5);
                Assert.assertTrue(ActionsClass.isPresent(strTextToScroll, byCriteria));
//                obj_SeleniumMethods.performSleep(3);
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public static boolean click(String str_Element, By by) {
        try {
            driver.findElement(by).click();
            System.out.println("Clicked on " + str_Element);
            return true;
        } catch (Exception e) {
            isPresent(str_Element, by);
            System.out.println("Error while clicking on " + str_Element);
            System.out.println("The error message is:\n" + e.getMessage());
        }
        return false;
    }
    public static boolean scrollToTextAndClick(String strTextToScroll) {
        System.out.println("We will scroll to text:" + strTextToScroll);
        String strCriteria = "";
        By byCriteria = null;
        strCriteria = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + "new UiSelector().textContains(\"" + strTextToScroll + "\")" + ");";
        byCriteria = MobileBy.AndroidUIAutomator(strCriteria);

        List lstUsers = ((AndroidDriver) driver).findElementsByAndroidUIAutomator(strCriteria);
        if (lstUsers.size() != 0) {
            //Scrolling to text
            ((AndroidDriver) Base.driver).findElementByAndroidUIAutomator(strCriteria);
            seleniumMethods.performSleep(5);
            Assert.assertTrue(ActionsClass.isPresent(strTextToScroll, byCriteria));
            seleniumMethods.performSleep(5);
            Assert.assertTrue(ActionsClass.isPresent(strTextToScroll, byCriteria));
            return true;
        } else {
            //Text is not present
            System.out.println("The text:" + strTextToScroll + ", is not present in the screen");
            Assert.assertTrue(ActionsClass.isPresent(strTextToScroll, byCriteria));
            return false;
        }
    }

}
