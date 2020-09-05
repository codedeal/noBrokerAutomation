package com.SetUp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumDriverFactory 
{

	private static EnvironmentPropertiesReader configProperty = EnvironmentPropertiesReader.getInstance();
	public static AppiumDriver<MobileElement> getDriverInstance()
	{
		return get(); //returns driver
	}
	
	private static AppiumDriver<MobileElement> get()
	{
		AppiumDriver<MobileElement>driver=null;
		try {
			driver = getAppiumDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return driver;
	}
	
	private static AppiumDriver<MobileElement>getAppiumDriver() throws MalformedURLException
	{
		AppiumDriver<MobileElement> driver = null;
		DesiredCapabilities capabilities = getDesiredCapabilities();
		String appiumURl= "http://" + configProperty.getProperty("hostName") + ":" + configProperty.getProperty("portName") + "/wd/hub";
		if(configProperty.getProperty("platformName").equals("Android")) 
		{
			driver = new AndroidDriver<MobileElement>(new URL(appiumURl), capabilities);
		}
		else
		{
			driver = new IOSDriver<MobileElement>(new URL(appiumURl), capabilities);
			 
		}
		return driver;
	}
	
	private static DesiredCapabilities getDesiredCapabilities()
	{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		if(configProperty.getProperty("platformName").equals("Android")) 
		{
			if(configProperty.getProperty("deviceName")!=null) 
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, configProperty.getProperty("deviceName"));

           if(configProperty.getProperty("platformName")!=null) 
	        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, configProperty.getProperty("platformName"));
           if(configProperty.getProperty("platformVersion")!=null) 
        	   capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, configProperty.getProperty("platformVersion"));

           	if(configProperty.getProperty("appActivity")!=null)
           		capabilities.setCapability("appActivity", configProperty.getProperty("appActivity"));
          	if(configProperty.getProperty("appPackage")!=null)
           		capabilities.setCapability("appPackage", configProperty.getProperty("appPackage"));
        	if(configProperty.getProperty("appName")!=null)
           		capabilities.setCapability(MobileCapabilityType.APP, configProperty.getProperty("appName")); //full path of apk
          	
        	capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, configProperty.getProperty("commandTimeOut"));
		}
		return capabilities;
	}
}
