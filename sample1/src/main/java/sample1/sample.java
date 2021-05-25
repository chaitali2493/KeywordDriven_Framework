package sample1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;


public class sample {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D://setup//chrome_driver//chromedriver_win32//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.close();
		
		
	}

}
