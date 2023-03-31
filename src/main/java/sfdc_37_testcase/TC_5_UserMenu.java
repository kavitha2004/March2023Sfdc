package sfdc_37_testcase;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_5_UserMenu {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();//defined as abstract method in the interface
		//driver.launchApp("");
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		//Thread.sleep(3000);
		
		WebElement uname = driver.findElement(By.xpath("//input[@id='username']"));
		uname.sendKeys("kn@abc1.com");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		pwd.sendKeys("testing2");
		
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		login.click();
		
		WebElement userMenu = driver.findElement(By.xpath("//*[@id='userNavLabel']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(userMenu).perform();
		
		List <WebElement> dropdownMenuItems = driver.findElements(By.xpath("//*[@id='userNav-menuitems']//a"));
		//List <WebElement> dropdownMenuItems1 = driver.findElements(By.id("userNav-menuitems"));
		
		List <String> dropdownMenuItems2 = Arrays.asList("My Profile","My Settings", "Developer Console","Switch to Lightning Experience", "Logout");
		System.out.println(dropdownMenuItems);
		System.out.println(dropdownMenuItems2);
		for (WebElement item : dropdownMenuItems)
		{
			System.out.println(item.getText());
		}
		
		System.out.println(dropdownMenuItems);
		driver.close();
	}

}
