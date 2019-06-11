package com.Module.Reports;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Module.Utility.ConfigurationProp;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentDemo {
	
	static ExtentTest test;
	static ExtentReports report;
	WebDriver driver;

	@BeforeClass
	public static void startTest()
	{
	report = new ExtentReports("D:\\Divya-New\\Project\\workspace\\Project\\Reports\\rport.html");
	test = report.startTest("ExtentDemo");
	}
	
	@Test
	public void extentReportDemo() throws IOException {
		
		ConfigurationProp CP = new ConfigurationProp();
		System.setProperty("webdriver.chrome.driver", CP.getConfigProp("DrivePath"));
		driver = new ChromeDriver();
		driver.get(CP.getConfigProp("Gmail"));
		if(driver.getTitle().equals("Gmail")) {
			test.log(LogStatus.PASS, "Navigated to Gmail");
		}
		else {
			test.log(LogStatus.FAIL, "Failed");
		}
	}
	
	@AfterClass
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}


}
