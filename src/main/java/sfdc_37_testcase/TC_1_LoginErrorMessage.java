package sfdc_37_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_1_LoginErrorMessage {
		
	static WebDriver driver;
	
	public static void main (String[] args) throws Exception {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();//defined as abstract method in the interface
		//driver.launchApp("");
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		//Thread.sleep(3000);
		
		WebElement uname = driver.findElement(By.id("username"));
		uname.sendKeys("kn@abc1.com");
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("testing2");
		
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
		
		String actual = driver.findElement(By.xpath("//@[id='error')")).getText();
		String expected = "Please check your username and password.If you still can't log in, contact "
				+ "your Salesforce administrator... ";
		if(actual.equals(expected))
		{
			System.out.println("Error message is displayed");
		}
		else {
			System.out.println("Error message is not displayed");
		}
		driver.close();
		System.out.println("TC_1 Login Error Message Test is Completed");
	}	

	}


