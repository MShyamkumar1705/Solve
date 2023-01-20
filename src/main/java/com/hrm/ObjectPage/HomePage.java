package com.hrm.ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="(//i[@class='fas fa-angle-left right'])[1]")
	private WebElement hrCorp;
	
	@FindBy(xpath="//p[.='Add Corporate']")
	private WebElement corpClick;
	
	@FindBy(xpath="//a[@class='nav-link']/ancestor::ul/descendant::i[@class='nav-icon fas fa-code-branch']")
	private WebElement hrBranch;
	
	@FindBy(xpath="//p[.='Add Braches']")
	private WebElement branchClick;

    @FindBy(linkText ="EMPLOYEE")
    private WebElement hrHeadEmploye;
    
    @FindBy(xpath="(//a[@class='nav-link'])[8]")
    private WebElement HeademployeeClick;
    
    @FindBy(linkText ="EMPLOYEE")
    private WebElement hrAssistantEmploye;
    
    @FindBy(xpath="(//a[@class='nav-link'])[4]")
    private WebElement AssistantEmployee;
    
    @FindBy(linkText ="EMPLOYEE")
    private WebElement hrOfficerEmploye;
    
    @FindBy(xpath="(//a[@class='nav-link'])[4]")
    private WebElement OfficerEmployee;
    
    
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public WebElement getHrCorp() {
	return hrCorp;
}
public WebElement getCorpClick() {
	return corpClick;
}
public WebElement getHrBranch() {
	return hrBranch;
}
public WebElement getBranchClick() {
	return branchClick;
}

public WebElement getHrEmploye() {
	return hrHeadEmploye;
}
public WebElement getEmployeeClick() {
	return HeademployeeClick;
}

public WebElement getHrAssistantEmploye() {
	return hrAssistantEmploye;
}
public WebElement getAssistantEmployee() {
	return AssistantEmployee;
}

public WebElement getHrOfficerEmploye() {
	return hrOfficerEmploye;
}
public WebElement getOfficerEmployee() {
	return OfficerEmployee;
}
public void ClickCorporate() {
	hrCorp.click();
	corpClick.click();
}
public void clickBranch() {
	hrBranch.click();
	branchClick.click();
	}
public void clickHeadEmployee() {
	hrHeadEmploye.click();
	HeademployeeClick.click();
	}
public void clickAssistantEmployee() {
	hrAssistantEmploye.click();
	AssistantEmployee.click();
}
public void clickOfficerEmployee() {
	hrOfficerEmploye.click();
	OfficerEmployee.click();
}
}