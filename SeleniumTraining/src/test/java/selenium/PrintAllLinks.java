package selenium;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class PrintAllLinks {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id='login-button']")).click();
		
		List<WebElement> element = driver.findElements(By.xpath("//a"));
		int size = element.size();
		
		for(int i=0; i<size; i++) {
			System.out.println(element.get(i).getText() +" : "+element.get(i).getAttribute("href"));
		}
		
		
		List<WebElement> option = driver.findElements(By.tagName("option"));
		for(int i=0; i<option.size(); i++) {
			System.out.println(option.get(i).getText() +" : "+option.get(i).getAttribute("value"));
		}
		
		Thread.sleep(5000);
		driver.close();
	}
}