package selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElement2_ActionsClass {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//BrowserDriver//chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		
		driver.manage().window().maximize();	
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		
		WebElement interactions = driver.findElement(By.xpath("//*[text()='Interactions ']"));
		WebElement drafanddrop = driver.findElement(By.xpath("//*[text()='Drag and Drop ']"));
		WebElement staticc = driver.findElement(By.xpath("//*[text()='Static ']"));
		
		act.moveToElement(interactions).click()
			.moveToElement(drafanddrop).click()
			.moveToElement(staticc).click().build().perform();
		
		
		Thread.sleep(5000);
		driver.close();
	}
}