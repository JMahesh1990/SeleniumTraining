package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumStudy1 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.singaporeair.com/en_UK/in/home#/book/bookflight");
		Thread.sleep(2000);
		
		WebElement booknow = driver.findElement(By.xpath("//*[text()='Book Now']"));
		Actions a = new Actions(driver);
		a.moveToElement(booknow);
		a.build().perform();
		
		int noOfRadioButtons = driver.findElements(By.xpath("//*[@type='radio']")).size();
		System.out.println(noOfRadioButtons);
		
		Boolean r1 = driver.findElement(By.xpath("//*[@id='bookFlights']")).isSelected();
		System.out.println(r1);
		
		Boolean r2 = driver.findElement(By.xpath("//*[@id='redeemFlights']")).isSelected();
		System.out.println(r2);
		
		WebElement from = driver.findElement(By.xpath("//*[@id='flightOrigin1']"));
		from.click();
		Thread.sleep(2000);
		from.sendKeys("Sydney");
		Thread.sleep(2000);
		from.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		from.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		WebElement to =  driver.findElement(By.xpath("//*[@id='bookFlightDestination']"));
		to.click();
		Thread.sleep(2000);
		to.sendKeys("Pune");
		Thread.sleep(2000);
		to.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		to.sendKeys(Keys.ENTER);
		
		
		
		
		Thread.sleep(5000);
		driver.close();
	}

}
