package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iFrame {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Frames.html");
		Thread.sleep(5000);
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Mahesh");
		
		
		Thread.sleep(5000);
		driver.close();
	}
}