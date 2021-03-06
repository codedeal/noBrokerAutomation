package com.Utility;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SetUp.TestBase;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Common extends TestBase
{
	public static void Wait(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOf(element)); 
	}
   
	public static void swipVertical(int y) {

		System.out.println("Call swipe left...");
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.height * .15);
		int startPoint = (int) (size.width * .10);
		int endPoint = (int) (size.width * .50);

		System.out.println("Swipe: "+anchor+", "+startPoint+", "+endPoint+" and Size: "+size);
		if(y==500)
		new TouchAction(driver).press(PointOption.point(950, 700)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(950, y)).release().perform();
		else
		new TouchAction(driver).press(PointOption.point(211, 1813)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(202, 263)).release().perform();
		
		System.out.println("Element Swiped...");
	}
	public static void swiptToBottom()
	{
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width/2;
		int top_y = (int)(height*0.80);
		int bottom_y = (int)(height*0.20);
		System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
		TouchAction ts = new TouchAction(driver);
		ts.press(PointOption.point(x, top_y)).moveTo(PointOption.point(x, bottom_y)).release().perform();
	}
	public static void scrollToText(String text)
			throws MalformedURLException, InterruptedException {
		MobileElement el = (MobileElement) ((FindsByAndroidUIAutomator) driver)
				.findElementByAndroidUIAutomator("new UiScrollable("
						+ "new UiSelector().scrollable(true)).scrollIntoView("                      
						+ "new UiSelector().textContains(\""+text+"\"));");
		// el.click();
	}
}
