package com.tech.training;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class InputForm1 extends BaseTest {

	String year = "2016";
	String month = "Jun";
	String day = "21";

	@Test
	public void multiSelectListTest() {

		selectMenu("Input Forms");
		selectMenu("Select Dropdown List");
		
		driver.findElement(By.linkText("Input Forms")).click();
		//driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Select Dropdown List")));
		driver.findElement(By.linkText("Select Dropdown List")).click();
		WebElement multiSelectWE = driver.findElement(By.id("multi-select"));

		Select multiSelect = new Select(multiSelectWE);

		multiSelect.selectByVisibleText("Florida");

		Actions actions = new Actions(driver);

		actions.keyDown(Keys.CONTROL).build().perform();
		multiSelect.selectByVisibleText("New York");
		actions.keyUp(Keys.CONTROL).build().perform();
		// multiSelect.deselectAll();
		// .//*[@id='treemenu']/.//a[contains(text(),'Input Forms')]
	}

	@Test
	public void datePickerExample() {
		driver.findElement(By.xpath(".//*[@id='treemenu']/.//a[contains(text(),'Date pickers')]")).click();
		driver.findElement(By.linkText("Bootstrap Date Picker")).click();

		driver.findElement(By.cssSelector("input[placeholder='dd/mm/yyyy']")).click();

		driver.findElement(By.xpath(".//*[@class='datepicker-days']/.//*[@class='datepicker-switch']")).click();

		pickFromDatePicker("months", "2017");

		pickFromDatePicker("years", "2016");

		By juneBy = By.xpath(".//*[@class='datepicker-months']/.//*[@class='datepicker-switch']");
		driver.findElement(juneBy).click();

		By $20thBy = By.xpath(".//div[@class='datepicker-days']/.//*[contains(text(),'21')]");
		driver.findElement($20thBy).click();

		waitFor(10);
		// xpaths and css can be made dynamic using String variable
	}

	//This is not a @Test. It is a regular common function
	public void pickFromDatePicker(String type, String value) {
		By xpath = By.xpath(".//div[@class='datepicker-" + type + "']/.//*[contains(text(),'" + value + "')]");
		driverWait.until(ExpectedConditions.elementToBeClickable(xpath));
		driver.findElement(xpath).click();

	}

	@Test
	public void radioButtonTest() {

		selectMenu("Input Forms");
		selectMenu("Radio Buttons Demo");

		String radioMaleXpath = ".//div[contains(text(),'Radio Button Demo')]/following-sibling::div/label/input[@value='Male']";
		driver.findElement(By.xpath(radioMaleXpath)).click();

		driver.findElement(By.id("buttoncheck")).click();

		String textDisplayed = driver.findElement(By.cssSelector("p.radiobutton")).getText();
		takeScreenshot("radioButtonTest");
		Assert.assertTrue("The message displayed for 'Male' selection is not correct",
				textDisplayed.contains("Radio button 'Male' is checked"));

	}

	public void takeScreenshot(String fileName) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(file, new File("E:/SeleniumWebdriver/screenshots/" + fileName + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void takeScreenShotTest() {
		selectMenu("Input Forms");
		selectMenu("Radio Buttons Demo");

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		try {
			//FileUtils requires commons library
			FileUtils.copyFile(file, new File("E:/SeleniumWebdriver/screenshots/radioButtonTest.jpg"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void javaScriptAlert() {

		selectMenu("Alerts & Modals");
		selectMenu("Javascript Alerts");

		// locator for Click me button
		By clickMe = By.cssSelector(".btn.btn-default");

		// .//p[@id='confirm-demo']/preceding-sibling::button[@class='btn
		// btn-default btn-lg']

		// wait for button to be clickable
		driverWait.until(ExpectedConditions.elementToBeClickable(clickMe));

		driver.findElement(clickMe).click();

		// click Action
		/*
		 * Actions action = new Actions(driver); WebElement clickMeElement =
		 * driver.findElement(clickMe);
		 * action.click(clickMeElement).build().perform();
		 */

		waitFor(3);

		// Wait for Alert
		driverWait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();

		alert.accept();

		Assert.assertTrue(alertMessage.equals("Press a button!"));
		
		/*
		 //When alert doesnt pop up regularly
		  //refer https://stackoverflow.com/questions/26772793/org-openqa-selenium-unhandledalertexception-unexpected-alert-open
		 DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		d = new FirefoxDriver(dc);
		
		try {
			driver.findElement(clickMe);
		} catch (UnhandledAlertException e) {
			try {
				driverWait.until(ExpectedConditions.alertIsPresent());
				Alert alert1 = driver.switchTo().alert();
				alert1.accept();
			} catch (NoAlertPresentException ee) {
				ee.printStackTrace();
			}
		}*/
	 
	}

	@Test
	public void javaScriptAlert2() {
		selectMenu("Alerts & Modals");
		selectMenu("Javascript Alerts");

		By clickMe = By.xpath("(.//*[@class='btn btn-default btn-lg'])[2]");

		findAndClickElement(clickMe);

		/*
		 * Actions action = new Actions(driver); WebElement clickMeElement =
		 * driver.findElement(clickMe);
		 * action.click(clickMeElement).build().perform();
		 */
		// waitFor(3);
		driverWait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		// alert.getText();
		alert.sendKeys("TEST");
		waitFor(5);
		alert.accept();
	}

	@Test
	public void modalPopUp() {
		selectMenu("Alerts & Modals");
		selectMenu("Bootstrap Modals");
		By clickMe = By.linkText("Launch modal");
		driverWait.until(ExpectedConditions.elementToBeClickable(clickMe));
		Actions action = new Actions(driver);
		WebElement clickMeElement = driver.findElement(clickMe);
		action.click(clickMeElement).build().perform();
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save changes")));
		driver.findElement(By.linkText("Save changes")).click();
	}

	@Test
	public void windowPopUp() {
		selectMenu("Alerts & Modals");
		selectMenu("Window Popup Modal");
/*		By follow = By.partialLinkText("Follow On Twitter");
		driverWait.until(ExpectedConditions.elementToBeClickable(follow));

		WebElement followElement = driver.findElement(follow);
		followElement.click();
*/
		driver.findElement(By.partialLinkText("Like us On Facebook")).click();

		String mainWindow = driver.getWindowHandle();
			
		

		Set<String> allWindows = driver.getWindowHandles();

		ArrayList<String> allWindowsList = new ArrayList<String>(allWindows);

		driver.switchTo().window(allWindowsList.get(1));
		driver.manage().window().maximize();
	/*	By linkOnNewWindow = By.name("commit");
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(linkOnNewWindow));
		System.out.println(driver.findElement(linkOnNewWindow).getAttribute("value"));

		driver.close();
*/
		// switch to fb page
		driver.switchTo().window(allWindowsList.get(2));

		// do something on fb page

		driver.close();

		driver.switchTo().window(mainWindow);

		// other
	}

	public void selectMenu(String menuText){
		//Note there are two links with same text for menu options e.g. Date pickers
		driver.findElement(By.xpath(".//*[@id='treemenu']/.//a[contains(text(),'"+ menuText +"')]")).click();
	}
	
	@Test
	public void frames() {
		//driver.navigate().to("https://developer.mozilla.org/en/docs/Web/HTML/Element/iframe#Example2");
		// also can do
		driver.get("https://developer.mozilla.org/en/docs/Web/HTML/Element/iframe#Example2");
		
		By googleMapLink = By.xpath(".//div[@class='google-maps-link']/a");

		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frame_Example2")));
		WebElement innerFrame = driver.findElement(By.id("frame_Example2"));
		//switch to inner frame
		driver.switchTo().frame(0);
		driver.switchTo().frame("name");
		driver.switchTo().frame(innerFrame);
		
		
		//switch to innermost frame
		driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Example2")));
		//Or you can do..
		//driver.switchTo().frame(driver.findElement(By.id("Example2")));
		
		//Below is another way to wait as well as find element
		WebElement mapLink = driverWait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath(".//div[@class='google-maps-link']/a")));
		
		System.out.println(mapLink.getText());
		
		//switch to frame with id=frame_Example2 (innerFrame)
		driver.switchTo().parentFrame();
		
		//switch to default (main web page)
		driver.switchTo().defaultContent();
		
		System.out.println(findElement(By.id("Examples")).getText());
	}
	
	@Test
	public void frames1() {
		driver.get("https://www.tutorialspoint.com/html/html_frames.htm");
		
		WebElement frame = driver.findElement(
				By.xpath(".//iframe[@title='3rd party ad content']"));
		
		driver.switchTo().frame(frame);
		
		driver.findElement(By.id("img_ad")).click();;
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void dropdownList(){
		selectMenu("Input Forms");
		selectMenu("Select Dropdown List");
		//try this by your own
		
	}
	
}
