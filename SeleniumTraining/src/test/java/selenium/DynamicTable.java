package selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.http.factory", "jdk-http-client");

		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/stocks/marketstats/index.php");

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='topgain_bse']//tbody//tr")));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='topgain_bse']//tbody//tr[1]/td")));

		int rowcount = driver.findElements(By.xpath("//*[@id='topgain_bse']//tbody//tr")).size();
		int columncount = driver.findElements(By.xpath("//*[@id='topgain_bse']//tbody//tr[1]/td")).size();

		for (int i = 1; i <= rowcount; i++) {
			for (int j = 1; j <= columncount; j++) {
				String tabledata = driver.findElement(By.xpath("//*[@id='topgain_bse']//tbody//tr[" + i + "]/td[" + j + "]")).getText();
				System.out.print(tabledata + "\t");
			}
			System.out.println();
		}

		Thread.sleep(5000);
		driver.close();
	}
}