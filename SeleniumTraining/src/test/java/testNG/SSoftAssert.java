package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSoftAssert {

	@Test
	public void textSoftAssert() throws Exception {
		SoftAssert sa = new SoftAssert();
		
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Launching application...");
		driver.get("https://www.ebay.com/");
		Thread.sleep(2000);
		
		String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		String expectedBtnText = "Search";
		
		String actualTitle = driver.getTitle();
		String actualBtnText = driver.findElement(By.xpath("//*[@id='gh-btn']")).getAttribute("value");
		
		System.out.println("Verifying title...");
		sa.assertEquals(actualTitle, expectedTitle);
		
		System.out.println("Verifying button text...");
		sa.assertEquals(actualBtnText, expectedBtnText);
		
		sa.assertAll();
		
		Thread.sleep(5000);
		System.out.println("Closing browser...");
		driver.close();
	}
}
