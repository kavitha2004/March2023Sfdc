package proj;

	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;
	
	public class Xpath3 {
		
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();//defined as abstract method in the interface
			
			driver.get("https://www.google.com");
			//driver.manage().window().maximize();
			Thread.sleep(3000);
			WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
			search.sendKeys("selenium");
			Thread.sleep(3000);
			//List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'wM6W7d') and contains(@role,'presentation')]"));
			List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//child::span)[position() mod 2=1]"));
			
			for (WebElement ele : list) {
				System.out.println(ele.getText());
			}
			search.submit();
			
			driver.close();
	}
		
	}
