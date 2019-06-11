package com.Module.Project;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Module.Utility.ConfigurationProp;
import com.Module.Utility.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageFactory.Webelements;

public class TestFacebook  {
	
	WebDriver driver;	
	ExcelReader  excel;
	ExtentTest logger;
	ExtentReports extent;
	
	
	 @BeforeClass

	    public void setup() throws IOException{
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--disable-notifications");
	    	ConfigurationProp  CP = new ConfigurationProp();
	    	System.setProperty("webdriver.chrome.driver", CP.getConfigProp("DrivePath"));

	        driver = new ChromeDriver(options);

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        driver.get(CP.getConfigProp("Facebook"));
	        driver.manage().window().maximize();

	    }
	 @AfterMethod
		public void getResult(ITestResult result){
			if(result.getStatus() == ITestResult.FAILURE){
				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			}else if(result.getStatus() == ITestResult.SKIP){
				logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
			}
			// ending test
			//endTest(logger) : It ends the current test and prepares to create HTML report
			extent.endTest(logger);
		}
	 
	 @BeforeTest
		public void startReport(){
		 extent = new ExtentReports ("D:\\Divya-New\\Project\\workspace\\Project\\Reports\\Report.html", true);
			extent
            .addSystemInfo("Host Name", "SoftwareTestingMaterial")
            .addSystemInfo("Environment", "Automation Testing")
            .addSystemInfo("User Name", "Rajkumar SM");
            //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
            //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
            extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	 }
	 
	@AfterTest
	    public void stopReport() {
		 extent.close();
		 extent.flush();
	    	
	    }
	 
	@AfterClass
	public void tearDown() {
		driver.close();
		System.out.println("Browser Closed Successfully!!!");
	}
	 @Test(priority=0)
	 
	 public void test_Home_Page() throws InterruptedException{
		 logger  = extent.startTest("HomePageFacebook");
		 
		 Webelements	objWebElements = new Webelements(driver);
		 excel = new ExcelReader();
		 
		 objWebElements.logintofb(excel.getCellData("TestData1", "FacebookLogin", "UserId", 2),
				 excel.getCellData("TestData1", "FacebookLogin", "Pass", 2));
		 driver.getWindowHandle();
		
		 logger.log(LogStatus.PASS, "Sucessfully Logged into facebook");
	 }
	 
	 @Test(priority=1)
	 public void passTest(){
			//extent.startTest("TestCaseName", "Description")
			//TestCaseName – Name of the test
			//Description – Description of the test
			//Starting test
			logger = extent.startTest("passTest");
			Assert.assertTrue(true);
			//To generate the log when the test case is passed
			logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		}
	 
	 @Test(priority=2)
	 public void clickTab() throws InterruptedException {
		 logger  = extent.startTest("clickTab");
		 Webelements	objWebElements = new Webelements(driver);
		 objWebElements.ClickonLeftSideTabs();
		 Thread.sleep(2000);
		String t = driver.getTitle();
		System.out.println("Title of the Page is:::::"+t);
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "clicked to the tab !!!");
	 }

}
