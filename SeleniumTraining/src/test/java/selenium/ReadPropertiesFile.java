package selenium;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadPropertiesFile {

	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\PropertiesFile\\testdata.properties");
		p.load(fis);
		String url = p.getProperty("url");
		System.out.println(url);
		
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get(url);
		
		Thread.sleep(2000);
		String title = driver.getTitle();
		
		Thread.sleep(2000);
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\PropertiesFile\\testdata.properties");
		p.setProperty("Title", title);
		p.store(fos,"");
		
		
		Thread.sleep(5000);
		driver.close();
	}
}
