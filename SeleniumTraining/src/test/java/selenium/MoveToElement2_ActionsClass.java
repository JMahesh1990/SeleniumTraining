package selenium;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElement2_ActionsClass {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//BrowserDriver//chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();	
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		
		WebElement interactions = driver.findElement(By.xpath("//*[text()='Interactions ']"));
		WebElement drafanddrop = driver.findElement(By.xpath("//*[text()='Drag and Drop ']"));
		WebElement staticc = driver.findElement(By.xpath("//*[text()='Static ']"));
		
		act.moveToElement(interactions).click()
			.moveToElement(drafanddrop).click()
			.moveToElement(staticc).click().build().perform();
		
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,400)");
		
		WebElement angular = driver.findElement(By.xpath("//*[@id='angular']"));
		WebElement mongo = driver.findElement(By.xpath("//*[@id='mongo']"));
		WebElement node = driver.findElement(By.xpath("//*[@id='node']"));
		WebElement droparea = driver.findElement(By.xpath("//*[@id='droparea']"));
		
		act.dragAndDrop(angular, droparea).build().perform();
		act.dragAndDrop(mongo, droparea).build().perform();
		act.dragAndDrop(node, droparea).build().perform();
		
		Thread.sleep(5000);
		driver.close();
	}
}