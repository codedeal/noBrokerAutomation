package com.reports;

import com.SetUp.TestBase;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class CaptureScreen extends TestBase
{
	public CaptureScreen() {
		super();
	}
	   public static String screenshotName;
		
			public static void captureScreenshot() {

				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

				Date d = new Date();
				screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

				try {
					FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/Reports/" + screenshotName));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}
