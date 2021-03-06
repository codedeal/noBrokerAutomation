package com.SetUp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class TestBase 
{
	public static AppiumDriver<MobileElement> driver;
	
	public void SetUp()
	{
		
		
		try {
			String appPath=System.getProperty("user.dir")+"/resource/NoBroker.apk";
			DesiredCapabilities capabilities = new DesiredCapabilities();
		
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			//capabilities.setCapability(MobileCapabilityType.APP,appPath );
			capabilities.setCapability("appPackage", "com.nobroker.app");
			capabilities.setCapability("appActivity", "com.nobroker.app.activities.NBSplashScreen");
			capabilities.setCapability("noReset", true);
	        URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver<MobileElement>(url, capabilities);
		} 
		catch (MalformedURLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Cause is"+e.getCause());
			System.out.println("MEssage is "+e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	//@Test
	public void sampleTest() throws InterruptedException
	{
		System.out.println("I m in sample test");
		Thread.sleep(10000);
		//Already a member? Login
		driver.findElement(By.id("com.healthifyme.basic:id/btn_login")).click();
		driver.findElement(By.id("com.healthifyme.basic:id/btn_email_phone")).click();
		driver.findElement(By.id("com.healthifyme.basic:id/et_username")).sendKeys("hme-testpr440@example.com");
		driver.findElement(By.id("com.healthifyme.basic:id/et_password")).sendKeys("password");
		driver.findElement(By.id("com.healthifyme.basic:id/btn_login_signup")).click();

	}

	
	@AfterTest
	public void TearDown() 
	{
		driver.quit();

	}

}
