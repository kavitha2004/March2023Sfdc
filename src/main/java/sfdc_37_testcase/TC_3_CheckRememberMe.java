package sfdc_37_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_3_CheckRememberMe {

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		
		WebElement uname = driver.findElement(By.xpath("//input[@id='username']"));
		uname.sendKeys("kn1@abc.com");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		pwd.sendKeys("testing2");
		
		WebElement rme = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		boolean isSelected = rme.isSelected();
		
		if (isSelected == false) {
			rme.click();
		}
		
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		login.submit();
		driver.close();
		
	}

}
