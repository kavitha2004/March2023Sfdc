package proj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
	
	public class Table {

		public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			driver.get("http://www.salesforce.com");
			driver.manage().window().maximize();
			
			//WebElement username = driver.findElement(By.xpath(""));
			//WebElement password = driver.findElement(By.xpath(""));
			
			WebElement username = driver.findElement(By.cssSelector(null));
			WebElement password = driver.findElement(By.cssSelector(null));
		}
}
