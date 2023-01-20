package HrAssistant_Module;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Multiset.Entry;

public class HrAssistant_Employee {

	public static void main(String[] args) throws IOException, InterruptedException {
		// WebDriverManager.chromedriver().create();
		  WebDriver driver = new ChromeDriver();
		  ChromeOptions option=new ChromeOptions();
				  option.addArguments("--enabled Notification");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
Random r=new Random();
int random = r.nextInt();
String expected = "Insert Successfully";
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
String orgName=wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();

//Login as HR Head
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

//Add Employee in HR Head
 driver.findElement(By.xpath("(//a[@class='nav-link'])[3]")).click();
driver.findElement(By.linkText("Add Employee")).click();
driver.findElement(By.xpath("//button[@class='btn btn-primary']/ancestor::div[1]/descendant::h3")).click();

ArrayList<String> al=new ArrayList<String>();
al.add("employee_companyid");
al.add("employee_firstname");
al.add("employee_lastname");
al.add("employee_middlename");
//al.add("branches_datefrom");
//al.add("branches_recentdate");
al.add("employee_department");
al.add("employee_branches");
al.add("employee_position");
al.add("employee_contact");
al.add("employee_sss");
al.add("employee_tin");
al.add("employee_hdmf_pagibig");
al.add("employee_gsis");
for(int i=0;i<cell;i++) {
	String value=sh.getRow(1).getCell(i).getStringCellValue()+random;
	driver.findElement(By.name(al.get(i))).sendKeys(value);
	
}
driver.findElement(By.name("branches_datefrom")).sendKeys("23-12-2022");
driver.findElement(By.name("branches_recentdate")).sendKeys("12-01-2023");

File docx=new File("./src/test/resources/Mshyamkumar.docx");
String docsPath = docx.getAbsolutePath();
driver.findElement(By.name("employee_file201")).sendKeys(docsPath);
Thread.sleep(2000);
File img=new File("./src/test/resources/Screenshot (8).png");
   String imgPath =img.getAbsolutePath();
driver.findElement(By.name("employee_image")).sendKeys(imgPath);
 driver.findElement(By.name("emplo")).click();
 
 
 //Verifying employee is added or not
 String actual=a.getText();
a.accept();
if(actual.contains(expected)) {
	System.out.println("Employee added successfully");
}
else {
	System.out.println("not Created");
}

driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(orgName);
List<WebElement> search = driver.findElements(By.xpath("//td[text()='mir']"));
int count = search.size();
String expectedName="mir";
for(int i=0;i<count;i++) {
	String actualName = search.get(i).getText();
	if(actualName.contains(expectedName)) {
		System.out.println("Employee Name is Presnt");
		System.out.println(orgName);
	}
	else {
		System.out.println("Employee name is not present");
	}
}
driver.close();
	}
	
}

