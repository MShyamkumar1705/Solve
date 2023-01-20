package com.hrm.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.hrm.ObjectPage.LoginPage;
import com.hrm.ObjectPage.LogoutPage;

public class HRMHeadBaseClass {
	public static WebDriver sdriver;
	public WebDriver driver;
	public WebDriverUtility wLib=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();
	public ReadExcelDataUtility rLib=new ReadExcelDataUtility();
	public PropertyDataUtility pLib=new PropertyDataUtility();
	public DataBaseUtility dLib=new DataBaseUtility();
	public FileUtility fLib=new FileUtility();
	
	@BeforeSuite(groups= {"smoke","regression"})
	public void connectToDB() {
		System.out.println("--Connect to DataBase---");
	}
	@Parameters("BROWSER")
	@BeforeClass(groups= {"smoke","regression"})
	public void openBrowser() throws Throwable {
		String BROWSER=pLib.getPropertyKeyValue("browser");
		String URL=pLib.getPropertyKeyValue("url");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			System.out.println("Launch the chrome browser");
			
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			System.out.println("Launch the FireFox Browser");
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("InternetExplorer")){
			System.out.println("Launch the Internet Explorer");
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		sdriver=driver;
		wLib.maximizeWindow(driver);
		wLib.forPageLoad(driver);
		driver.get(URL);
	}
	@BeforeMethod(groups= {"smoke","regression"})
	public void loginAsHead() {
	
		LoginPage lp=new LoginPage(driver);
		lp.HRHeadLogin(wLib, driver);
		
			
		}
	@AfterMethod(groups= {"smoke","regression"})
	public void logOutAsHead() {
//		LogoutPage lo=new LogoutPage(driver);
//		lo.hrLogout(driver, wLib);
//		System.out.println("Logout As HR Head");
		
	}
	@AfterClass(groups= {"smoke","regression"})
	public void closeBrowser() {
//		driver.close();
//		System.out.println("---Close the Browser---");
	}
	@AfterSuite(groups= {"smoke","regression"})
	public void disconnectFromDB() {
		System.out.println("---Disconnected from DB--");
	}
}
