package com.actitime.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.actitime.genericlib.Constants;

public class Driver {
	public static WebDriver driver;
	
	public static WebDriver getBrowser(){
		if(Constants.browser.equals("ie")){
			System.setProperty("Webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\iexplore.exe");
			driver = new InternetExplorerDriver();
		}else if(Constants.browser.equals("chrome")){
			System.setProperty("Webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
			driver = new ChromeDriver();
		}else{
			driver = new FirefoxDriver();
		}
		return driver;
	}
}
