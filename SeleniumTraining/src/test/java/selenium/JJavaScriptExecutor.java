package selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JJavaScriptExecutor {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		
		driver.get("https://demo.guru99.com/V4/");
		WebElement txt_username = driver.findElement(By.xpath("//*[@name='uid']"));
		WebElement txt_password = driver.findElement(By.xpath("//*[@name='password']"));
		driver.findElement(By.xpath("//*[@name='password']"));
		WebElement btn_login = driver.findElement(By.xpath("//*[@value='LOGIN']"));
		WebElement btn_reset = driver.findElement(By.xpath("//*[@value='RESET']"));
		
		js.executeScript("arguments[0].value='Mahesh';", txt_username);
		js.executeScript("arguments[0].value='Jejurkar';", txt_password);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", btn_login);
		
		Thread.sleep(2000);
		String str = driver.switchTo().alert().getText();
		System.out.println(str);
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	
		Thread.sleep(5000);
		driver.close();
	}
}
