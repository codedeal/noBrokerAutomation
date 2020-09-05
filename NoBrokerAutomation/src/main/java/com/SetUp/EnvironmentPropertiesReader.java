package com.SetUp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class EnvironmentPropertiesReader 
{
	private static EnvironmentPropertiesReader envProperties;
	
	private Properties properties;
	private EnvironmentPropertiesReader()
	{
		properties = loadProperties();
	}
	
	private Properties  loadProperties()
	{
		Properties props = new Properties();
		try
		{
			//add path of your own config.property
			///Users/Upendra/Documents/Notes/LeetCode/AppiumDemo/
			InputStream cpr = EnvironmentPropertiesReader.class.getResourceAsStream("/config.properties"); 
			props.load(cpr); 
			cpr.close();
			
		}
		catch (FileNotFoundException e) {
			System.out.println("config.properties is missing or corrupt : "+e.getMessage());
			} catch (IOException e) {
				System.out.println("read failed due to: : "+e.getMessage());
			} 
		return props;
	}
     
	 public static EnvironmentPropertiesReader getInstance() 
	 { 
		 if (envProperties == null) 
		 {
		 envProperties = new EnvironmentPropertiesReader(); 
		 }
		 return envProperties; 
		 
	 }
	 
	   public String getProperty(String key)
	   {
		   return properties.getProperty(key);
	   }

	  public boolean hasProperty(String key)
	  {
		  return StringUtils.isNotBlank(properties.getProperty(key));
	  }
}
