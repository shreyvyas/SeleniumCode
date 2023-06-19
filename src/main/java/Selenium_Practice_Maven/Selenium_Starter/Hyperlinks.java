package Selenium_Practice_Maven.Selenium_Starter;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hyperlinks {
	
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
		
	}
	
	public int testCase02() {
		
		//open url
		driver.get("https://in.bookmyshow.com/explore/home/chennai");
		
		//list to store all the hyperlinks
		List<WebElement> hyperlinks = driver.findElements(By.tagName("a"));
		
		int count = hyperlinks.size();
		return count;
		
	}

}
