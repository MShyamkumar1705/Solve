package HrHead_Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HrHead_AddBranches {

	public static void main(String[] args) throws IOException {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Random r=new Random();
		int random = r.nextInt();
		String expectedText="Insert Successfully!!!";
		
		//get common data
		FileInputStream fis=new FileInputStream("./src/test/resources/hrhead.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USER = p.getProperty("user");
		String PASSWORD = p.getProperty("password");
		String CORP = p.getProperty("corporate");
		String BRANCH = p.getProperty("branches");
		
		//get Excel data
		FileInputStream fi=new FileInputStream("./src/test/resources/HRM.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet1");
		String empName = sh.getRow(1).getCell(4).getStringCellValue();
		
		
		//Login as HrHead
		driver.get(URL);
		driver.findElement(By.name("hr_email")).sendKeys(USER);
		driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
			WebElement select = driver.findElement(By.id("hr_type"));
		Select s=new Select(select);
		s.selectByIndex(1);
		driver.findElement(By.xpath("//button[@name='login_hr']")).click();
		Alert a;
		a=driver.switchTo().alert();
		a.accept();
		
		//Add Branch
		driver.findElement(By.xpath("(//a[@class='nav-link'])[3]")).click();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[4]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']/ancestor::section/descendant::h3")).click();
	    driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(empName);
		driver.findElement(By.xpath("//button[.='Save']")).click();
		String actualText = a.getText();
		a.accept();
		if(actualText.equalsIgnoreCase(expectedText)) {
			System.out.println("Corporate added successfully");
		}
		else {
			System.out.println("Corporate not added");
		}
		driver.findElement(By.xpath("//label[.='Search:']")).sendKeys(empName);
		List<WebElement> list = driver.findElements(By.xpath("(//td[.='Test Department'])[1]"));
		for(int i=0;i<list.size();i++) {
			String actualCorpName = list.get(i).getText();
			if(actualCorpName.equals(empName)) {
				System.out.println("Entered corporate name is shown in corporate list page:");
			}
			else {
				System.out.println("Entered corporate name is invalid");
			}
		}
		
	}

}
