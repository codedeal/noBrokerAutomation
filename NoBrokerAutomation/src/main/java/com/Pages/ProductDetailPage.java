package com.Pages;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SetUp.TestBase;
import com.Utility.Common;
import com.listeners.Log;

import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductDetailPage  extends TestBase
{
	@FindBy(id="extra_info_card1_area")
	MobileElement source;
	@FindBy(id="extra_info_card1_area")
	MobileElement destination;
	@FindBy(id="tv_report_wrong_info")
	MobileElement wrongInfoIcon;
	
	@FindBy(id="tv_signup_heading")
	MobileElement reportPropertY;
	public ProductDetailPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void SwipeToWrongInfor()
	{
		try {
			
			if(wrongInfoIcon.isDisplayed())
			 {
				wrongInfoIcon.click();
			   System.out.println(reportPropertY.getText());
			   Log.info("Report the property");
				return;
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		   Common.swipVertical(34);
			
			SwipeToWrongInfor();
			
		}
	
	}
}
