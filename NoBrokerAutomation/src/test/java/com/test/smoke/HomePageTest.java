package com.test.smoke;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.SearchEntryPage;
import com.Pages.HomePage;
import com.Pages.ProductDetailPage;
import com.Pages.PropertyListlPage;
import com.SetUp.TestBase;
import com.Utility.Common;

public class HomePageTest extends TestBase 
{
	HomePage hompage;
	PropertyListlPage productListPage;
	SearchEntryPage searchEntryPage;
	ProductDetailPage productDetailPage;
	@BeforeMethod
	public void setUp()
	{
		SetUp();
		hompage = new HomePage();
	}
	List<String>productSelected;
	List<String>productInCart;
	@Test
	public void test()
	{
		
		searchEntryPage=hompage.seracItem("");
		searchEntryPage.selectCityFromDropDown("Bangalore");
		searchEntryPage.selectLocalities("Marathahalli");
		searchEntryPage.selectLocalities("HSR Layout");
		searchEntryPage.includePropertyNearMe();
		searchEntryPage.selectBhk("1 BHK");
		searchEntryPage.selectBhk("2 BHK");
		  driver.hideKeyboard();
		 productListPage= searchEntryPage.startSearch();
		 productDetailPage= productListPage.selectPropertyFromSearchResult(1);
		 productDetailPage.SwipeToWrongInfor();
		  
	
		
	
		
		
	}

}
