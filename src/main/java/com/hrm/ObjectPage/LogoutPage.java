package com.hrm.ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.GenericUtility.WebDriverUtility;

public class LogoutPage {
	@FindBy(xpath="//b[.='Welcome!,']")
	private WebElement hrCorpLogout;
	
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")
	private WebElement logout;
	
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getHrCorpLogout() {
		return hrCorpLogout;
	}
	
	public WebElement getLogout() {
		return logout;
	}

	public void hrLogout(WebDriver driver,WebDriverUtility wLib) {
		hrCorpLogout.click();
		logout.click();
		wLib.acceptAlert(driver);
		
	}

}
