package selenium;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		takeScreenshot(driver);
		
		driver.findElement(By.xpath("//*[text()='WebTable']")).click();
		Thread.sleep(2000);
		takeScreenshot(driver);
		
		driver.findElement(By.xpath("//*[text()='Practice Site']")).click();
		Thread.sleep(2000);
		takeScreenshot(driver);
		
		
		Thread.sleep(5000);
		driver.close();
		
	}
	
	public static void takeScreenshot(WebDriver driver) throws Exception {
		String pattern = "dd-MM-yyyy_hh-mm-ss_a";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(new Date());
		System.out.println("File Name - "+date);
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File (".//Screenshot/"+date+".jpg"));
	}
}