package proj;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FullTable {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.espncricinfo.com/series/australia-in-india-2022-23-1348637/india-vs-australia-3rd-odi-1348658/live-cricket-score");
		driver.manage().window().maximize();
		
		//Handling web table
		WebElement table = driver.findElement(By.xpath("/html/body/div[1]/section/section/div[3]/div/div/div[2]/div[3]/div[1]/div/div/div[1]/div/table"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for(int rnum=0;rnum<rows.size();rnum++)
		{
			List<WebElement> header = rows.get(rnum).findElements(By.tagName("th"));
			
		}
	}

}
