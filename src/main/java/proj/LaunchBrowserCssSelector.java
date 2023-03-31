package proj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowserCssSelector {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.salesforce.com");
		driver.manage().window().maximize();
		
		//Using css selector for 
		WebElement login = driver.findElement(By.cssSelector("head > meta:nth-child(2)"));
		login.click();
	
	}

}
