package HrAssistant_Module;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.GenericUtility.JavaUtility;
import com.hrm.GenericUtility.ExcelUtility;
import com.hrm.GenericUtility.WebDriverUtility;
import com.hrm.ObjectPage.DeleteHrAssistantEmployeepage;
import com.hrm.ObjectPage.HomePage;
import com.hrm.ObjectPage.LoginPage;

public class HrAssistant_DelTest {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
        ExcelUtility rLib=new ExcelUtility();
        WebDriverUtility wLib=new WebDriverUtility();
        JavaUtility jLib=new JavaUtility();
        HashMap<String, String> fields=new HashMap<String, String>();
        wLib.forPageLoad(driver);
        wLib.maximizeWindow(driver);
        {
        	driver.get("http://rmgtestingserver/domain/HRM_System/");
        	LoginPage lp=new LoginPage(driver);
        	lp.HRAsisstantLogin(wLib, driver);
        	
        	HomePage hp=new HomePage(driver);
        	hp.clickAssistantEmployee();
        	
        	DeleteHrAssistantEmployeepage dHp=new DeleteHrAssistantEmployeepage(driver);
        	dHp.deleteEmploye(wLib, driver);
        	
        	
	}

}
}