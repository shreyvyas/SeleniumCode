package Selenium_Practice_Maven.Selenium_Starter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkedinPost {
	
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
	
	public void testCase03() throws InterruptedException {
		//open linkedin
		driver.get("https://www.linkedin.com/home");
		
			
		//click on Sign in button
		//WebElement signIn = driver.findElement(By.linkText("Sign in"));
		//.click();
		
		//Thread.sleep(2000);
		
		//enter email address and password
		WebElement email = driver.findElement(By.xpath("//*[@id='session_key']"));
	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(email));
		
		email.sendKeys("XXXXXXXXX");
		
		WebElement password = driver.findElement(By.id("session_password"));
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys("@@#@#XXXX");
		
		WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		signInButton.click();
		
		WebElement viewCount = driver.findElement(By.xpath("//ul[@class='entity-list row']/li[1]/a/div/div[2]/span/strong"));
		String number = viewCount.getText();
		System.out.println(number);
	}
	
	public void testCase06() {
		
		driver.get("https://www.linkedin.com/home");			

		WebElement email = driver.findElement(By.xpath("//*[@id='session_key']"));
	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(email));
		
		email.sendKeys("shrXXXXX@XXXXXX");
		
		WebElement password = driver.findElement(By.id("session_password"));
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys("XXXXXXXX");
		
		WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		signInButton.click();
		
		WebElement post = driver.findElement(By.id("ember25"));
		post.click();
		
		WebElement postEditor = driver.findElement(By.cssSelector(".ql-blank"));
		postEditor.sendKeys("Shrey");
		
		WebElement postButton = driver.findElement(By.xpath("//div[@class='share-box_actions']/button"));
		postButton.click();
		
	}
	
	public void endTest() {
		driver.quit();
	}

}
