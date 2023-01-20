import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class Hr_Assistant_DeleteEmployee {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Random r=new Random();
		String expectedText="deleted Successfully!!!";

		//Step1:Get Common data
		FileInputStream fis=new FileInputStream("./src/test/resources/hrm.properties");
		Properties p= new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USER=p.getProperty("user3");
		String PASSWORD=p.getProperty("password3");
		
		//Get Excel Data
		FileInputStream fi=new FileInputStream("./src/test/resources/HRM.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("book");
		Row rw = sh.getRow(0);
		short cell = rw.getLastCellNum();
		String orgName=wb.getSheet("book").getRow(1).getCell(1).getStringCellValue();
		
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
				List<WebElement> name = driver.findElements(By.xpath("//td[text()='Mohammad']"));
				for(int i=0;i<name.size();i++) {
					String actualName = name.get(i).getText();
					
					if(actualName.contains(orgName)) {
						System.out.println( orgName+ " is in the employee listbox");
				}
					else {
						System.out.println("Enter" +orgName+ "is invalid");
					}
					//name.get(name.size()-1).click();
					driver.findElement(By.xpath("//td[@class='sorting_1' and .='TY_SDET45_01-1089914258']")).click();
					JavascriptExecutor j=(JavascriptExecutor) driver;
					j.executeScript("window.scrollBy(0,300)");
					driver.findElement(By.xpath("//span[@class='dtr-data']/child::i[@class='fa fa-trash']")).click();		
					
					driver.findElement(By.xpath("(//div[@class='modal-content'])[31]/child::div[3]/child::button[@class='btn btn-danger']")).click();
					
					String actualText = a.getText();
					a.accept();
					if(actualText.equalsIgnoreCase(expectedText)) {
						System.out.println("Employee deleted successfully");
					}
					else {
						System.out.println("employee not deleted");
					}
					driver.findElement(By.xpath("//input[@type='search']")).sendKeys(orgName);
					List<WebElement> list = driver.findElements(By.xpath("//td[.='Mohammad']"));
					for(int k=0;k<list.size();k++) {
						String actualCorpName = list.get(k).getText();
						if(actualCorpName.equals(orgName)) {
							System.out.println("Entered employee name is not shown in employee list page:");
						}
						else {
							System.out.println("Entered employee name is in the list page");
						}}
	}

	}
}
