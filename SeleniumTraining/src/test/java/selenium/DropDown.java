package selenium;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) throws Exception {
		//WebDriverManager.chromiumdriver().setup();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//BrowserDriver//chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='login-button']")).click();
		
		Thread.sleep(2000);
		
		WebElement dropdown = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/div/span/select"));
		dropdown.click();

		Select s = new Select (dropdown);
		List<WebElement> op =  s.getOptions();
		int size = op.size();
		
		String firstSelectedOption = s.getFirstSelectedOption().getText();
		System.out.println("First selected option : "+firstSelectedOption);
		
		
		System.out.println("List of options :");
		for(int i=0; i<size; i++) {
			String options = op.get(i).getText();
			System.out.println(options);
		}
		
		Thread.sleep(2000);
		s.selectByVisibleText("Price (high to low)");		
		
		Thread.sleep(5000);
		driver.close();
	}
}