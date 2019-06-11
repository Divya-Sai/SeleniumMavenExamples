package com.Module.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Facebook {
	public WebDriver driver;
	
	/*WebElements*/
	@FindBy(name="email")
    WebElement txtemail;
	
	public Facebook(WebDriver driver) {
		this.driver = driver;
    	PageFactory.initElements(driver, this);
	}
	
	public void enterDetails(String emailId) {
		txtemail.sendKeys(emailId);
	}

}
