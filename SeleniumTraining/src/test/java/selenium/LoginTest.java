package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static WebDriver driver;
	public static String browser = "Chrome";
	
	@Parameters("browser")
	@Test
	public void Login (String browser) throws Exception {
		if(browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			driver = new ChromeDriver();
		}
		else if(browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id='login-button']")).click();
		
		Thread.sleep(5000);
		driver.close();
	}
}