package selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop2_ActionsClass {

	public static void main(String[] args) throws Exception {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//BrowserDriver//chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		Actions act = new Actions(driver);
		
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Static.html");
		System.out.println(driver.getTitle());
		
		WebElement angular = driver.findElement(By.xpath("//*[@id='angular']"));
		WebElement mongo = driver.findElement(By.xpath("//*[@id='mongo']"));
		WebElement node = driver.findElement(By.xpath("//*[@id='node']"));
		
		WebElement droparea = driver.findElement(By.xpath("//*[@id='droparea']"));
		
		Thread.sleep(2000);
		
		act.dragAndDrop(angular, droparea).build().perform();
		Thread.sleep(2000);
		act.dragAndDrop(mongo, droparea).build().perform();
		Thread.sleep(2000);
		act.dragAndDrop(node, droparea).build().perform();

		act.build().perform();
		
		
		Thread.sleep(5000);
		//driver.close();
	}

}