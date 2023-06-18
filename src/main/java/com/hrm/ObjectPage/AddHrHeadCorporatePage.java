package com.hrm.ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.GenericUtility.ExcelUtility;
import com.hrm.GenericUtility.WebDriverUtility;

public class AddHrHeadCorporatePage {
	@FindBy(xpath="//button[@class='btn btn-primary']/ancestor::div[1]/descendant::h3")
	private WebElement addCorporate;
	
	@FindBy(xpath="//input[@placeholder='Corporate Name']")
	private WebElement copName;
	
	@FindBy(xpath="//button[.='Save']")
	private WebElement saveCorp;
	
	public AddHrHeadCorporatePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getAddCorporate() {
		return addCorporate;
	}

	public WebElement getCopName() {
		return copName;
	}
	
 
	public WebElement getSaveCorp() {
		return saveCorp;
	}

	public void AddCorporate(WebDriverUtility wLib,WebDriver driver,ExcelUtility rLib) throws Throwable, Throwable {
		addCorporate.click();
		copName.sendKeys(rLib.readExcelData("book", 1, 6));
		saveCorp.click();
		wLib.acceptAlert(driver);
	}
}
