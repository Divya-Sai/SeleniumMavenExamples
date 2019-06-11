package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Webelements {
	
	 /**

     * All WebElements are identified by @FindBy annotation

     */

    WebDriver driver;
    
    @FindBy(xpath=".//input[@name='email']")

    WebElement txtUID;
    
    @FindBy(xpath=".//input[@name='pass']")
    WebElement  txtPassword;
    
    @FindBy(xpath=".//input[@aria-label='Log In']")
    WebElement btnLogIn;
    
    public Webelements(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    
    public void logintofb(String Username,String Password) throws InterruptedException {
    	Thread.sleep(2000);
    	txtUID.sendKeys(Username);
    	System.out.println(Username);
    	txtPassword.sendKeys(Password);
    	System.out.println(Password);
    	btnLogIn.click();
    	String S = driver.getTitle();
    	System.out.println("Title of the page is :::"+S);
    	
    }
    
    public void ClickonLeftSideTabs() throws InterruptedException {
    	Thread.sleep(2000);
    	driver.findElement(By.xpath(".//div[@class ='linkWrap noCount' and contains(.,'Messenger')]")).click();
    }
		
}
