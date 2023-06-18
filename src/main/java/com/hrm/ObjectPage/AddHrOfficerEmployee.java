package com.hrm.ObjectPage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.GenericUtility.ExcelUtility;
import com.hrm.GenericUtility.WebDriverUtility;

public class AddHrOfficerEmployee {

	@FindBy(xpath="//button[@class='btn btn-primary']/preceding::h3")
	private WebElement addEmployee;
	
	@FindBy(xpath="//button[.='Save']")
	private WebElement saveEmployee;
	
	public AddHrOfficerEmployee(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddEmployee() {
		return addEmployee;
	}

	public WebElement getSaveEmployee() {
		return saveEmployee;
	}
	public void AddHrOfficerEmployee(ExcelUtility rLib,WebDriver driver,WebDriverUtility wLib) throws Throwable {
		addEmployee.click();
		rLib.list(driver, "Sheet2");
		File docx=new File("./src/test/resources/Mshyamkumar.docx");
			String docsPath = docx.getAbsolutePath();
			driver.findElement(By.name("employee_file201")).sendKeys(docsPath);
			Thread.sleep(2000);
			File img=new File("./src/test/resources/Screenshot (8).png");
			   String imgPath =img.getAbsolutePath();
			driver.findElement(By.name("employee_image")).sendKeys(imgPath);
			// driver.findElement(By.name("emplo")).click();
			saveEmployee.click();

		   wLib.textAlert(driver);
		   Thread.sleep(6000);
		   wLib.acceptAlert(driver);
	}
}
