package com.Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SetUp.TestBase;
import com.listeners.Log;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchEntryPage extends TestBase
{
	@FindBy(id="spinnergo")
	MobileElement searcEntryDropDownArrowIcon;

	@FindBy(xpath="//android.widget.ListView/android.widget.CheckedTextView")
	List<MobileElement> listOfCities;

	@FindBy(id="localityAutoCompleteTxt")
	MobileElement localitySearchArea;

	@FindBy(xpath="//android.widget.LinearLayout/android.widget.CheckBox")
	List<MobileElement> localityOptions;

	@FindBy(id="nearByRadio")
	MobileElement includeNearByProps;

	@FindBy(id="searchProperty")
	MobileElement searchProperty;

	public SearchEntryPage() {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void Wait(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOf(element)); 
	}
	
	public void selectCityFromDropDown(String city)
	{
		Log.info("Select City");
		searcEntryDropDownArrowIcon.click();
		for (MobileElement mobileElement : listOfCities) 
		{
			System.out.println(mobileElement.getText());
			if(mobileElement.getText().toLowerCase().contains(city.toLowerCase()))
			{
				mobileElement.click();
				Log.info("City Selected");
				return;
			}
		}
		System.out.println(city+"----> Not Found");
	}
	
	public void selectLocalities(String local)
	{
		Log.info("Select locality");
		localitySearchArea.click();
		localitySearchArea.sendKeys(local);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		localityOptions.get(0).click();
		Log.info(" locality Selected");
	}
	
	public void includePropertyNearMe()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		includeNearByProps.click();
		Log.info("Checked the box of near by Area");
	}
	
	public void selectBhk(String roomType)
	{
	
		driver.findElement(By.xpath("//*[@text='"+roomType+"']")).click();
		Log.info("type of bhk choosed");
	}

	public PropertyListlPage startSearch()
	{
		searchProperty.click();
		return new PropertyListlPage();
	}
}