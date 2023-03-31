package sfdc_37_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_2_LoginToSalesForce {
		
		static WebDriver driver;
		
		public static void main(String[] args) throws InterruptedException {
			//System.setProperty("webdriver.gecko.driver","/Users/navin/Downloads/geckodriver.exe");
			//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			//capabilities.setCapability("marionette",true);
			
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
			
			Thread.sleep(5000);
			driver.close();
			
		}	
	}
