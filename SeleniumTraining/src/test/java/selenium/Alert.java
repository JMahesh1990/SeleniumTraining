package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.automationtesting.in/Alerts.html");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='OKTab']/button")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		driver.switchTo().parentFrame();
		
		driver.findElement(By.xpath("//*[text()='Alert with Textbox ']")).click();
		driver.findElement(By.xpath("//*[@id='Textbox' ]/button")).click();
		driver.switchTo().alert().sendKeys("Mahesh");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		driver.switchTo().parentFrame();
		
		driver.findElement(By.xpath("//*[text()='Alert with OK & Cancel ']")).click();
		driver.findElement(By.xpath("//*[@id='CancelTab']//button")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		driver.switchTo().parentFrame();
		driver.getTitle();
		
		Thread.sleep(5000);
		driver.close();
	}
}