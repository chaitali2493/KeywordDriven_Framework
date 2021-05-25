package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	
		public Properties prop;
		public WebDriver driver;
		
		public WebDriver driver_initialization(String Browser_name)
		{
			if(Browser_name.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "D://setup//chrome_driver//chromedriver_win32//chromedriver.exe");
			    driver= new ChromeDriver();		
			}
			return driver;			
		}
		
		public Properties configuration_properties_initialization() 
		{
		
			prop=new Properties();
			try {
				FileInputStream ip= new FileInputStream("C:\\Users\\anura\\eclipse-workspace\\Keyboard_Driven\\src\\main\\java\\com\\config\\config.properties");
			    try {
					prop.load(ip);
				} catch (IOException e) {
					e.printStackTrace();
				}			
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
			return prop;
			
		}
		
		
	
	
	
	

}
