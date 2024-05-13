package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) throws Exception {
		String expected_my = "February 2024";
		String day = "24";
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//BrowserDriver//chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='datepicker1']")).click();
		
		while (true) {
			Thread.sleep(2000);
			String month = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/span[1]")).getText();
			String year = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/span[2]")).getText();
			String actual_my = month.concat(" ").concat(year);
			
			if(actual_my.equals(expected_my)) {
				break;
			}else {
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[1]/span")).click();
			}			
		}
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+day+")]")).click();
		
		Thread.sleep(5000);
		driver.close();

	}
}