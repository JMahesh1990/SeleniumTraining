package selenium;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelect {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://output.jsbin.com/osebed/2");
		
		Thread.sleep(5000);
		
		WebElement multiselect = driver.findElement(By.xpath("//*[@id='fruits']"));
		Select s = new Select(multiselect);
		s.selectByVisibleText("Banana");
		Thread.sleep(5000);
		
		s.selectByValue("apple");
		Thread.sleep(5000);
		
		s.selectByIndex(2);
		Thread.sleep(5000);
		
		s.selectByVisibleText("Grape");
		Thread.sleep(5000);
		
		List<WebElement> selectedFruits = s.getAllSelectedOptions();
		int size = selectedFruits.size();
		
		for(int i=0; i<size; i++) {
			String element = selectedFruits.get(i).getText();
			System.out.println(element);
		}
	
		
		Thread.sleep(5000);
		s.deselectByIndex(3);
		
		Thread.sleep(5000);
		s.deselectByVisibleText("Orange");
		
		Thread.sleep(5000);
		s.deselectAll();
		
		Thread.sleep(5000);
		driver.close();
		
	}
}