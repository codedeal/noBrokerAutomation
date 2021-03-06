package com.Pages;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SetUp.TestBase;
import com.Utility.Common;
import com.listeners.Log;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PropertyListlPage extends TestBase
{

	@FindBy(id="title")
	List<MobileElement> titleOfProperty;
	
	@FindBy(id="property_thumbnail")
	List<MobileElement> listofproperty;
	public PropertyListlPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	public ProductDetailPage selectPropertyFromSearchResult(int index)
	{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("in propertyList");
	   Common.Wait(titleOfProperty.get(0));
	   Common.swipVertical(500);
	   if(listofproperty.size()<=1)
		   Common.swipVertical(500); 
	   listofproperty.get(index).click();
	   return new ProductDetailPage();
	   
	   
	}

}

