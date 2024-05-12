package selenium;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows3 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Windows.html");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[contains(text(),'Multiple Windows')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Multiple']//button")).click();
		
		Set<String> s = driver.getWindowHandles();
		System.out.println(s);
		
		
		Thread.sleep(10000);
		driver.quit();
	}
}