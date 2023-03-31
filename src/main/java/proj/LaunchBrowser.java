package proj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.Set;

//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	public static void main(String[] args) throws InterruptedException {
		//firefoxdriver
		//WebDriver manager;
		System.setProperty("webdriver.gecko.driver","//Users//navin//Downloads//gecko.exe");
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		//Button Click
		WebElement login = driver.findElement(By.id("button-login"));
		login.click();
		//search.sendKeys("Selenium");
		//search.submit();
		
		//Enter text in TextBox
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("abc@gmail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("abcgdhh");
		
		List<WebElement> radio_button = driver.findElements(By.name("software"));
		//radio button
		boolean bvalue;
		bvalue = radio_button.get(0).isSelected();
		
		if(bvalue == false)
		{
			radio_button.get(1).click();	
		}
		else
		{
			System.out.println("It is already selected, Select other option");	
		}
		
		//Select from dropdown menu - using amazon, xpath by right click, copy option
		
		WebElement selectMenu = driver.findElement(By.xpath("////*[@id=\"searchDropdownBox\"]"));
		
	Select select = new Select(selectMenu);
	//select.selectByVisibleText("Baby");
	
	//select.selectByValue("/html/head/meta[4]"); select books
	select.selectByIndex(2); // selects the 3rd option in dropdown menu
	
	//Mouse Hover or tool tip
	WebElement account = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]/span"));
	account.click();
	
	//Action action = new Action();
	//action.moveToElement(account).build().perform();
	
	WebElement usermenu = driver.findElement(By.id("userNavLabel"));
	usermenu.click();
	
	WebElement devConsole = driver.findElement(By.cssSelector(".debugLogLink.menuButtonMenuLink"));
	devConsole.click();
	
	Thread.sleep(6000);
	String currentTab = driver.getWindowHandle();
	Set<String> tabs = driver.getWindowHandles();
	tabs.remove(currentTab);
	String newTab="";
	
	for(String string : tabs) {
		System.out.println("Tab ID : "+string);
		newTab = string;
	}
	
	driver.switchTo().window(newTab);
	
	
	
	driver.close();
	driver.switchTo().window(currentTab);
	driver.close();
	
	}
}

