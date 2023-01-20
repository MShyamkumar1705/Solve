package com.hrm.ObjectPage;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.GenericUtility.WebDriverUtility;

public class DeleteHrAssistantEmployeepage {
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchBox;
	
	@FindBy(xpath="//td[@class='sorting_1']")
	private List<WebElement> radioButton;
	
	@FindBy(xpath="(//i[@title='Delete Employee'])[2]")
	private List<WebElement> delete;
	
	@FindBy(xpath="//button[.='Delete']")
	private List<WebElement> delButton;	
	
public DeleteHrAssistantEmployeepage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getSearchBox() {
	return searchBox;
}

public List<WebElement> getRadioButton() {
	return radioButton;
}

public List<WebElement> getDelete() {
	return delete;
}

public List<WebElement> getDelButton() {
	return delButton;
}
public void deleteEmploye(WebDriverUtility wLib,WebDriver driver) {
	searchBox.sendKeys("Shyam");
	for(int i=0;i<radioButton.size();i++) {
		radioButton.get(i).click();
		break;
	}
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,200)");
	
	for(int i=0;i<delete.size();i++) {
		delete.get(i).click();
		break;
	}
	
	for(int i=0;i<delButton.size();i++) {
		delButton.get(i).click();
		wLib.acceptAlert(driver);
	}
	//wLib.textAlert(driver);
	
	
}
}
