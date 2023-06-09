package com.hrm.ObjectPage;

import java.io.File;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.GenericUtility.JavaUtility;
import com.hrm.GenericUtility.ExcelUtility;
import com.hrm.GenericUtility.WebDriverUtility;

public class AddHrHeadEmployeePage {

	@FindBy(xpath="//button[@class='btn btn-primary']/preceding::h3")
	private WebElement addEmployee;
	
	@FindBy(xpath="//button[.='Save']")
	private WebElement saveEmployee;
	
	@FindBy(name="employee_companyid")
	private WebElement companyId;
	
	@FindBy(name="employee_firstname")
	private WebElement firstName;
	
	@FindBy(name="employee_lastname")
	private WebElement lastName;
	
	@FindBy(name="employee_middlename")
	private WebElement middleName;
	
	@FindBy(name="branches_datefrom")
	private WebElement dateFrom;
	
	@FindBy(name="branches_recentdate")
	private WebElement dateTo;
	
	@FindBy(name="employee_department")
	private WebElement department;
	
	@FindBy(name="employee_branches")
	private WebElement branches;
	
	@FindBy(name="employee_position")
	private WebElement position;

	@FindBy(name="employee_contact")
	private WebElement contactNo;
	
	@FindBy(name="employee_sss")
	private WebElement sss;
	
	@FindBy(name="employee_tin")
	private WebElement tin;
	
	@FindBy(name="employee_hdmf_pagibig")
	private WebElement hdmf;
	
	@FindBy(name="employee_gsis")
	private WebElement gss;
	
	
	public AddHrHeadEmployeePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddEmployee() {
		return addEmployee;
	}
    public WebElement getSaveEmployee() {
		return saveEmployee;
	}
	public void AddHrHeadEmployee() {
		addEmployee.click();
	}

	
	public WebElement getCompanyId() {
		return companyId;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getMiddleName() {
		return middleName;
	}

	public WebElement getDateFrom() {
		return dateFrom;
	}

	public WebElement getDateTo() {
		return dateTo;
	}

	public WebElement getDepartment() {
		return department;
	}

	public WebElement getBranches() {
		return branches;
	}

	public WebElement getPosition() {
		return position;
	}

	public WebElement getContactNo() {
		return contactNo;
	}

	public WebElement getSss() {
		return sss;
	}

	public WebElement getTin() {
		return tin;
	}

	public WebElement getHdmf() {
		return hdmf;
	}

	public WebElement getGss() {
		return gss;
	}

	public void AddHrHeadEmployee(HashMap<String,String> fields,ExcelUtility rLib,JavaUtility jLib,WebDriver driver,WebDriverUtility wLib,String sheetName) throws InterruptedException, Throwable {
//		companyId.sendKeys(rLib.readExcelData("book", 1, 0));
//		firstName.sendKeys(rLib.readExcelData("book", 1, 1));
//		lastName.sendKeys(rLib.readExcelData("book", 1, 2));
//		middleName.sendKeys(rLib.readExcelData("book", 1, 3));
//		dateFrom.sendKeys(rLib.readExcelData("book", 1, 4));
//		dateTo.sendKeys(rLib.readExcelData("book", 1, 5));
//		department.sendKeys(rLib.readExcelData("book", 1, 6));
//		branches.sendKeys(rLib.readExcelData("book", 1, 7));
//		position.sendKeys(rLib.readExcelData("book", 1, 8));
//		contactNo.sendKeys(rLib.readExcelData("book", 1, 9)+jLib.getRandomNumber());
//		sss.sendKeys(rLib.readExcelData("book", 1, 10));
//		tin.sendKeys(rLib.readExcelData("book", 1, 11));
//		hdmf.sendKeys(rLib.readExcelData("book", 1, 12));
//		gss.sendKeys(rLib.readExcelData("book", 1, 13));
		rLib.list(driver, "Sheet2");
		File docx=new File("./src/test/resources/Mshyamkumar.docx");
			String docsPath = docx.getAbsolutePath();
			driver.findElement(By.name("employee_file201")).sendKeys(docsPath);
			Thread.sleep(2000);
			File img=new File("./src/test/resources/Screenshot (8).png");
			   String imgPath =img.getAbsolutePath();
			driver.findElement(By.name("employee_image")).sendKeys(imgPath);
			 driver.findElement(By.name("emplo")).click();

		   wLib.textAlert(driver);
		   Thread.sleep(6000);
		   wLib.acceptAlert(driver);
	}
}

