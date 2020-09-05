package com.SetUp;

import io.appium.java_client.AppiumDriver;

public class Register 
{
  private static AppiumDriver driver;
  
  public Register() 
  {
	driver = AppiumDriverFactory.getDriverInstance();
   }

public static AppiumDriver getDriver() {
	return driver;
}
  
  
}
