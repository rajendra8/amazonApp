package com.StepDefination;

import com.Base.Base;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks extends Base{

    @Before("@BeforeLogin")
    public static void beforeLogin(Scenario scenario){
        System.out.println(scenario.getSourceTagNames()+" has"+scenario.getStatus()+ "Before login");

    }

    @After("@AfterLogin")
    public static void afterLogin(){
        System.out.println("After login");
    }

    @Before("@BeforeGetUrl")
    public static void beforegetUrl(Scenario scenario){
        System.out.println(scenario.getSourceTagNames()+" has"+scenario.getStatus()+ "Before urlOpen");
    }
    @After("@AfterBrowserTest")
    public static void afterBrowserTest(Scenario scenario){
        System.out.println(scenario.getSourceTagNames()+" has"+scenario.getStatus()+ "After Browser Test");
        Base.chromedriver.close();
//        WebDriver chromedriver= new ChromeDriver();
//        chromedriver.manage().window().maximize();
//        chromedriver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
    }
}
