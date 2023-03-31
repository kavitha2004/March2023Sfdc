package sfdc_37_testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_6_SelectMyProfile {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();//defined as abstract method in the interface
		//driver.launchApp("");
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		
		WebElement uname = driver.findElement(By.xpath("//input[@id='username']"));
		uname.sendKeys("kn@abc1.com");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		pwd.sendKeys("testing2");
		
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		login.click();
		
		//Thread.sleep(3000);
		//navigate to the user menu
		WebElement userMenu = driver.findElement(By.xpath("//*[@id='userNavLabel']"));
		userMenu.click();
		
		//verify the dropdown menu contains the expected options
		WebElement myProfileOption = driver.findElement(By.cssSelector("#userNav-menuItems > a:nth-child(1)"));
		WebElement mySettingsOption = driver.findElement(By.cssSelector("#userNav-menuItems > a:nth-child(2)"));
		WebElement developerConsoleOption = driver.findElement(By.cssSelector("#userNav-menuItems > a:nth-child(3)"));
		WebElement lightningExperienceOption = driver.findElement(By.cssSelector("#userNav-menuItems > a:nth-child(4)"));
		WebElement logoutOption = driver.findElement(By.cssSelector("#userNav-menuItems > a:nth-child(5)"));
		if(myProfileOption.isDisplayed() && mySettingsOption.isDisplayed() && developerConsoleOption.isDisplayed() 
				&& lightningExperienceOption.isDisplayed() && logoutOption.isDisplayed()) {
			System.out.println("User Menu dropdown is displayed with the expected options");
		} else {
			System.out.println("User Menu dropdown is not displayed with the expected options");
		}
		
		Thread.sleep(4000);
		
		// go to my profile page 
		myProfileOption.click();
		
		Thread.sleep(3000);
	
		//to edit my profile, click on user action menu dropdown in the profile page
		WebElement userActionMenu = driver.findElement(By.id("moderatorMutton"));
		userActionMenu.click();
		
		//click on edit button next to contact button
		WebElement editProfileButton = driver.findElement(By.xpath("//div[@class='vfButtonBarButton']"));	
		editProfileButton.click();
		
		//WebElement editContactButton = driver.findElement(By.cssSelector(".aboutMeLaunch"));
		WebElement aboutTab = driver.findElement(By.id("aboutTab"));
		aboutTab.click();
		
		//find the last name
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("abcd");
		
		//find and click save all button
		WebElement saveallButton = driver.findElement(By.cssSelector("input.zen-btn:nth-child(1)"));
		saveallButton.click();
		
		//Click on the Post 
		WebElement postTab = driver.findElement(By.xpath("//*[@id='publisherAttachTextPost']"));
		postTab.click();
		
		//Find the post text area, enter the text and click on the share button
		String textToPost = "Hello";
		WebElement postTextArea = driver.findElement(By.cssSelector(".cke_wysiwyg_frame"));
		postTextArea.sendKeys(textToPost);
		
		WebElement shareButton = driver.findElement(By.xpath("//*[@id='publishersharebutton']]"));
		shareButton.click();
		
		WebElement postedText = driver.findElement(By.xpath("//*[@class='feeditemcontent cxfeeditemcontent']"));
		
		if(postedText.getText().equals(textToPost)) {
			System.out.println("Successfully posted the text and it is displayed on the page");
		}else {
			System.out.println("Entered text is not displayed on the page");
		}
				
		// Click on the file link and upload a file from the computer
		WebElement fileLink = driver.findElement(By.xpath("//*[@id='publisherAttachContentPost']"));
		fileLink.click();
		
		WebElement uploadButton = driver.findElement(By.xpath("//*[@id='chatterUploadFileAction']"));
		System.out.println("Click on Upload a file from your computer. ");
		uploadButton.click();
		
		Actions chooseFileButton = new Actions(driver);
		chooseFileButton.sendKeys("/Users/navin/tekarch/Test document.pages");
		
		Actions openButton = new Actions(driver);
		openButton.click();
		
		WebElement shareButton1 = driver.findElement(By.xpath("*//[@id='publishersharebutton']"));
		shareButton1.click();
		
		// Upload a profile photo
		WebElement myProfilePhoto = driver.findElement(By.id("//a[@href='javascript: void(0);'onclick='whatToDoNext.uploadPhoto()']"));
	
		Actions actions = new Actions(driver);
		actions.moveToElement(myProfilePhoto).perform();

		WebElement addPhotoLink = driver.findElement(By.xpath("//a[contains(text(), 'Add photo')]"));
		addPhotoLink.click();
		
		WebElement chooseFileButton2 = driver.findElement(By.xpath("//input[@type='file']"));
		chooseFileButton2.sendKeys("/photos/IMG_3896.HEIC");
		WebElement cropButton = driver.findElement(By.xpath("//button[contains(text(), 'Crop')]"));
		cropButton.click();
		
		// Close the browser
		//Thread.sleep(5000);
		System.out.println("TC_6_MyProfile is Completed Successfully");
		driver.quit();
	}
}

