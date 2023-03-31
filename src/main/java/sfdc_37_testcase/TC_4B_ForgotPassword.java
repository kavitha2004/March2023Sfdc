package sfdc_37_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_4B_ForgotPassword {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		
		WebElement uname = driver.findElement(By.xpath("//input[@id='username']"));
		uname.sendKeys("123");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		pwd.sendKeys("22131");

		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		login.click();
		
		Thread.sleep(2000);
		
		WebElement errorMessage = driver.findElement(By.xpath("//div[contains('LoginError',"
				+ "'Please check your username and password. If you still can't log in, contact your Salesforce "
				+ "administrator.')]"));
		System.out.println(errorMessage.getText());
		
		driver.close();
	}

}
