package HrAssistant_Module;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HrAssistant_EditEmployee {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Random r=new Random();

		//Step1:Get Common data
		FileInputStream fis=new FileInputStream("./src/test/resources/hrhead.properties");
		Properties p= new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USER=p.getProperty("user1");
		String PASSWORD=p.getProperty("password1");
		
		

		//Read Data from excel
		FileInputStream fi=new FileInputStream("./src/test/resources/HRM.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet1");
		Row rw = sh.getRow(0);
		short cell = rw.getLastCellNum();
		String orgName=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
	
	
		//Login as HR Assistant
		driver.get(URL);
		driver.findElement(By.name("hr_email")).sendKeys(USER);
		driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
		WebElement selectType = driver.findElement(By.id("hr_type"));
		Select s=new Select(selectType);
		s.selectByIndex(3);
		driver.findElement(By.name("login_hr")).click();
		Alert a;
		a=driver.switchTo().alert();
		a.accept();
		
		
		//Verify the enter name in employee list page
		driver.findElement(By.xpath("(//a[@class='nav-link'])[3]")).click();
		driver.findElement(By.xpath("//p[text()='Add Employee']")).click();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(orgName);
		List<WebElement> name = driver.findElements(By.xpath("//td[text()='Mohammad-1089914258']"));
		for(int i=0;i<name.size();i++) {
			String actualName = name.get(i).getText();
			
			if(actualName.contains(orgName)) {
				System.out.println( orgName+ " is in the employee listbox");
		}
			else {
				System.out.println("Enter" +orgName+ "is invalid");
			}
			
		
		//Edit the entered employee name
			driver.findElement(By.xpath("//td[@class='sorting_1']")).click();
			JavascriptExecutor j=(JavascriptExecutor) driver;
			j.executeScript("window.scrollBy(0,300)");
			driver.findElement(By.xpath("//span[@class='dtr-data']/child::i[@class='fa fa-edit']")).click();
           // j.executeScript("window.scrollBy(0,500)");
			WebDriverWait wait=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='form-group']/child::input[@value='Mohammad-1089914258'])[1]")));
		
			WebElement sam = driver.findElement(By.xpath("(//div[@class='form-group']/child::input[@value='Mohammad-1089914258'])[1]"));
			sam.click();
			Robot r1=new Robot();
			r1.keyPress(KeyEvent.VK_CONTROL);
			r1.keyPress(KeyEvent.VK_A);
			r1.keyRelease(KeyEvent.VK_CONTROL);
			sam.sendKeys(orgName);
			WebElement sam1 = driver.findElement(By.xpath("(//input[@name='employee_gsis'])[18]"));
			sam1.click();
			r1.keyPress(KeyEvent.VK_CONTROL);
			r1.keyPress(KeyEvent.VK_A);
			r1.keyRelease(KeyEvent.VK_CONTROL);
			sam1.sendKeys("1233445");
			Thread.sleep(2000);
			
			File f=new File("./src/test/resources/ALM PROJECT.docx");
			String docsPath = f.getAbsolutePath();
			driver.findElement(By.xpath("(//input[@name='employee_file201'])[10]")).sendKeys(docsPath);
		    File f1=new File("./src/test/resources/Screenshot (8).png");
			String imgPath = f1.getAbsolutePath();
			driver.findElement(By.xpath("(//input[@name='employee_image'])[10]")).sendKeys(imgPath);
			driver.findElement(By.xpath("(//button[.='Update']/ancestor::div[@class='modal-footer justify-content-between']/descendant::button[@class='btn btn-primary'])[9]")).click();
			
			String actualText=a.getText();
			a.accept();
			String expectedText = "Update Successfully";
			
			if(actualText.equalsIgnoreCase(expectedText)) {
				System.out.println("Employee details updated Successfully");
			}
			else {
				System.out.println("Not updated");
			}
			driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(orgName);
		List<WebElement> search1 = driver.findElements(By.xpath("//td[.='Mohammad']"));
		for(int i1=0;i1<search1.size();i1++) {
			String updateName = search1.get(i).getText();
			if(updateName.equalsIgnoreCase(orgName)) {
				System.out.println("updated Employee details are Shown in employee listPage");
			}
			else {
				System.out.println("Not updated ");
			}
		}
		
		}
	}

}
