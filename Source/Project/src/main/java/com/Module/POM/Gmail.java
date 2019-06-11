package com.Module.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Gmail {
	
	WebDriver driver = null;
	
	//WebElements
		@FindBy(xpath=".//input[@name='identifier']")
	   WebElement txtEmailId;
		
    public  Gmail(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }

	public void enterLoginDetails(String Username) throws InterruptedException {
		
		txtEmailId.sendKeys(Username);
	
		
	}
}
