package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssert {
	
	@Test
	public void testTitle() throws Exception {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		
		String expectedTitle="Electronics, Cars, Fashion, Collectibles & More | eBay";
		String expectedBtnTitle = "Search";
		
		String actualTitle = driver.getTitle();
		String actualBtnText = driver.findElement(By.xpath("//*[@id='gh-btn']")).getAttribute("value");
		
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertEquals(actualBtnText, expectedBtnTitle);
		
		Thread.sleep(5000);
		driver.close();
	}
}
