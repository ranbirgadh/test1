package com.training.login;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest 
{

	WebDriver driver;
	WebDriverWait driverWait;
	final static String appUrl = "http://www.seleniumeasy.com/test/";
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gadhr\\OneDrive\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driverWait = new  WebDriverWait(driver,20);
		driver.manage().window().maximize();
		driver.get(appUrl);
		System.out.println("hi");
		
	}
	
	
	
	
}
