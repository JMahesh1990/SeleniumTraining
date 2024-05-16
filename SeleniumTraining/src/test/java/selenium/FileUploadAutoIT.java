package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class FileUploadAutoIT {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//BrowserDriver//chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get("https://demo.automationtesting.in/FileUpload.html");
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		WebElement browserFile = driver.findElement(By.xpath("//*[@id='input-4']"));
		
		act.moveToElement(browserFile).click().build().perform();
		
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"//InputFiles//FileUpload.exe");
		
		
		Thread.sleep(7000);
		driver.close();
		

	}

}