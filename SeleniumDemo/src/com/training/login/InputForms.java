package com.training.login;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class InputForms extends BaseTest
{
	
	/*

	@Test
	public void takeScreenShotTest()
	{
		
		WebElement inputText = driver.findElement(By.linkText("Input Forms"));
		inputText.click();
		WebElement radioButton = driver.findElement(By.linkText("Radio Buttons Demo"));
		radioButton.click();
		
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		
		File screenshot = takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		File filePath = new File("G:\\Selenium\\Screenshots\\radioButtonTest.jpg");
		
		try 
		{
			FileUtils.copyFile(screenshot, filePath);
		} 
		catch (IOException e) 
		{
						e.printStackTrace();
		}
		
		*/
	/*
	@Test
	public void chooseDate()
	{
		WebElement datePicker = driver.findElement(By.linkText("Date pickers"));
		
		datePicker.click();
		
		WebElement bootstrapDatePicker = driver.findElement(By.linkText("Bootstrap Date Picker"));
		
		bootstrapDatePicker.click();
		
		WebElement selectDate = driver.findElement(By.xpath(".//*[@placeholder='dd/mm/yyyy']"));
		
		selectDate.click();
		
		driver.findElement(By.xpath(".//*[@class='datepicker-days']/.//*[@class='datepicker-switch']")).click();
		
			
		
	}
	
		
	*/
	
	/*
	@Test
	public void multiSelect()
	{
		driver.findElement(By.linkText("Input Forms")).click();
		
		driver.findElement(By.linkText("Select Dropdown List")).click();
		
		WebElement multiSelect = driver.findElement(By.xpath(".//*[@id='multi-select']"));
		
		Select multiSelection = new Select(multiSelect);
		
		multiSelection.selectByVisibleText("Florida");
		
		Actions action = new Actions(driver);
		
		action.keyDown(Keys.CONTROL);
		
		multiSelection.selectByVisibleText("California");
		
		multiSelection.selectByVisibleText("Ohio");
		
	
		
	}
		
		*/
	
	/*
	
		@Test
		public void frames()
		{
			
			driver.navigate().to("http://toolsqa.com/iframe-practice-page/");
			
			driver.switchTo().frame("IF2");
			
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("entry-title")));
			String label = driver.findElement(By.xpath(".//*[@class='entry-title']")).getText();
			
			System.out.println(label);
			
			
		}
		*/
	
	@Test
	public void window()
	{
	
		//driver.findElement(By.linkText("All Examples")).click();
		
		driver.findElement(By.linkText("Alerts and Modals")).click();		
		
		driver.findElement(By.linkText("Window	Popup Modal")).click();		
		
		String mainWindow = driver.getWindowHandle();
			
		Set<String> allWindowHandles = driver.getWindowHandles();
		
		ArrayList<String> allWindowList = new ArrayList<String> (allWindowHandles);
		
		driver.switchTo().window(allWindowList.get(1));
		
		//String windowTitle = 
			
		//System.out.println(x);
		
		
		
		
		
	}		
		
		
		
		
		
		
	}
		
		
		
		
		

	
	
	

