package com.engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Base;

public class engine_class {
	
	
	public Properties prop;
	public WebDriver driver;
	
	public static Workbook book;
	public static Sheet sheet;

	public final String scenarios_path="C:\\Users\\anura\\eclipse-workspace\\Keyboard_Driven\\src\\main\\java\\com\\scenarios\\keyword_driven_scenarios.xlsx";
	

	public void start_execution(String Login_scenario)
	{
		String Locator_Name=null;
		String Locator_value=null;
		Base base= new Base();
	
		
		FileInputStream file=null;
		try 
		{
			file= new FileInputStream(scenarios_path);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	
			try 
			{
				book= WorkbookFactory.create(file);
			}
			catch (InvalidFormatException e)
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		
			sheet = book.getSheet(Login_scenario);
			int k=0;
			for(int i=0; i<sheet.getLastRowNum();i++)
			{
				try {
				String Locator_colVal = sheet.getRow(i+1).getCell(k+1).toString().trim();
				if(!Locator_colVal.equalsIgnoreCase("NA"))
						{
					Locator_Name= Locator_colVal.split("=")[0].trim();
					Locator_value= Locator_colVal.split("=")[1].trim();
						}
				    
				String action = sheet.getRow(i+1).getCell(k+2).toString().trim();
				String value = sheet.getRow(i+1).getCell(k+3).toString().trim();
			
			switch(action) //Browser specific command switch case
			{
			case "open browser":
			{		
				prop= base.configuration_properties_initialization();
				
				if(value.isEmpty() || value.equals("NA"))
				{
					base.driver_initialization(prop.getProperty("Browser"));// Searches for the property with the specified key in this property list.
				}
				else
				{
					driver= base.driver_initialization(value);
				}
				break;
			}
			case "enter Url":
			{
				if(value.isEmpty() || value.equals("NA"))
				{
				driver.get(prop.getProperty("url"));// Searches for the property with the specified key in this property list.
				}
				else
				{
					driver.get(value);
					
				}
				break;
				
			 }
				
			case "quit":
			{
				driver.quit();
				break;	
			 }	
			
			} 
			
		
			switch(Locator_Name)
			{
			case "id":
			{
				WebElement WE= driver.findElement(By.id(Locator_value));
				if(action.equalsIgnoreCase("sendKeys"))
				{
				WE.clear();
				WE.sendKeys(value);
				}
				else if(action.equalsIgnoreCase("click"))
				{
					WE.click();
				}
				Locator_Name=null;
				break;
			}
			default:
			{
				break;
			}
			
			}
		
			}catch (Exception e) 
			{
				
			}
		
		
		
			
		
	}
	
	
	}
	
}
