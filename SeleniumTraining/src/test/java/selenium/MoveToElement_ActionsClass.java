package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElement_ActionsClass {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.javatpoint.com/");
		Thread.sleep(5000);
		WebElement aboutMe = driver.findElement(By.xpath("//*[text()='About Me']"));
		
		Actions a = new Actions(driver);
		a.moveToElement(aboutMe);
		a.build().perform();
		
		Thread.sleep(5000);
		driver.close();
	}
}