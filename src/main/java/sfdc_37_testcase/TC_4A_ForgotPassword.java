package sfdc_37_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_4A_ForgotPassword {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		
		WebElement fpwd = driver.findElement(By.xpath("//*[@id='forgot_password_link']"));
		fpwd.click();
		
		System.out.println("Forgot your password");
		System.out.println("Having trouble logging in?");
		System.out.println("Usernames are in the form of an email address");
		System.out.println("Passwords are case sensitive");
		System.out.println("Sandbox Login");
		
		WebElement uname = driver.findElement(By.xpath("//input[@id='username']"));
		System.out.println("To reset your password, enter your Salesforce username.");
		uname.sendKeys("kn1@abc.com");
		
		WebElement continueButton = driver.findElement(By.xpath("//*[@id='continue']"));
		continueButton.submit();
		
		Thread.sleep(5000);
		
		WebElement emailSentMessage = driver.findElement(By.xpath("//div[contains('message','We've sent you an email with a link to finish resetting your password')]"));
		System.out.println(emailSentMessage.getText());
		
		driver.quit();
	}
	
	}
