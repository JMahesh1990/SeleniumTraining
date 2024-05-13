package selenium;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverMethods {

	public static WebDriver driver;
	public static String browser = "Chrome";

	public static void main(String[] args) throws Exception {
		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			driver = new FirefoxDriver();
		} else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

		String sauceMainWindowHandle = driver.getWindowHandle();
		System.out.println(sauceMainWindowHandle);

		driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id='login-button']")).click();

		/*
		 * String url = driver.getCurrentUrl(); System.out.println(url);
		 * 
		 * String title = driver.getTitle(); System.out.println(title);
		 * 
		 * String pageSource = driver.getPageSource(); System.out.println(pageSource);
		 */
		List<WebElement> webelements = driver.findElements(By.xpath("//div[@class='inventory_item']"));
		System.out.println(webelements);

		driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String hyrMainWindowHandle = driver.getWindowHandle();
		System.out.println(hyrMainWindowHandle);
		driver.findElement(By.xpath("//*[@id='newWindowBtn']")).click();
		Set<String> hyrWindowHandles = driver.getWindowHandles();
		System.out.println(hyrWindowHandles);
		
		Iterator<String> itr = hyrWindowHandles.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		Thread.sleep(5000);
		driver.switchTo().window(hyrMainWindowHandle);
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys("mahesh");
		
		Thread.sleep(10000);
		driver.quit();
	}

}
