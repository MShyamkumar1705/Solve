									package com.hrm.GenericUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	//WebDriver driver=new ChromeDriver();
	/**
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * 
	 * @param driver
	 */
	public void forPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitpageLoadforJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void elementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void select(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * 
	 * @param text
	 * @param element
	 */
	public void select(String text,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
		}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dest);
	}
	/**
	 * 
	 * @param driver
	 */
	public void rightClick(WebDriver driver) {
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**
	 * 
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver) {
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	public void moveOffset(WebDriver driver,int x,int y) {
		Actions a=new Actions(driver);
		a.moveByOffset(x,y).click().perform();
	}
	/**
	 * 
	 * @throws Throwable
	 */
	public void keyPress() throws Throwable {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * 
	 * @throws Throwable
	 */
	public void keyRelease() throws Throwable {
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * 
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * 
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver,WebElement address) {
		driver.switchTo().frame(address);
	}
	/**
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * 
	 * @param driver
	 * @param partialWindTitle
	 * @return 
	 */
	public Object textAlert(WebDriver driver) {
		String actualText = driver.switchTo().alert().getText();
		return actualText;
		
		
	}
	/**
	 * 
	 * @param driver
	 * @param partialWindTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWindTitle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		while(it.hasNext()) {
			String wind=it.next();
			String currentWindTitle = driver.switchTo().window(wind).getTitle();
			
			if(currentWindTitle.contains(partialWindTitle)) {
				break;
			}
		}
	}
	/**
	 * 
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws Throwable
	 */
	public String getScreenShot(WebDriver driver,String screenShotName) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\" +screenShotName+ ".png";
		File dest=new File(path);
		FileUtils.copyFile(src,dest);
		return path;
	}
	/**
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y)");
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */
	public void scrollAction(WebDriver driver,WebElement element,int x,int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y)",element);
	}
	
	public   WebDriver browser(WebDriver driver, String browserTag) {
		//	f
		if(browserTag.equalsIgnoreCase("Chrome"))

		{
		
			driver =new ChromeDriver();
		}
		else if (browserTag.equalsIgnoreCase("FireFox"))
		{

			driver=new FirefoxDriver();
		}
		else {
			System.out.println("No such driver");
		}
		return driver;
	}
}
