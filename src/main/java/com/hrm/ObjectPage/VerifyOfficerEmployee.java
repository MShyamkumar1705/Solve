package com.hrm.ObjectPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyOfficerEmployee {
	
	@FindBy(xpath="//select[@name='example1_length']")
	private WebElement show;
	
	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	private WebElement searchBox;
	
	@FindBy(xpath="//th[.='First Name']")
	private List<WebElement> firstName;
	
	public VerifyOfficerEmployee(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}

	public WebElement getShow() {
		return show;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}
	
public List<WebElement> getFirstName() {
		return firstName;
	}

public void execution() {
	show.sendKeys("100");
	searchBox.sendKeys("Tanweer");
	for(int i=0;i<firstName.size();i++) {
		String text = firstName.get(i).getText();
		
	}
}
}
