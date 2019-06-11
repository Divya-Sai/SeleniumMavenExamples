package com.Module.Project;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Module.Utility.ConfigurationProp;

public class Login {

	WebDriver driver;
	ChromeDriver  chrome;
		
	public void initialize() throws IOException {
		ConfigurationProp  C  = new ConfigurationProp();
		System.setProperty("webdriver.chrome.driver", C.getConfigProp("DrivePath") );
		//D:\\Divya-New\\Project\\SampleMVN\\SampleMVN\\chromedriver-72v\\chromedriver.exe
	    driver = new ChromeDriver();
		String S = driver.getTitle();
		driver.get(C.getConfigProp("Facebook"));
		System.out.println("Title of the Page is :::"+S);
		//driver.manage().window().maximize();
		System.out.println("initialize::::"+driver);
	}
	
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("tearDown::::"+driver);
		driver.quit();
	}
	
	public void getUrl() throws InterruptedException, IOException {
	   
	   ConfigurationProp  C  = new ConfigurationProp();
	   driver.get(C.getConfigProp("Gmail"));
	   System.out.println("Title of the Page is :::"+C.getConfigProp("Gmail"));
		
	}
	
	
}
