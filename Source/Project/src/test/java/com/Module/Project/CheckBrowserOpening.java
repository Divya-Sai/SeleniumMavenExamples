package com.Module.Project;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Module.POM.Gmail;



public class CheckBrowserOpening {
	WebDriver driver;
	Login L = new Login();
	
	
	@BeforeClass
	public void beforeClass() throws IOException {
		if(L!=null) {
			System.out.println("**beforeClass***");
	   L.initialize();
		}
	}
	
	//@AfterClass
	public void afterClass() throws InterruptedException {	
	if(L != null) {
		System.out.println("**afterClass***");
		L.tearDown();	
	}
	
	}
	
	@Test
	public void LoginDetails() throws IOException, InterruptedException {
		/*Gmail  GL =new Gmail();
		PageFactory.initElements(driver,Gmail.class);
		Thread.sleep(2000);
		GL.enterLoginDetails("divya.santhoshi2000");*/
		/*Gmail page = PageFactory.initElements(driver, Gmail.class);
		page.enterLoginDetails("divya.santhoshi200");*/
		Gmail  GL =new Gmail(driver);
		GL.enterLoginDetails("divya");
		
	}

}
