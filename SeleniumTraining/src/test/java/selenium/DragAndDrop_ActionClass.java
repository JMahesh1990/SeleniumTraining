package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop_ActionClass {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		
		driver.manage().window().maximize();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		Thread.sleep(5000);
		
		WebElement Washington = driver.findElement(By.xpath("//*[text()='Washington' and @id='box3']"));
		WebElement Copenhagen = driver.findElement(By.xpath("//*[text()='Copenhagen' and @id='box4']"));
		WebElement Oslo = driver.findElement(By.xpath("//*[text()='Oslo' and @id='box1']"));
		WebElement Madrid = driver.findElement(By.xpath("//*[text()='Madrid' and @id='box7']"));
		WebElement Rome	= driver.findElement(By.xpath("//*[text()='Rome' and @id='box6']"));
		WebElement Seoul = driver.findElement(By.xpath("//*[text()='Seoul' and @id='box5']"));
		WebElement Stockholm = driver.findElement(By.xpath("//*[text()='Stockholm' and @id='box2']"));
		
		
	 	WebElement US = driver.findElement(By.xpath("//*[text()='United States']"));
	 	WebElement Italy = driver.findElement(By.xpath("//*[text()='Italy']"));
	 	WebElement Spain = driver.findElement(By.xpath("//*[text()='Spain']"));
	 	WebElement Norway = driver.findElement(By.xpath("//*[text()='Norway']"));
	 	WebElement Denmark = driver.findElement(By.xpath("//*[text()='Denmark']"));
	 	WebElement SK = driver.findElement(By.xpath("//*[text()='South Korea']"));
	 	WebElement Sweden = driver.findElement(By.xpath("//*[text()='Sweden']"));
	 	
	 	act.dragAndDrop(Washington, US).build().perform();
		act.dragAndDrop(Copenhagen, Denmark).build().perform();
		act.dragAndDrop(Seoul, SK).build().perform();
		act.dragAndDrop(Madrid, Spain).build().perform();
		act.dragAndDrop(Rome, Italy).build().perform();
		act.dragAndDrop(Oslo, Norway).build().perform();
		act.dragAndDrop(Stockholm, Sweden).build().perform();
		
		Thread.sleep(5000);
		driver.close();
	}
}