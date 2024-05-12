package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDataProvider2 {
	
	@Test(dataProvider = "Credentials")
	public void login(String username, String password) throws Exception {
		System.out.println(username +" : "+password);
		
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='login-button']")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
	
	@DataProvider (name = "Credentials")
	public Object[][] dataSet() {
		Object[][] dataset = new Object[4][2];
		
		dataset[0][0] = "standard_user";
		dataset[0][1] = "secret_sauce";
		
		dataset[1][0] = "locked_out_user";
		dataset[1][1] = "secret_sauce";
		
		dataset[2][0] = "problem_user";
		dataset[2][1] = "secret_sauce";
		
		dataset[3][0] = "performance_glitch_user";
		dataset[3][1] = "secret_sauce";
		
		
		return dataset;
	}
}