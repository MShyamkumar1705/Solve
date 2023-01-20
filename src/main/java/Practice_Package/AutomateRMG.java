package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateRMG {
	
	public static void main(String[] args) throws SQLException, InterruptedException {
  WebDriverManager.chromedriver().setup();
  WebDriver driver = new ChromeDriver();
  Connection con=null;
  String project_name="HRM System";
  
  try {
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  driver.get("http://rmgtestingserver:8084/");
	  //Thread.sleep(8000);
	  driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	  driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	  driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	  driver.findElement(By.xpath("//a[text()='Projects']")).click();
	  driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	  driver.findElement(By.name("projectName")).sendKeys("HRM System Solution");
	  Thread.sleep(2000);
	  //driver.   (By.name("teamSize")).sendKeys("3");
	  Thread.sleep(2000);
	  driver.findElement(By.name("createdBy")).sendKeys("Deepak");
	  Thread.sleep(2000);
	  WebElement projectStatus = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
	  Select s=new Select(projectStatus);
	  s.selectByVisibleText("Created");
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//input[@value='Add Project']")).click();


	  Driver driver1=new Driver();
	  DriverManager.registerDriver(driver1);
	  con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
	  Statement state=con.createStatement();
	  String query="select * from project;";
	  ResultSet result = state.executeQuery(query);
	  boolean flag=false;
	  while(result.next()) {
	  	String actualProject=result.getString(4);
	  	System.out.println(actualProject);
	  	if(actualProject.equalsIgnoreCase(project_name)) {
	  		flag=true;
	  		break;
	  	}
	  }
	  if(flag) {
	  	System.out.println("Project is created successfully");
	  }
	  else {
	  	System.out.println("Project is not created");
	  }
  }
catch (Exception e) {
e.printStackTrace();
}
finally {
	con.close();
	System.out.println("Data Base is closed");
}
	}
}

	
















