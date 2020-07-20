package com.utils;

import com.Base.Base;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.net.UrlChecker;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AppiumServerAppiumDriverLocalService {
    private io.appium.java_client.service.local.AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private DesiredCapabilities cap;
    private int port;
    Field stream = null;

    public AppiumServerAppiumDriverLocalService(int port) {
        this.port = port;
    }

    public io.appium.java_client.service.local.AppiumDriverLocalService startServer() {
        //https://discuss.appium.io/t/error-while-executing-appium-script-in-java-on-ios-device/15573
        Map<String, String> env = new HashMap<String, String>(System.getenv());
        env.put("PATH", "/usr/local/bin:" + env.get("PATH"));

        //Set Capabilities
        cap = new DesiredCapabilities();
        cap.setCapability("noReset", "false");

        //Build the Appium service
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(port);
        builder.withCapabilities(cap);
        builder.withEnvironment(env);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOCAL_TIMEZONE);

        //https://github.com/appium/java-client/issues/414
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "info");
        //builder.withLogFile(new File(BaseTest.strFolderPath + "/" + "Appium_Server_Log_" + CreateFolder.getDateTime()+ ".txt"));
        builder.withLogFile(new File("./" + CreateFolder.createFolder("AppiumServerLogs", Base.strFolderName) + "/Appium_Server_Log.txt"));
        //builder.withLogFile(new File("./logfile.txt"));

        //Start the server with the builder
        service = io.appium.java_client.service.local.AppiumDriverLocalService.buildService(builder);
        System.out.println("The Server URL is: " + service.getUrl());

		/*try
		{
			service.start();
			if(service.isRunning())
				System.out.println("The service is running");
			else
				System.out.println("The service isn't running");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/

        service.start();

        //https://github.com/appium/appium/issues/10538
        System.out.println("Validating whether the url is up and running...");
        System.out.println("Validating whether the url is up and running...");

        final URL status;

        try {
            status = new URL(service.getUrl() + "/sessions");
            new UrlChecker().waitUntilAvailable(1, TimeUnit.MINUTES, status);
            System.out.println("Url is up and running.");
        } catch (MalformedURLException e) {
            System.out.println("Error in the URL provided. " + e.toString());
            System.out.println("Error in the URL provided. " + e.toString());
            //instance.terminateAll("Could not start a new session with the URL provided. " + e.toString());
            e.printStackTrace();
        } catch (UrlChecker.TimeoutException e) {
            System.out.println(String.format("Server at the URL (%s) is not running. %s.", service.getUrl(), e.toString()));
            System.out.println(String.format("Server at the URL (%s) is not running. %s.", service.getUrl(), e.toString()));
            e.printStackTrace();
        }
        return service;
    }

    public void stopServer(io.appium.java_client.service.local.AppiumDriverLocalService service) {
        service.stop();
    }

    public boolean checkIfServerIsRunnning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            System.out.println("The port is in use by other service and Exepction details are: " + e.toString());
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }
}

