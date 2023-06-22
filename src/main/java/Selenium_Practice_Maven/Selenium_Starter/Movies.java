package Selenium_Practice_Maven.Selenium_Starter;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Movies {
	
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
	
	public void testCase04() {
		driver.get("https://in.bookmyshow.com/explore/home/chennai");
		
		List<WebElement> imgURL = driver.findElements(By.tagName("img"));
		
		for(WebElement element : imgURL) {
			System.out.println(element.getAttribute("src"));
			
		}
		System.out.println("2nd element of list " + imgURL.get(1));
	}
	
	public void testCase05() {
		
		driver.get("https://in.bookmyshow.com/explore/home/chennai");
		
		List<WebElement> premiere = driver.findElements(By.xpath("//div[@class='sc-lnhrs7-4 lkiZOG']/div/a"));
		
//		for(WebElement element : premiere) {
//			String listElement = element.getText();
//			
//			System.out.println(listElement);
//		}
		System.out.println(premiere.size());
		//System.out.println(premiere.get(1).getText());
	}

}
