package proj;

import java.awt.AWTException;

//import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.salesforce.com");
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.id("username"));
		/*Keyboard keyboard = ((HasInputDevices)driver).getKeyboard();
		keyboard.pressKey("a");
		keyboard.pressKey("b");
		keyboard.pressKey("c");
		keyboard.pressKey(Keys.NUMPAD1);// number pad
		keyboard.pressKey(Keys.chord("x","y","z"));
		keyboard.pressKey(Keys.chord(Keys.CONTROL,"t"));//new tab
		keyboard.pressKey(Keys.F5);//to refresh
		*/
	}

}
