package Selenium_Practice_Maven.Selenium_Starter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchAmazon {
	
	//Verify Amazon.in is displayed 
	
	WebDriver driver;
	
	public WebDriver createDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}
	
	public void endTest() {
		driver.close();
		driver.quit();
	}
	
	public boolean testCase01() {
		
		//open URL
		driver.get("https://www.google.com/");
		
		//find search box
		WebElement googleSearchBox = driver.findElement(By.id("APjFqb"));
		
		//enter Amazon
		googleSearchBox.sendKeys("Amazon");
		
		//press ENTER
		googleSearchBox.sendKeys(Keys.ENTER);
		
		//validate Amazon.in is displayed
		WebElement amazonText = driver.findElement(By.xpath("//h3[text()='Amazon.in']"));
		
		boolean result = amazonText.isDisplayed();
		return result;
		
	}
	

}
