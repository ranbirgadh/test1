
package com.training.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class LoginTest 
{
	
	public static void main(String args[])
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\gadhr\\OneDrive\\Documents\\chromedriver_win32\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	WebDriverWait driverWait = new WebDriverWait(driver,30);
	
	
	driver.switchTo().
		
	driver.get("https://www.facebook.com/");
		
	WebElement email = driver.findElement(By.id("email"));
	
	email.click();
	
	email.sendKeys("test@gmail.com");
	
	System.out.println(email.getTagName());
	
	WebElement password = driver.findElement(By.id("pass"));
	
	password.click();
	
	password.sendKeys("password");
	
	System.out.println(password.getTagName());
	
	
	
	WebElement day = driver.findElement(By.id("day"));
	Select daySelect = new Select(day);
	daySelect.selectByVisibleText("10");
	
	
	driver.findElement(By.nam)
	
	
			
	//CSS #loginbutton>input[value='Log In']
	//xpath .//*[@id='loginbutton']/input[@value='Log In']
	
	//WebElement login = driver.findElement(By.xpath(".//*[@id='loginbutton']/input[@value='Log In']"));
	
	//login.click();
	
	//WebElement error = driver.findElements(By.cssSelector(selector);
	
	//WebElement error = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
	
	//String expected = "";
	
	//String actual = error.getText();
	
	//System.out.println(actual);
	
	//Assert.assertEquals(expected, actual);
	
	
	Actions actions = new Actions(driver);
	
	WebElement whyDob = driver.findElement(By.partialLinkText("date of birth"));
	
	actions.moveToElement(whyDob).build().perform();
	
	
				
			
	
	
	try
	{
		Thread.sleep(10000);
		
	}
	catch(InterruptedException e)
	{
		e.printStackTrace();
	}
	
	
	
	
	//driver.quit();
	
	
	
	
	
	
	}
	

}
*/