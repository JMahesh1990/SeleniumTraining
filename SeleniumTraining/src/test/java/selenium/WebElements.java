package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElements {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromiumdriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("Mahesh");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='user-name']")).clear();
		String attributeClass = driver.findElement(By.xpath("//*[@id='user-name']")).getAttribute("class");
		System.out.println(attributeClass);
		String cssValue = driver.findElement(By.xpath("//*[@id='user-name']")).getCssValue("font-family");
		System.out.println(cssValue);
		
		Dimension size = driver.findElement(By.xpath("//*[@id='login-button']")).getSize();
		System.out.println(size);
		
		Point location = driver.findElement(By.xpath("//*[@id='login-button']")).getLocation();
		System.out.println(location);
		
		String text = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
		System.out.println(text);
		
		String tagName = driver.findElement(By.xpath("//*[@id='login-button']")).getTagName();
		System.out.println(tagName);
		
		System.out.println(driver.findElement(By.xpath("//*[@id='login-button']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id='login-button']")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//*[@id='login-button']")).isSelected());
	}
}