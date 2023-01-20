package com.hrm.ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.GenericUtility.WebDriverUtility;
import com.hrm.GenericUtility.iPathContent;

public class LoginPage {
	@FindBy(name="hr_email")
	private WebElement hrUser;
	
	@FindBy(name="hr_password")
	private WebElement hrPassword;
	
	@FindBy(name="hr_type")
	private WebElement hrType;
	
	@FindBy(name="login_hr")
	private WebElement hrLogoin;
	


public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public WebElement getHrUser() {
	return hrUser;
}


public WebElement getHrPassword() {
	return hrPassword;
}


public WebElement getHrType() {
	return hrType;
}


public WebElement getHrLogoin() {
	return hrLogoin;
}

public void HRHeadLogin(WebDriverUtility wLib,WebDriver driver) {
	hrUser.sendKeys(iPathContent.HEADUSER);
	hrPassword.sendKeys(iPathContent.HEADPASSWORD);
	wLib.select(hrType, 1);
	hrLogoin.click();
	wLib.acceptAlert(driver);
	}
public void HRAsisstantLogin(WebDriverUtility wLib,WebDriver driver) {
	hrUser.sendKeys(iPathContent.ASSISTANTUSER);
	hrPassword.sendKeys(iPathContent.ASSISTANTPASSWORD);
	wLib.select(hrType, 3);
	hrLogoin.click();
	wLib.acceptAlert(driver);
}
public void HROfficerLogin(WebDriverUtility wLib,WebDriver driver) {
	hrUser.sendKeys(iPathContent.OFFICERUSER);
	hrPassword.sendKeys(iPathContent.OFFICERPASSWORD);
	wLib.select(hrType, 2);
	hrLogoin.click();
	wLib.acceptAlert(driver);
}
}