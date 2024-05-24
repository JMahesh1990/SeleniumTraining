package selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.get("https://www.javatpoint.com/");
		Thread.sleep(2000);
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		WebElement aboutMe = driver.findElement(By.xpath("//*[text()='About Me']"));
		Thread.sleep(2000);
		
		act.clickAndHold(aboutMe).build().perform();
		Thread.sleep(2000);
		act.click().build().perform();
		
		Thread.sleep(5000);
		driver.close();
	}
}