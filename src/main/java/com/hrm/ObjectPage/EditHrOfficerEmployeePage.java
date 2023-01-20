package com.hrm.ObjectPage;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.GenericUtility.ReadExcelDataUtility;
import com.hrm.GenericUtility.WebDriverUtility;

public class EditHrOfficerEmployeePage {
	
	@FindBy(xpath="//label[.='Search:']")
	private WebElement searchBox;
	
	@FindBy(xpath="//td[@class='sorting_1']")
	private List<WebElement> button;
	
	@FindBy(xpath="//td[@class='child']/child::ul/child::li[2]/child::span[@class='dtr-data']/i[@class='fa fa-edit']")
	private WebElement edit;
	
	
	@FindBy(xpath="//div[@class='modal-content']/child::div[@class='modal-body']/child::div/descendant::input[@name='employee_firstname']")
	private WebElement editName;
	
	@FindBy(xpath="//input[@name='employee_file201']")
	private List<WebElement> docsFile;
	
	@FindBy(xpath="//input[@name='employee_image']")
	private List<WebElement> imgFile;
	
	@FindBy(xpath="//div[@class='modal-content']/child::div[@class='modal-footer justify-content-between']/descendant::button[.='Update']")
	private List<WebElement> update;
	
	public EditHrOfficerEmployeePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public List<WebElement> getButton() {
		return button;
	}

	


	public WebElement getEdit() {
		return edit;
	}

	public WebElement getEditName() {
		return editName;
	}
	public  List<WebElement> getUpdate() {
		return update;
	}
	
	
	public List<WebElement> getDocsFile() {
		return docsFile;
	}

	
	public List<WebElement> getImgFile() {
		return imgFile;
	}

	
	public void editHrOfficer(WebDriverUtility wLib,WebDriver driver,ReadExcelDataUtility rLib) throws Throwable {
		searchBox.sendKeys("Shyam");
		for(int i=0;i<button.size();i++) {
			button.get(i).click();
			break;
			}

		//wLib.scrollBarAction(driver, 1, 300);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		
		edit.click();
		
		
			
		
		
		
		
//		if(rLib.readExcelData("book", 1, 1).equals(editName)) {
//			editName.click();
//			Robot r=new Robot();
//			
//			r.keyPress(KeyEvent.VK_CONTROL);
//			r.keyPress(KeyEvent.VK_A);
//			r.keyRelease(KeyEvent.VK_CONTROL);
//			r.keyPress(KeyEvent.VK_CLEAR);
//		editName.sendKeys(rLib.readExcelData("book", 1, 2));
//		}
		
		
		for(int i=0;i<docsFile.size();i++) {
			File f=new File("./src/test/resources/ALM PROJECT.docx");
			String docsPath = f.getAbsolutePath();
			docsFile.get(i).sendKeys(docsPath);
			
		}
		for(int i=0;i<imgFile.size();i++) {
			File f1=new File("./src/test/resources/Screenshot (8).png");
			String imgPath = f1.getAbsolutePath();
			imgFile.get(i).sendKeys(imgPath);
			
		}
		
		for(int i=0;i<update.size();i++) {
		update.get(i).click();
		System.out.println("Updated Successfully");
		}
		wLib.textAlert(driver);
			wLib.acceptAlert(driver);
			
		
		
		
	}
}
