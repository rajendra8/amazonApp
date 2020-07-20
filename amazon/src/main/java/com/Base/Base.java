package com.Base;

import com.github.mkolisnyk.cucumber.runner.BeforeSuite;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.AfterSuite;
import com.github.mkolisnyk.cucumber.runner.*;
import com.google.common.base.Objects;
import com.utils.AppiumServerAppiumDriverLocalService;
import com.utils.CreateFolder;
import com.utils.JsonParsers;
import com.utils.SeleniumMethodes;
import cucumber.api.CucumberOptions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        //reportPrefix = "NGMS-iOS-Automation",
//        reportPrefix = "${NGMSAppBuildNumber}",
        jsonReport = "target/cucumber.json",
        retryCount = 0,
        screenShotSize = "100px",
        screenShotLocation = "Screenshots/",
        detailedReport = true,
        detailedAggregatedReport = true,
        //breakdownReport = true,
        //featureMapReport = true,
        //knownErrorsReport = true,
        //consolidatedReport = true,
        systemInfoReport = true,
        overviewReport = true,
        coverageReport = true,
        jsonUsageReport = "target/cucumber-usage.json",
        usageReport = true,
        toPDF = true,
        overviewChartsReport = true,
        pdfPageSize = "A4 Landscape",
        outputFolder = "./${ReportsFolder}/"
)
@CucumberOptions(
        strict = true,
        monochrome = true,
        dryRun = false,
        features = "src/main/resources/FeaturesFile",
        glue = "com.StepDefination",
        tags = "@SearchItem",
        plugin = {"html:target/cucumber-html-report",
                "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
                "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml"
        }
)

public class Base {
    public static DesiredCapabilities dc;
    public static AppiumDriver<MobileElement> driver = null;
    public static WebDriver chromedriver;
    public static WebDriverWait wait;
    public static HashMap<String, String> map_OR = null;
    public static String ReportsFolder = null;
    public static String strFolderName = null;
    public static AppiumServerAppiumDriverLocalService appiumserver;
    public static AppiumDriverLocalService service;
    public static Map<String, String> mapDesiredCapabilities = null;
    static int port = 4743;
    public static SeleniumMethodes seleniumMethods = new SeleniumMethodes();

    @BeforeSuite
    public static void test() throws Exception{
        System.out.println("Base class execution");
        String strFolderName = CreateFolder.getDateTime();
        System.setProperty("ReportsFolder", CreateFolder.createFolder("Reports", strFolderName));
        mapDesiredCapabilities = JsonParsers.generateMapDesiredCapabilities("DesiredCapabilities");
//       mapDesiredCapabilities.put("app", System.getProperty("user.dir") + "/src/main/resources/Amazon.apk");
        appiumserver = new AppiumServerAppiumDriverLocalService(port);
        if (!appiumserver.checkIfServerIsRunnning(port)) {
            service = appiumserver.startServer();
            System.out.println("Appium server is now start");
        } else {
            System.out.println("appium server is already running");
        }
        System.setProperty("platformName", mapDesiredCapabilities.get("platformName"));
        if (Objects.equal(mapDesiredCapabilities.get("platformName"), "iOS")) {
           driver = new IOSDriver<MobileElement>(service.getUrl(), JsonParsers.setCapabalities(mapDesiredCapabilities));
        } else if (Objects.equal(mapDesiredCapabilities.get("platformName"), "Android")) {
            driver = new AndroidDriver<MobileElement>(service.getUrl(), JsonParsers.setCapabalities(mapDesiredCapabilities));
        } else {
            System.out.println("Unknown Device Platform in Desired Capabilites sheet, please update it and reexecute");
            System.exit(1);
        }
        map_OR = JsonParsers.jsontoMap("ObjectRepository");

    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after suite");
        appiumserver.stopServer(service);
    }
}

