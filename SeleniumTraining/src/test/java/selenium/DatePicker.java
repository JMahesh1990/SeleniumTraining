package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) throws Exception {
		String expected_date = "February 2024";
		String expected_day = "24";
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//BrowserDriver//chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='datepicker1']")).click();
		
		while (true) {
			Thread.sleep(2000);
			String actual_month = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/span[1]")).getText();
			String actual_year = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/span[2]")).getText();
			String actual_date = actual_month.concat(" ").concat(actual_year);
			
			if(actual_date.equals(expected_date)) {
				break;
			}
			else {
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[1]/span")).click();
			}			
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+expected_day+")]")).click();
		
		Thread.sleep(5000);
		driver.close();

	}
}