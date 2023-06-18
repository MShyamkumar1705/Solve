package HrHead_Module;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.GenericUtility.JavaUtility;
import com.hrm.GenericUtility.PropertyDataUtility;
import com.hrm.GenericUtility.ExcelUtility;
import com.hrm.GenericUtility.WebDriverUtility;
import com.hrm.GenericUtility.iPathContent;

public class HrHead_GenericAddBranch {

	public static void main(String[] args) throws Throwable {
		WebDriver driver;
		JavaUtility jLib=new JavaUtility();
		PropertyDataUtility pLib=new PropertyDataUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		String expectedText = "Insert Successfully!!!";
		
		//Step 1:Get common Data
		String URL=pLib.getPropertyKeyValue("url");
		String USER=pLib.getPropertyKeyValue("user1");
		String PASSWORD=pLib.getPropertyKeyValue("password1");
		
		
		//Step 2:Login as HrAssistant
		driver=new ChromeDriver();
		wLib.forPageLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("hr_email")).sendKeys(USER);
		driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
		WebElement type = driver.findElement(By.id("hr_type"));
		wLib.select(type,1);
		driver.findElement(By.name("login_hr")).click();
		wLib.acceptAlert(driver);
		
		//Step 3:Go to Add Branch
		driver.findElement(By.xpath("(//a[@class='nav-link'])[3]")).click();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[4]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']/ancestor::section/descendant::h3")).click();
		String data = eLib.AddBranch("book");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(data);
		driver.findElement(By.xpath("//button[.='Save']")).click();
		Object actualText = wLib.textAlert(driver);
		wLib.acceptAlert(driver);
	
		//Step 4:Verify the Added Branch
		if(actualText.equals(expectedText)) {
			System.out.println("Corporate added successfully");
		}
		else {
			System.out.println("Corporate not added");
		}
		
		driver.findElement(By.xpath("//label[.='Search:']")).sendKeys(data);
		List<WebElement> list = driver.findElements(By.xpath("(//td[.='"+data+"'])[1]"));
		int count=0;
		for(int i=0;i<list.size();i++) {
			String actualBranchName = list.get(i).getText();
			count++;
			if(actualBranchName.equals(data)) {
				System.out.println("Entered Branch name is shown in corporate list page:");
			}
			else {
				System.out.println("Entered Branch name is invalid");
			}
	if(count>0) {
		System.out.println("Multiple Branch Name");
		 List<WebElement> verify = driver.findElements(By.xpath("(//td[.='"+data+"'])[1]"));
		 String verifyBranchName = list.get(i).getText();
		 System.out.println(verifyBranchName);
		System.out.println(count++);
	}
	else if(count==1) {
		System.out.println("Branch is added ");
	}

	}

}
}