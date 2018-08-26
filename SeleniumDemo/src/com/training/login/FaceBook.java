package com.training.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FaceBook 
{

	public static void main (String args[])
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\gadhr\\OneDrive\\Documents\\chromedriver_win32\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.facebook.com/");
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
	WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
	
	firstName.click();
	
	
	firstName.sendKeys("Roger");
	
	WebElement lastName =driver.findElement(By.xpath(".//*[@name='lastname']"));
	
	lastName.click();
	
	lastName.sendKeys("Wallace");
	
	WebElement email = driver.findElement(By.xpath(".//*[@aria-label=\"Mobile number or email address\"]"));
	
	email.click();
	
	email.sendKeys("testmail@gmail.com");
	
	WebElement reenterEmail = driver.findElement(By.cssSelector("input[name=\"reg_email_confirmation__\"]"));
	
	reenterEmail.click();
	
	reenterEmail.sendKeys("testmail@gmail.com");
	
	WebElement birthDay = driver.findElement(By.cssSelector("select[id=\"day\"]"));
	
	Select daySelect = new Select(birthDay);
	
	daySelect.selectByVisibleText("13");
	
	WebElement month = driver.findElement(By.);
	
	Select selectMonth = new Select(month);
	
	selectMonth.selectByVisibleText("Oct");
	
	Select selectYear = new Select(driver.findElement(By.name("birthday_year")));
	
	selectYear.selectByVisibleText("1970");
	
	WebElement male = driver.findElement(By.xpath(".//*[@name='sex'][@value='2']"));
	
	male.click();
	
	WebElement female = driver.findElement(By.xpath(".//*[@name='sex'][@value='1']"));
	
	female.click();
			
	
	//Actions actions = new Actions(driver);
	
	//actions.moveToElement(driver.findElement(By.partialLinkText("date of birth"))).build().perform();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
}
