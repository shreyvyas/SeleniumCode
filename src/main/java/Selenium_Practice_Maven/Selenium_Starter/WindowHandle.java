package Selenium_Practice_Maven.Selenium_Starter;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
	
	WebDriver driver;
	
	public WindowHandle() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	
	public void openURL() {
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
	}
	
	public void testCase11() {
		
		driver.switchTo().frame("iframeResult");
		
		WebElement tryIt = driver.findElement(By.xpath("//button[contains(text(), 'Try it')]"));
		tryIt.click();
		
		Set<String> allWindow = driver.getWindowHandles();
		Iterator<String> window = allWindow.iterator();
		String parentID = window.next();
		String childID = window.next();
		driver.switchTo().window(childID);
		String childURL = driver.getCurrentUrl();
		System.out.println(childURL);
		String childTitle = driver.getTitle();
		System.out.println(childTitle);
 
		driver.switchTo().window(parentID);
		

	}
	
	public void endTest() {
		//driver.quit();
		//driver.close();
	}

}
