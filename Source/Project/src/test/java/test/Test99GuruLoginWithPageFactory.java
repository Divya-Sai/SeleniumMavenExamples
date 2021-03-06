package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Module.Utility.ConfigurationProp;

import pageFactory.FindByannotations;
import pageFactory.Guru99HomePage;

public class Test99GuruLoginWithPageFactory {
	
	WebDriver driver;

	FindByannotations objLogin;

    Guru99HomePage objHomePage; 

    @BeforeTest

    public void setup() throws IOException{
    	
    	ConfigurationProp  CP = new ConfigurationProp();
    	System.setProperty("webdriver.chrome.driver", CP.getConfigProp("DrivePath"));

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(CP.getConfigProp("Facebook"));

    }
    
   // @AfterTest
    public void tearDown() {
    	driver.close();
    }

    /**

     * This test go to http://demo.guru99.com/V4/

     * Verify login page title as guru99 bank

     * Login to application

     * Verify the home page using Dashboard message

     */

    @Test(priority=0)

    public void test_Home_Page_Appear_Correct(){

        //Create Login Page object

    objLogin = new FindByannotations(driver);

    //Verify login page title

  //  String loginPageTitle = objLogin.getLoginTitle();

   // Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

    //login to application

    objLogin.loginToGuru99("mgr123", "mgr!23");

    // go the next page

    objHomePage = new Guru99HomePage(driver);

    //Verify home page

    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));

    }

}
