package com.actitime.UserTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.actitime.genericlib.Constants;
import com.actitime.genericlib.Driver;
import com.actitime.genericlib.ExcelLib;
import com.actitime.genericlib.WebDriverCommonLib;

public class UserTest {
    ExcelLib lib = new ExcelLib();
    
        @Test
public void createUserTest() throws EncryptedDocumentException, InvalidFormatException, IOException{
            
            //String userID = lib.getExcelData("Sheet1", 1, 2);
            //String password = lib.getExcelData("Sheet1", 1, 3);
            //String userName = lib.getExcelData("Sheet1", 1, 4);
            //System.out.println(userID);
            
        	WebDriverCommonLib wLib = new WebDriverCommonLib();
             WebDriver driver = Driver.getBrowser();
                driver.get(Constants.url);
                driver.findElement(By.id("username")).sendKeys(Constants.userName);
                driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(Constants.password);
                driver.manage().window().maximize();
                driver.findElement(By.id("loginButton")).click();
                wLib.waitForXpathPresent("//li[div[div[div[span[contains(text(),'Front Office')]]]]]/following-sibling::li[1]/div/div/div/span[contains(text(),'Patient')]");
                
                driver.findElement(By.xpath("//li[div[div[div[span[contains(text(),'Front Office')]]]]]/following-sibling::li[1]/div/div/div/span[contains(text(),'Patient')]")).click();
                driver.findElement(By.xpath("//div[contains(text(),'Patient List')]")).click();
                wLib.waitForXpathPresent("//a[contains(text(),'Add New Patient')]");
                
                driver.findElement(By.xpath("//a[contains(text(),'Add New Patient')]")).click();
                wLib.waitForPageLoad();
                
                driver.findElement(By.name("title")).click();
        		driver.findElement(By.xpath("//td[contains(text(),'Mr.')]")).click();
        		
        		driver.findElement(By.name("firstName")).sendKeys("Raj");
        		
        		driver.findElement(By.name("lastName")).sendKeys("Mal");
        		
        		driver.findElement(By.name("dob")).sendKeys("10/05/1988");
        		
        		driver.findElement(By.xpath("//div[span[text()='Religion']]/preceding-sibling::div/i")).click();
        	/*WebDriver driver = Driver.getBrowser();
        	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get(Constants.url);
    		
    		driver.findElement(By.name("j_username")).sendKeys(Constants.userName);
    		driver.findElement(By.name("j_password")).sendKeys(Constants.password);
    		
    		driver.findElement(By.xpath("//input[@type='submit']")).click();*/
        	
        	/*ExcelLib eLib = new ExcelLib();
        	WebDriverCommonLib wLib = new WebDriverCommonLib();
        	
        	String userName = eLib.getExcelData("Sheet1", 2, 2);
        	String password = eLib.getExcelData("Sheet1", 2, 3);
        	String firstName = eLib.getExcelData("Sheet1", 2, 5);
        	String lastName = eLib.getExcelData("Sheet1", 2, 6);
        	String emailID = eLib.getExcelData("Sheet1", 2, 7);
        	String expVal = eLib.getExcelData("Sheet1", rowNum, colNum);*/
        }
        
        
}