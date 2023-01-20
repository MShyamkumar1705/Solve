package com.hrm.ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.GenericUtility.ReadExcelDataUtility;
import com.hrm.GenericUtility.WebDriverUtility;

public class AddHrHeadBranchPage {
	
	@FindBy(xpath="//button[@class='btn btn-primary']/preceding::h3")
	private WebElement addBranch;
	
	@FindBy(xpath="//input[@placeholder='Branches Name']")
	private WebElement branchName;
	
	@FindBy(xpath="//button[.='Save']")
	private WebElement saveBranch;
	
	public AddHrHeadBranchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddBranch() {
		return addBranch;
	}

	public WebElement getBranchName() {
		return branchName;
	}

	public WebElement getSaveBranch() {
		return saveBranch;
	}
public void AddBranch(WebDriverUtility wLib,ReadExcelDataUtility rLib,WebDriver driver) throws Throwable, Throwable {
	addBranch.click();
	branchName.sendKeys(rLib.readExcelData("book", 1, 7));
	saveBranch.click();
	wLib.acceptAlert(driver);
}
}
