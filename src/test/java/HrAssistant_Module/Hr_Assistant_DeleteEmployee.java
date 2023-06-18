package HrAssistant_Module;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.GenericUtility.JavaUtility;
import com.hrm.GenericUtility.PropertyDataUtility;
import com.hrm.GenericUtility.ExcelUtility;
import com.hrm.GenericUtility.WebDriverUtility;

public class Hr_Assistant_DeleteEmployee {

	public static void main(String[] args) throws Throwable {

		WebDriver driver;
		JavaUtility jLib=new JavaUtility();
		PropertyDataUtility pLib=new PropertyDataUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		String expectedText = "Insert Successfully!!!";
		
		//Step 1:Get common Data
		String URL=pLib.getPropertyKeyValue("url");
		String USER=pLib.getPropertyKeyValue("user3");
		String PASSWORD=pLib.getPropertyKeyValue("password3");
		
		
		//Step 2:Login as HrAssistant
		driver=new ChromeDriver();
		wLib.forPageLoad(driver);
		wLib.maximizeWindow(driver);
		driver.get(URL);
		driver.findElement(By.name("hr_email")).sendKeys(USER);
		driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
		WebElement type = driver.findElement(By.id("hr_type"));
		wLib.select(type,3);
		driver.findElement(By.name("login_hr")).click();
		wLib.acceptAlert(driver);
		
		//Step 3:Delete the Employee
		driver.findElement(By.xpath("(//a[@class='nav-link'])[3]")).click();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[4]")).click();
		String empName = eLib.readExcelData("book",1, 1);
		driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(empName);
	    driver.findElement(By.xpath("(//td[.='c_1'])[1]")).click();
	    JavascriptExecutor j=(JavascriptExecutor) driver;
	    j.executeScript("window.scrollBy(0,300)");
	    driver.findElement(By.xpath("(//i[@title='Delete Employee'])[2]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//div[@class='modal-content'])[10]/child::div[3]/descendant::button[2]")).click();
	   
//	    Object actualText = wLib.textAlert(driver);
//	    wLib.acceptAlert(driver);
	
	}
	
	

}
