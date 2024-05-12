package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(10000);
		
		WebElement switchTo = driver.findElement(By.xpath("//*[(text()='SwitchTo')]"));
		act.moveToElement(switchTo).perform();
		
		Thread.sleep(5000);
		WebElement widgets = driver.findElement(By.xpath("//*[(text()='Widgets')]"));
		act.moveToElement(widgets).perform();
		
		Thread.sleep(5000);
		WebElement interactios = driver.findElement(By.xpath("//*[(text()='Interactions ')]"));
		act.moveToElement(interactios).perform();
		
		Thread.sleep(5000);
		WebElement wysiwyg = driver.findElement(By.xpath("//*[(text()='WYSIWYG')]"));
		act.moveToElement(wysiwyg).perform();
		
		Thread.sleep(5000);
		WebElement more = driver.findElement(By.xpath("//*[(text()='More')]"));
		act.moveToElement(more).perform();
		
		Thread.sleep(10000);
		driver.close();
	}
}