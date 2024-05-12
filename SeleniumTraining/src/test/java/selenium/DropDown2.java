package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown2 {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromiumdriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(5000);
		WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
		from.click();
		Thread.sleep(5000);
		from.sendKeys("Sydney");
		Thread.sleep(5000);
		from.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(5000);
		from.sendKeys(Keys.ENTER);
		
		
		Thread.sleep(5000);
		driver.close();
	}

}
