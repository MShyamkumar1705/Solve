package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromCommonProperties {

	public static void main(String[] args) throws IOException {
FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
Properties p=new Properties();
p.load(fis);
String URL = p.getProperty("url");
String BROWSER = p.getProperty("browser");
String USER = p.getProperty("user");
String PASSWORD = p.getProperty("password");
System.out.println(URL);
System.out.println(BROWSER);
System.out.println(USER);
System.out.println(PASSWORD);

	}

}
