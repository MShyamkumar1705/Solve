package Practice_Package;

import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.hrm.GenericUtility.JavaUtility;
import com.hrm.GenericUtility.WebDriverUtility;

public class AutomateMakeMyTripForBus {

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("diabled-notifications");
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriver driver=new ChromeDriver(option);
		wLib.maximizeWindow(driver);
		wLib.forPageLoad(driver);
		driver.get("https://samdhruv05@gmail.com:Shyamkum@r05@www.makemytrip.com/flights/?cmp=SEM|M|DF|B|Brand|B_M_Makemytrip_Search_Exact|Brand_Top_5_Exact|Expanded|&s_kwcid=AL!1631!3!!e!!o!!makemytrip.com&ef_id=bad0e41b848f149e3f9087bac5ccd6c3:G:s");
		wLib.moveOffset(driver, 10, 10);
		driver.findElement(By.xpath("(//span[@class='chNavText darkGreyText']/parent::a[@class='makeFlex hrtlCenter column'])[5]")).click();
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("pondi");
		driver.findElement(By.xpath("//span[.='Mahe, Pondicherry State']")).click();
		wLib.moveOffset(driver, 10, 10);
		driver.findElement(By.id("toCity")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//span[@class='sr_city blackText' and .='Bangalore, Karnataka']")).click();
		wLib.moveOffset(driver, 10, 10);
		 driver.findElement(By.id("travelDate")).click();
	    Date date=new Date();
	    String[] d = date.toString().split(" ");
	    String day=d[0];
	    String month=d[1];
	    String cdate=d[2];
	    String year=d[5];
	    String travelDate=day+" "+month+" "+cdate+" "+year;
	    driver.findElement(By.xpath("//div[@aria-label='"+travelDate+"']")).click();
	    driver.findElement(By.xpath("//button[@type='button']")).click();
	    driver.findElement(By.xpath("//img[@class='primoCloseIcon']")).click();
	    List<WebElement> busList = driver.findElements(By.xpath("//span[@class='latoBlack font22 blackText appendRight15']"));
	    List<WebElement> price = driver.findElements(By.id("price"));
		for(int i=0;i<busList.size();i++) {
			String busNames = busList.get(i).getText();
			String busPrices = price.get(i).getText();
			System.out.println(busNames+"  "+busPrices);
			
		}
		driver.close();
	}

	}

	
 
