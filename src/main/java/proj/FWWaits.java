package proj;

import java.time.Duration;
import java.util.NoSuchElementException;

//import org.apache.xpath;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import dev.failsafe.internal.util.Durations;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FWWaits {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();//defined as abstract method in the interface
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.id("login")).click();
		
		Thread.sleep(30);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('LEAVING THIS PAGE')");
		
		WebElement pass = driver.findElement(By.id("password"));
		js.executeScript("arguments[0].value= 'Salesforce1@';",pass);
		
		WebElement loginButton = driver.findElement(By.id("Login"));
		js.executeScript("arguments[0].click();", loginButton);
		
		js.executeScript("arguments[0].setAttribute('id','SIGNIN')", loginButton);
		
		String attrValue = js.executeScript("arguments[0].getAttribute('id')", loginButton).toString();
		System.out.println(attrValue);
		
		String title = js.executeScript("return document.title;").toString();
		js.executeScript("window.scrollTo(0,900);");
		
		driver.findElement(By.xpath("//*[text()='Oppurtunities']")).click();
		driver.findElement(By.xpath("//*[@value='Run Report']")).click();
		
		for(int rows = 1; rows <20; rows++) {	//camel font where letter of first 
			//word is lowercase and the second word starts with upper case
		for(int cd = 1; cd < 15; cd++) {
			WebElement data = driver.findElement(By.xpath("//table[@class='reportTable tabularReportTable']/tbody/tr[" +rows+"]/td["+cd+"]"));
					System.out.println(data.getText()+"\t");
		}
		}
				
		//table[@class="reportTable tabularReportTable']/tbody/tr[2]/td[2]
		/*Wait<WebDriver> fw = new FluentWait<WebDriver> (driver)	
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		WebElement element = Wait.until(new Function<WebDriver,WebElement>() {
			
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id(""));
				}
			});*/
	}

}
