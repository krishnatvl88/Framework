package com.actitime.genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {
	public void waitForPageLoad(){
		Driver.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void waitForXpathPresent(String wbXpath){
		WebDriverWait wait = new WebDriverWait(Driver.driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(wbXpath)));
	}
	
	public void waitForNamePresent(String wbName){
		WebDriverWait wait = new WebDriverWait(Driver.driver,20);
	}
	
	public boolean verifyText(WebElement wb, String expVal){
		boolean flag = false;
		String actVal = wb.getText();
		if(expVal.equals(actVal)){
			flag = true;
			System.out.println(expVal + "value is verfied == PASS");
		}else{
			System.out.println(expVal + "is not verified == FAIL");
		}
		return flag;
	}
	
	public void acceptAlert(){
		Alert alt = Driver.driver.switchTo().alert();
		alt.accept();
	}
	
	public void cancelAlert(){
		Alert alt = Driver.driver.switchTo().alert();
		alt.dismiss();
	}
}
