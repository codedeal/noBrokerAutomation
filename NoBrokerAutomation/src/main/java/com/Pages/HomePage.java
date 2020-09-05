package com.Pages;


import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.SetUp.TestBase;
import com.listeners.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends TestBase 
{
	@FindBy(id="homeTitle")
	MobileElement titleOfApp;

	@FindBy(id="buyLayoutText")
	MobileElement buyOption;

	@FindBy(id="searchEditHome")
	MobileElement searchEntryBar;

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


	@FindBy(id="title")
	List<MobileElement> titleOfProperty;
	
	@FindBy(id="property_thumbnail")
	List<MobileElement> listofproperty;
	
	@FindBy(id="tv_report_wrong_info")
	MobileElement wrongInfoIcon;

	public HomePage() {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	public void Wait(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOf(element)); 
	}

	public SearchEntryPage seracItem(String itemToSearch)
	{
	   
		
		Log.info(titleOfApp.getText());
		buyOption.click();
		searchEntryBar.click();
		Log.info("Entered Search Entry");
		return new  SearchEntryPage();
		
		

	}
	
}
