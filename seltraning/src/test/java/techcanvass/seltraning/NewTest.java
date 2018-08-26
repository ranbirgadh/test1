package techcanvass.seltraning;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	WebDriver driver;
	//WebDriverWait driverWait;
	//final static String appUrl = "http://www.seleniumeasy.com/test/";
	
  @Test
  public void f() {
	  	//System.out.println("hello");
	  	WebElement name = driver.findElement(By.id(p.getProperty("username"));
			
	  	//name.click();
	  	
	  	name.sendKeys("Ranbir");
	  	
	  	
		
	  	WebElement email = driver.findElement(By.id("txtEmail"));
		
		//email.click();
		
		email.sendKeys("rangadsin@gmail.com");
		
		
	  
  }
  @BeforeTest
  public void setUp()
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\gadhr\\OneDrive\\Documents\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
				//driverWait = new  WebDriverWait(driver,20);
				//driver.manage().window().maximize();
				driver.get(p.getProperty("url");		
	  }

  @AfterTest
  public void afterTest() {
  }

}
